package com.capgemini.jpa.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jpa.domain.entities.CarEntity;
import com.capgemini.jpa.domain.entities.DepartmentEntity;
import com.capgemini.jpa.domain.entities.EmployeeEntity;
import com.capgemini.jpa.domain.enums.EmployeePosition;
import com.capgemini.jpa.domain.tos.DepartmentCreationDataTO;
import com.capgemini.jpa.domain.tos.DepartmentTO;
import com.capgemini.jpa.domain.tos.EmployeeTO;
import com.capgemini.jpa.repository.CarRepository;
import com.capgemini.jpa.repository.DepartmentRepository;
import com.capgemini.jpa.repository.EmployeeRepository;
import com.capgemini.jpa.service.DepartmentService;
import com.capgemini.jpa.service.EmployeeService;
import com.capgemini.jpa.service.exception.IncorrectInputException;
import com.capgemini.jpa.testdata.TestData;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DepartmentServiceImplTest {

	private TestData testData = new TestData();

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private CarRepository carRepository;

	@Test
	public void shouldFindAllDepartment() {
		// given
		departmentRepository.save(testData.departmentEntity1);
		// when
		List<DepartmentTO> findAllDepartment = departmentService.findAll();
		// then
		assertEquals(1, findAllDepartment.size());
	}

	@Test
	public void shouldSaveDepartment() throws IncorrectInputException {
		// given
		DepartmentCreationDataTO department = new DepartmentCreationDataTO.DepartmentCreationDataTOBuilder()
				.withCity("Wroclaw").withPostalCode("53515").withStreet("Lwowska").withHouseNumber("25/11")
				.withPhoneNumber("785-345-356").withEmail("aniakowalska@gmail.com").build();
		// when
		DepartmentTO departmentToSave = departmentService.saveDepartment(department);
		// then
		List<DepartmentTO> departments = departmentService.findAll();
		DepartmentTO savedDepartment = departmentService.findDepartmentById(departmentToSave.getId());
		assertEquals(1, departments.size());
		assertNotNull(savedDepartment);
		assertEquals("Wroclaw", savedDepartment.getAddress().getCity());
		assertEquals("Lwowska", savedDepartment.getAddress().getStreet());
		assertEquals("53515", savedDepartment.getAddress().getPostalCode());
		assertEquals("25/11", savedDepartment.getAddress().getHouseNumber());
		assertEquals("785-345-356", savedDepartment.getContactData().getPhoneNumber());
		assertEquals("aniakowalska@gmail.com", savedDepartment.getContactData().getEmail());
	}

	@Test
	public void shouldFindDepartmentById() {
		// given
		DepartmentEntity department = departmentRepository.save(testData.departmentEntity1);
		// when
		DepartmentTO firstDepartment = departmentService.findDepartmentById(department.getId());
		// then
		assertEquals("East Herber", firstDepartment.getAddress().getCity());
		assertEquals("Connell Roads", firstDepartment.getAddress().getStreet());
		assertEquals("52533", firstDepartment.getAddress().getPostalCode());
		assertEquals("68", firstDepartment.getAddress().getHouseNumber());
		assertEquals("554-700-072", firstDepartment.getContactData().getPhoneNumber());
		assertEquals("mkilback@example.com", firstDepartment.getContactData().getEmail());
	}

	@Test
	public void shouldReturnNullWhenDepartmentIdIsIncorrect() {
		// when
		DepartmentTO nonExsistingDepartmentr = departmentService.findDepartmentById(6L);
		// then
		assertNull(nonExsistingDepartmentr);
	}

	@Test
	public void shouldRemoveDepartmentById() throws IncorrectInputException {
		DepartmentEntity department = departmentRepository.save(testData.departmentEntity1);
		departmentRepository.save(testData.departmentEntity2);
		// when
		Long id = department.getId();
		departmentService.removeDepartment(id);
		// then
		assertEquals(1, departmentService.findAll().size());
		assertNull(departmentService.findDepartmentById(id));
	}

	@Test
	public void shouldRemoveDepartmentByObject() {
		// given
		DepartmentEntity savedDepartment = departmentRepository.save(testData.departmentEntity1);
		departmentRepository.save(testData.departmentEntity2);
		Long departmentToDeleteId = savedDepartment.getId();
		DepartmentTO department = departmentService.findDepartmentById(departmentToDeleteId);
		// when
		departmentService.removeDepartment(department);
		// then
		List<DepartmentTO> allDepartments = departmentService.findAll();
		assertEquals(1, allDepartments.size());
		assertNull(departmentService.findDepartmentById(departmentToDeleteId));
	}

	@Test
	public void shouldUpdateDepartmentData() throws IncorrectInputException {
		// given
		DepartmentEntity departmentToSave = departmentRepository.save(testData.departmentEntity2);
		Long id = departmentToSave.getId();
		// when
		departmentService.updateDepartmentData(id, "555-555-555", "ulicakowalska@wp.pl");
		// then
		DepartmentTO department = departmentService.findDepartmentById(id);
		assertNotNull(department);
		assertEquals("555-555-555", department.getContactData().getPhoneNumber());
		assertEquals("ulicakowalska@wp.pl", department.getContactData().getEmail());
	}

	@Test
	public void shouldAssignEmployeeToDepartment() throws IncorrectInputException {
		//given
		EmployeeEntity savedEmployee = employeeRepository.save(testData.employeeEntity1);
		DepartmentEntity savedDepartment = departmentRepository.save(testData.departmentEntity1);
		Long employeeId = savedEmployee.getId();
		Long departmentId = savedDepartment.getId();
		// when
		departmentService.assignEmployeeToDepartment(employeeId, departmentId);
		// then
		DepartmentTO department = departmentService.findDepartmentById(departmentId);
		EmployeeTO employee = employeeService.findById(employeeId);
		assertTrue(department.getEmployees().contains(employee));
		Long id = employee.getDepartment().getId();
		assertEquals(departmentId, id);
	}

	@Test
	public void shouldFindDepartmentEmployeeAssignedToCar() {
		//given
		DepartmentEntity savedDepartment = departmentRepository.save(testData.departmentEntity1);
		Long departmentId = savedDepartment.getId();
		EmployeeEntity savedEmployee1 = employeeRepository.save(testData.employeeEntity1);
		EmployeeEntity savedEmployee2 = employeeRepository.save(testData.employeeEntity2);
		savedDepartment.addEmployee(savedEmployee1);
		savedDepartment.addEmployee(savedEmployee2);
		CarEntity savedCar = carRepository.save(testData.carEntity1);
		Long carId = savedCar.getId();
		savedEmployee1.addCar(savedCar);
		savedEmployee2.addCar(savedCar);
		// when
		List<EmployeeTO> employees = departmentService.findDepartmentEmployeeAssignedToCar(departmentId, carId);
		EmployeeTO employeeEntity1 = employees.get(0);
		EmployeeTO employeeEntity2 = employees.get(1);
		// then
		assertEquals(2, employees.size());
		assertEquals("Giuseppe", employeeEntity1.getPersonalInfo().getName());
		assertEquals("Brakus", employeeEntity1.getPersonalInfo().getSurename());
		assertEquals(EmployeePosition.MANAGER, employeeEntity1.getEmployeePosition());
		assertEquals("Harley", employeeEntity2.getPersonalInfo().getName());
		assertEquals("Jacobson", employeeEntity2.getPersonalInfo().getSurename());
		assertEquals(EmployeePosition.SALER, employeeEntity2.getEmployeePosition());
	}

	@Test
	public void shouldFindAllDepartmentEmployee() {
		//given
		DepartmentEntity savedDepartment = departmentRepository.save(testData.departmentEntity1);
		EmployeeEntity savedEmployee1 = employeeRepository.save(testData.employeeEntity1);
		EmployeeEntity savedEmployee2 = employeeRepository.save(testData.employeeEntity2);
		savedDepartment.addEmployee(savedEmployee1);
		savedDepartment.addEmployee(savedEmployee2);
		Long id = savedDepartment.getId();
		// when
		List<EmployeeTO> employees = departmentService.findAllDepartmentEmployee(id);
		EmployeeTO employee1 = employees.get(0);
		EmployeeTO employee2 = employees.get(1);
		// then
		assertEquals(2, employees.size());
		assertEquals("Giuseppe", employee1.getPersonalInfo().getName());
		assertEquals("Brakus", employee1.getPersonalInfo().getSurename());
		assertEquals("Harley", employee2.getPersonalInfo().getName());
		assertEquals("Jacobson", employee2.getPersonalInfo().getSurename());
	}

	@Test
	public void shouldRemoveEmployeeFromDepartment() throws IncorrectInputException {
		//given
		DepartmentEntity savedDepartment = departmentRepository.save(testData.departmentEntity1);
		EmployeeEntity savedEmployee = employeeRepository.save(testData.employeeEntity1);
		
		savedEmployee.setDepartment(savedDepartment);
		savedDepartment.addEmployee(savedEmployee);
		
		departmentRepository.save(savedDepartment);
		employeeRepository.save(savedEmployee);
		
		Long employeeId = savedEmployee.getId();
		Long departmentId = savedDepartment.getId();
		// when
		departmentService.removeEmployeeFromDepartment(employeeId, departmentId);
		// then
		List<EmployeeTO> departmentEmployee = departmentService.findAllDepartmentEmployee(departmentId);
		assertEquals(0, departmentEmployee.size());
	}
}
