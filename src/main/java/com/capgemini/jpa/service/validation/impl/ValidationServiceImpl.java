package com.capgemini.jpa.service.validation.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jpa.domain.entities.CarEntity;
import com.capgemini.jpa.domain.entities.DepartmentEntity;
import com.capgemini.jpa.domain.entities.EmployeeEntity;
import com.capgemini.jpa.domain.enums.CarBrand;
import com.capgemini.jpa.domain.enums.CarType;
import com.capgemini.jpa.repository.CarRepository;
import com.capgemini.jpa.repository.DepartmentRepository;
import com.capgemini.jpa.repository.EmployeeRepository;
import com.capgemini.jpa.service.exception.IncorrectInputException;
import com.capgemini.jpa.service.validation.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CarRepository carRepository;

	@Override
	public void validateDepartment(Long departmentId) throws IncorrectInputException {
		Optional<DepartmentEntity> findDepartment = departmentRepository.findById(departmentId);
		if (!findDepartment.isPresent()) {
			throw new IncorrectInputException("Department with provided id is not found");
		}
	}

	@Override
	public void validateEmployee(Long employeeId) throws IncorrectInputException {
		Optional<EmployeeEntity> findEmloyee = employeeRepository.findById(employeeId);
		if (!findEmloyee.isPresent()) {
			throw new IncorrectInputException("Employee with provided id is not found");
		}
	}

	@Override
	public void validateEmail(String email) throws IncorrectInputException {
		if (!EmailValidator.getInstance().isValid(email)) {
			throw new IncorrectInputException("Invalid Email");
		}
	}

	@Override
	public void validatePostalCode(String postalCode) throws IncorrectInputException {
		if (postalCode == null || postalCode.isEmpty() || postalCode.length() != 5
				|| !StringUtils.isNumeric(postalCode)) {
			throw new IncorrectInputException("Invalid Postal Code");
		}
	}

	@Override
	public void validatePhoneNumber(String phoneNumber) throws IncorrectInputException {
		if (phoneNumber == null || phoneNumber.isEmpty()) {
			throw new IncorrectInputException("Invalid Phone Number");
		}
	}

	@Override
	public void validateCity(String city) throws IncorrectInputException {
		if (city == null || city.isEmpty()) {
			throw new IncorrectInputException("Invalid City Name");
		}
	}

	@Override
	public void validateStreet(String street) throws IncorrectInputException {
		if (street == null || street.isEmpty()) {
			throw new IncorrectInputException("Invalid Street Name");
		}
	}

	@Override
	public void validateHouseNumber(String houseNumber) throws IncorrectInputException {
		if (houseNumber == null || houseNumber.isEmpty() || houseNumber.length() != 5) {
			throw new IncorrectInputException("Invalid House Number");
		}
	}

	@Override
	public void validateCarBrand(CarBrand carBrand) throws IncorrectInputException {
		if (carBrand == null) {
			throw new IncorrectInputException("Invalid Car Brand");
		}
	}

	@Override
	public void validateCarType(CarType carType) throws IncorrectInputException {
		if (carType == null) {
			throw new IncorrectInputException("Invalid Car Type");
		}
	}

	@Override
	public void validateVin(String vin) throws IncorrectInputException {
		if (vin == null || vin.length() != 17 ) { 
			throw new IncorrectInputException("Invalid Vin");
		}
	}

	@Override
	public void validateProductionYear(int productionYear) throws IncorrectInputException {
		if (productionYear < 1900 || productionYear > LocalDateTime.now().getYear()) {
			throw new IncorrectInputException("Invalid Production Year");
		}
	}

	@Override
	public void validateColor(String color) throws IncorrectInputException {
		if (color == null ) { 
			throw new IncorrectInputException("Invalid Color");
		}
	}

	@Override
	public void validateCar(Long carId) throws IncorrectInputException {
		Optional<CarEntity> findCar = carRepository.findById(carId);
		if (!findCar.isPresent()) {
			throw new IncorrectInputException("Invalid Car Id");
		}
	}

	@Override
	public void validateMileage(float mileage) throws IncorrectInputException {
		if (mileage < 0) {
			throw new IncorrectInputException("Invalid Mileage");
		}
	}
}
