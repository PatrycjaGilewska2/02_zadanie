package com.capgemini.jpa.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jpa.domain.entities.AddressEntity;
import com.capgemini.jpa.domain.entities.CarEntity;
import com.capgemini.jpa.domain.entities.ContactDataEntity;
import com.capgemini.jpa.domain.entities.DepartmentEntity;
import com.capgemini.jpa.domain.entities.EmployeeEntity;
import com.capgemini.jpa.domain.tos.DepartmentCreationDataTO;
import com.capgemini.jpa.domain.tos.DepartmentTO;
import com.capgemini.jpa.domain.tos.EmployeeTO;
import com.capgemini.jpa.repository.DepartmentRepository;
import com.capgemini.jpa.repository.EmployeeRepository;
import com.capgemini.jpa.service.DepartmentService;
import com.capgemini.jpa.service.EmployeeService;
import com.capgemini.jpa.service.RentService;
import com.capgemini.jpa.service.exception.IncorrectInputException;
import com.capgemini.jpa.service.validation.ValidationService;
import com.google.gson.reflect.TypeToken;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private ModelMapper modelMapper = new ModelMapper();
	private Type listDepartmentTOType = new TypeToken<ArrayList<DepartmentTO>>() {}.getType();
	private Type listEmployeeTOType = new TypeToken<ArrayList<EmployeeTO>>() {}.getType();

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RentService rentService;

	@Autowired
	private ValidationService validationService;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public DepartmentTO saveDepartment(DepartmentCreationDataTO departmentCreation) throws IncorrectInputException {

		validationService.validatePostalCode(departmentCreation.getPostalCode());
		validationService.validateEmail(departmentCreation.getEmail());
		validationService.validatePhoneNumber(departmentCreation.getPhoneNumber());
		validationService.validateCity(departmentCreation.getCity());
		validationService.validateStreet(departmentCreation.getStreet());
		validationService.validateHouseNumber(departmentCreation.getHouseNumber());

		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setCity(departmentCreation.getCity());
		addressEntity.setPostalCode(departmentCreation.getPostalCode());
		addressEntity.setStreet(departmentCreation.getStreet());
		addressEntity.setHouseNumber(departmentCreation.getHouseNumber());
		ContactDataEntity contactDataEntity = new ContactDataEntity();
		contactDataEntity.setPhoneNumber(departmentCreation.getPhoneNumber());
		contactDataEntity.setEmail(departmentCreation.getEmail());
		DepartmentEntity departmentEntity = new DepartmentEntity();
		departmentEntity.setAddress(addressEntity);
		departmentEntity.setContactData(contactDataEntity);
		DepartmentEntity savedDepartment = departmentRepository.save(departmentEntity);
		return modelMapper.map(savedDepartment, DepartmentTO.class);
	}

	@Override
	@Transactional
	public void removeDepartment(Long id) throws IncorrectInputException {
		validationService.validateDepartment(id);
		Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(id);
		removeDepartment(modelMapper.map(departmentEntity.get(),  DepartmentTO.class));
	}

	@Override
	@Transactional
	public void removeDepartment(DepartmentTO department) {
		DepartmentEntity entity = modelMapper.map(department, DepartmentEntity.class);

		rentService.detachDepartment(department.getId());
		employeeService.detachDepartment(department.getId());

		departmentRepository.delete(entity);
	}

	@Override
	@Transactional
	public DepartmentTO updateDepartmentData(Long departmentId, String phoneNumber, String email)
			throws IncorrectInputException {
		validationService.validateEmail(email);
		validationService.validatePhoneNumber(phoneNumber);
		DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).get();
		departmentEntity.getContactData().setPhoneNumber(phoneNumber);
		departmentEntity.getContactData().setEmail(email);
		DepartmentEntity updatedDepartment = departmentRepository.save(departmentEntity);
		return modelMapper.map(updatedDepartment, DepartmentTO.class);
	}

	@Override
	@Transactional
	public void assignEmployeeToDepartment(Long employeeId, Long departmentId) throws IncorrectInputException {

		validationService.validateDepartment(departmentId);
		validationService.validateEmployee(employeeId);

		Optional<DepartmentEntity> findDepartment = departmentRepository.findById(departmentId);
		Optional<EmployeeEntity> findEmloyee = employeeRepository.findById(employeeId);

		findEmloyee.get().setDepartment(findDepartment.get());
		employeeRepository.save(findEmloyee.get());
		
		findDepartment.get().addEmployee(findEmloyee.get());
		departmentRepository.save(findDepartment.get());
	}

	@Override
	@Transactional
	public void removeEmployeeFromDepartment(Long employeeId, Long departmentId) throws IncorrectInputException {
		validationService.validateDepartment(departmentId);
		validationService.validateEmployee(employeeId);
		
		Optional<DepartmentEntity> findDepartment = departmentRepository.findById(departmentId);
		Optional<EmployeeEntity> findEmloyee = employeeRepository.findById(employeeId);

		findDepartment.get().removeEmployee(findEmloyee.get());
		departmentRepository.save(findDepartment.get());
		
		findEmloyee.get().setDepartment(null);
		employeeRepository.save(findEmloyee.get());
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmployeeTO> findAllDepartmentEmployee(Long departmentId) {
		Optional<DepartmentEntity> department = departmentRepository.findById(departmentId);
		List<EmployeeTO> results = new ArrayList<>();
		if (department.isPresent()) {
			results = modelMapper.map(department.get().getEmployees(), listEmployeeTOType);
		}
		return results;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DepartmentTO> findAll() {
		List<DepartmentEntity> departments = departmentRepository.findAll();
		List<DepartmentTO> results = modelMapper.map(departments, listDepartmentTOType);
		return results;
	}

	@Override
	@Transactional(readOnly = true)
	public DepartmentTO findDepartmentById(Long id) {
		Optional<DepartmentEntity> departmentOptional = departmentRepository.findById(id);
		return departmentOptional.isPresent()
				? modelMapper.map(departmentRepository.findById(id).get(), DepartmentTO.class)
				: null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmployeeTO> findDepartmentEmployeeAssignedToCar(Long departmentId, Long carId) {
		DepartmentEntity department = departmentRepository.findById(departmentId).get();
		List<EmployeeEntity> employees = department.getEmployees();
		List<EmployeeEntity> filtredEmployees = employees.stream()
				.filter(employee -> checkIfCarIsAssigned(employee, carId)).collect(Collectors.toList());
		List<EmployeeTO> results = modelMapper.map(filtredEmployees, listEmployeeTOType);
		return results;
	}

	private boolean checkIfCarIsAssigned(EmployeeEntity employee, Long carId) {
		List<CarEntity> cars = employee.getCars();
		for (CarEntity car : cars) {
			if (car.getId() == carId) {
				return true;
			}
		}
		return false;
	}

}
