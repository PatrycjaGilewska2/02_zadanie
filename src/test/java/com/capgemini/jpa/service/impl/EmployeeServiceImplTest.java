package com.capgemini.jpa.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jpa.domain.entities.EmployeeEntity;
import com.capgemini.jpa.domain.enums.EmployeePosition;
import com.capgemini.jpa.domain.tos.EmployeeTO;
import com.capgemini.jpa.repository.EmployeeRepository;
import com.capgemini.jpa.service.EmployeeService;
import com.capgemini.jpa.testdata.TestData;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EmployeeServiceImplTest {

	private TestData testData = new TestData();

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void shouldFindAllData() {
		// given
		employeeRepository.save(testData.employeeEntity1);
		employeeRepository.save(testData.employeeEntity2);
		// when
		List<EmployeeTO> findAllEmployees = employeeService.findAll();
		// then
		assertEquals(2, findAllEmployees.size());
	}

	@Test
	public void shouldFindEmployeeById() {
		// given
		EmployeeEntity savedEmployee = employeeRepository.save(testData.employeeEntity1);
		employeeRepository.save(testData.employeeEntity2);
		// when
		EmployeeTO firstEmployee = employeeService.findById(savedEmployee.getId());
		// then
		assertEquals(EmployeePosition.MANAGER, firstEmployee.getEmployeePosition());
		assertEquals("Giuseppe", firstEmployee.getPersonalInfo().getName());
		assertEquals("Brakus", firstEmployee.getPersonalInfo().getSurename());
	}

	@Test
	public void shouldReturnNullWhenEmployeeIdIsIncorrect() {
		// given
		employeeRepository.save(testData.employeeEntity2);
		// when
		EmployeeTO nonExsistingEmployee = employeeService.findById(22L);
		// then
		assertNull(nonExsistingEmployee);
	}

}
