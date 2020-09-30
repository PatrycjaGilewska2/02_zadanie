package com.capgemini.jpa.service.validation;

import com.capgemini.jpa.domain.enums.CarBrand;
import com.capgemini.jpa.domain.enums.CarType;
import com.capgemini.jpa.service.exception.IncorrectInputException;

public interface ValidationService {

	public void validateDepartment (Long departmentId) throws IncorrectInputException;
	
	public void validateEmployee(Long employeeId) throws IncorrectInputException;

	public void validateEmail(String email) throws IncorrectInputException;

	public void validatePostalCode(String postalCode) throws IncorrectInputException;

	public void validatePhoneNumber(String phoneNumber) throws IncorrectInputException;

	public void validateCity(String city) throws IncorrectInputException;

	public void validateStreet(String street) throws IncorrectInputException;

	public void validateHouseNumber(String houseNumber) throws IncorrectInputException;

	public void validateCarBrand(CarBrand carBrand) throws IncorrectInputException;

	public void validateCarType(CarType carType) throws IncorrectInputException;

	public void validateVin(String vin) throws IncorrectInputException;

	public void validateProductionYear(int productionYear) throws IncorrectInputException;

	public void validateColor(String color) throws IncorrectInputException;

	public void validateCar(Long carId) throws IncorrectInputException;

	public void validateMileage(float mileage) throws IncorrectInputException;
	
	
}
