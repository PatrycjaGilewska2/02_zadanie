package com.capgemini.jpa.service.validation.impl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jpa.service.exception.IncorrectInputException;
import com.capgemini.jpa.service.validation.ValidationService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@PropertySource("classpath:application-hsql.properties")
public class ValidationServiceImplTest {

	@Autowired
	private ValidationService validationService;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void shouldReturnIncorrectInputExceptionWhenDepartmentIsNotInDatabase() throws IncorrectInputException {
		// expected
		expectedEx.expect(IncorrectInputException.class);
		expectedEx.expectMessage("Department with provided id is not found");
		// when
		validationService.validateDepartment(-1L);
		validationService.validateDepartment(0L);
		validationService.validateDepartment(6L);
	}

	@Test
	public void shouldReturnIncorrectInputExceptionWhenEmployeeIsNotInDatabase() throws IncorrectInputException {
		// expected
		expectedEx.expect(IncorrectInputException.class);
		expectedEx.expectMessage("Employee with provided id is not found");
		// when
		validationService.validateEmployee(-1L);
		validationService.validateEmployee(0L);
		validationService.validateEmployee(11L);
	}

	@Test
	public void shouldReturnIncorrectInputExceptionWhenEmailIsIncorrect() throws IncorrectInputException {
		// expected
				expectedEx.expect(IncorrectInputException.class);
				expectedEx.expectMessage("Invalid Email");
				// when
				validationService.validateEmail("akowalska");
				validationService.validateEmail("poznan@");
				validationService.validateEmail("poznan@poznan.");
				validationService.validateEmail("@wp.pl");
	}
	
	@Test
	public void shouldReturnIncorrectInputExceptionWhenPostalCodeIsIncorrect() throws IncorrectInputException {
		// expected
				expectedEx.expect(IncorrectInputException.class);
				expectedEx.expectMessage("Invalid Postal Code");
				// when
				validationService.validatePostalCode("11");
				validationService.validatePostalCode("");
				validationService.validatePostalCode("111111");
	}
	
	@Test
	public void shouldReturnIncorrectInputExceptionWhenPhoneNumberIsIncorrect() throws IncorrectInputException {
		// expected
				expectedEx.expect(IncorrectInputException.class);
				expectedEx.expectMessage("Invalid Phone Number");
				// when
				validationService.validatePhoneNumber("");
	}
	
	@Test
	public void shouldReturnIncorrectInputExceptionWhenCityNameIsIncorrect() throws IncorrectInputException {
		// expected
				expectedEx.expect(IncorrectInputException.class);
				expectedEx.expectMessage("Invalid City Name");
				// when
				validationService.validateCity("");
	}
	
	@Test
	public void shouldReturnIncorrectInputExceptionWhenStreetIsIncorrect() throws IncorrectInputException {
		// expected
				expectedEx.expect(IncorrectInputException.class);
				expectedEx.expectMessage("Invalid City Name");
				// when
				validationService.validateCity("");
	}
	
	@Test
	public void shouldReturnIncorrectInputExceptionWhenHouseNumberIsIncorrect() throws IncorrectInputException {
		// expected
				expectedEx.expect(IncorrectInputException.class);
				expectedEx.expectMessage("Invalid House Number");
				// when
				validationService.validateHouseNumber("");
				validationService.validateHouseNumber("545454");
	}
	
	@Test
	public void shouldReturnIncorrectInputExceptionWhenCarBrandIsIncorrect() throws IncorrectInputException {
		// expected
				expectedEx.expect(IncorrectInputException.class);
				expectedEx.expectMessage("Invalid Car Brand");
				// when
				validationService.validateCarBrand(null);
	}
	
	@Test
	public void shouldReturnIncorrectInputExceptionWhenCarTypeIsIncorrect() throws IncorrectInputException {
		// expected
				expectedEx.expect(IncorrectInputException.class);
				expectedEx.expectMessage("Invalid Car Type");
				// when
				validationService.validateCarType(null);
	}
	
	@Test
	public void shouldReturnIncorrectInputExceptionWhenVinIsIncorrect() throws IncorrectInputException {
		// expected
				expectedEx.expect(IncorrectInputException.class);
				expectedEx.expectMessage("Invalid Vin");
				// when
				validationService.validateVin(null);
				validationService.validateVin("aaaaaaaaaaaaaaa111aaa");
				validationService.validateVin("aaaaaaaaaaaaaa111aaaaaa");
	}
	
	@Test
	public void shouldReturnIncorrectInputExceptionWhenProductionYearIsIncorrect() throws IncorrectInputException {
		// expected
				expectedEx.expect(IncorrectInputException.class);
				expectedEx.expectMessage("Invalid Production Year");
				// when
				validationService.validateProductionYear(1899);
				validationService.validateProductionYear(2019);
				validationService.validateProductionYear(0);
	}
	
	@Test
	public void shouldReturnIncorrectInputExceptionWhenColorIsIncorrect() throws IncorrectInputException {
		// expected
				expectedEx.expect(IncorrectInputException.class);
				expectedEx.expectMessage("Invalid Color");
				// when
				validationService.validateColor(null);
	}
	
	@Test
	public void shouldReturnIncorrectInputExceptionWhenCarIsIncorrect() throws IncorrectInputException {
		// expected
				expectedEx.expect(IncorrectInputException.class);
				expectedEx.expectMessage("Invalid Car Id");
				// when
				validationService.validateCar(7851L);
	}
		
	@Test
	public void shouldReturnIncorrectInputExceptionWhenMileageIsIncorrect() throws IncorrectInputException {
		// expected
				expectedEx.expect(IncorrectInputException.class);
				expectedEx.expectMessage("Invalid Mileage");
				// when
				validationService.validateMileage(-1f);
	}
}
