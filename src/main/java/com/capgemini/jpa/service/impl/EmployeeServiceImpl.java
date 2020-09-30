package com.capgemini.jpa.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jpa.domain.entities.EmployeeEntity;
import com.capgemini.jpa.domain.tos.EmployeeTO;
import com.capgemini.jpa.repository.EmployeeRepository;
import com.capgemini.jpa.service.EmployeeService;
import com.google.gson.reflect.TypeToken;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private ModelMapper modelMapper = new ModelMapper();
	private Type listEmployeeTOType = new TypeToken<ArrayList<EmployeeTO>>() {
	}.getType();

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional(readOnly = true)
	public List<EmployeeTO> findAll() {
		List<EmployeeEntity> cars = employeeRepository.findAll();
		List<EmployeeTO> result = modelMapper.map(cars, listEmployeeTOType);
		return result;

	}

	@Override
	@Transactional(readOnly = true)
	public EmployeeTO findById(Long id) {
		Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(id);
		return employeeOptional.isPresent() ? modelMapper.map(employeeRepository.findById(id).get(), EmployeeTO.class)
				: null;
	}

	@Override
	@Transactional
	public void detachDepartment(Long departmentId) {
		List<EmployeeEntity> empoloyees = employeeRepository.findEmployeesByDepartmentId(departmentId);

		for (EmployeeEntity employeeEntity : empoloyees) {
			employeeEntity.setDepartment(null);
			employeeRepository.save(employeeEntity);
		}
	}
}