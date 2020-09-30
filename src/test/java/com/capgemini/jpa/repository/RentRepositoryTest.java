package com.capgemini.jpa.repository;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jpa.domain.entities.CarEntity;
import com.capgemini.jpa.domain.entities.ClientEntity;
import com.capgemini.jpa.domain.entities.DepartmentEntity;
import com.capgemini.jpa.domain.entities.RentEntity;
import com.capgemini.jpa.testdata.TestData;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@PropertySource("classpath:application-hsql.properties")
public class RentRepositoryTest {

	private TestData testData = new TestData();

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private RentRepository rentRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	public void shouldFindAllDataByEndDepartment() {
		// given
		CarEntity car = carRepository.save(testData.carEntity1);
		DepartmentEntity department1 = departmentRepository.save(testData.departmentEntity1);
		DepartmentEntity department2 = departmentRepository.save(testData.departmentEntity2);
		ClientEntity client = clientRepository.save(testData.clientEntity1);

		RentEntity rent1 = new RentEntity.RentEntityBuilder().withEndDate(LocalDateTime.of(2018, 5, 13, 5, 59))
				.withStartDate(LocalDateTime.of(2018, 5, 12, 7, 00)).withCar(car).withClient(client)
				.withEndDepartment(department1).withStartDepartment(department1).build();
		RentEntity rent2 = new RentEntity.RentEntityBuilder().withEndDate(LocalDateTime.of(2017, 5, 13, 5, 59))
				.withStartDate(LocalDateTime.of(2017, 5, 23, 5, 59)).withCar(car).withClient(client)
				.withEndDepartment(department1).withStartDepartment(department1).build();
		RentEntity rent3 = new RentEntity.RentEntityBuilder().withEndDate(LocalDateTime.of(2018, 3, 13, 5, 59))
				.withStartDate(LocalDateTime.of(2018, 3, 15, 5, 59)).withCar(car).withClient(client)
				.withEndDepartment(department2).withStartDepartment(department2).build();
		RentEntity savedRent1 = rentRepository.save(rent1);
		RentEntity savedRent2 = rentRepository.save(rent2);
		RentEntity savedRent3 = rentRepository.save(rent3);

		List<RentEntity> rentToSave = new ArrayList<>();
		rentToSave.add(savedRent1);
		rentToSave.add(savedRent2);
		rentToSave.add(savedRent3);

		car.setRents(rentToSave);
		carRepository.save(car);
		// when
		List<RentEntity> findAllRents = rentRepository.findEmployeesByEndDepartmentId(department2.getId());
		// then
		assertEquals(1, findAllRents.size());
	}

	@Test
	public void shouldFindAllDataByStartDepartment() {
		// given
		CarEntity car = carRepository.save(testData.carEntity1);
		DepartmentEntity department1 = departmentRepository.save(testData.departmentEntity1);
		DepartmentEntity department2 = departmentRepository.save(testData.departmentEntity2);
		ClientEntity client = clientRepository.save(testData.clientEntity1);

		RentEntity rent1 = new RentEntity.RentEntityBuilder().withEndDate(LocalDateTime.of(2018, 5, 13, 5, 59))
				.withStartDate(LocalDateTime.of(2018, 5, 12, 7, 00)).withCar(car).withClient(client)
				.withEndDepartment(department1).withStartDepartment(department1).build();
		RentEntity rent2 = new RentEntity.RentEntityBuilder().withEndDate(LocalDateTime.of(2017, 5, 13, 5, 59))
				.withStartDate(LocalDateTime.of(2017, 5, 23, 5, 59)).withCar(car).withClient(client)
				.withEndDepartment(department1).withStartDepartment(department1).build();
		RentEntity rent3 = new RentEntity.RentEntityBuilder().withEndDate(LocalDateTime.of(2018, 3, 13, 5, 59))
				.withStartDate(LocalDateTime.of(2018, 3, 15, 5, 59)).withCar(car).withClient(client)
				.withEndDepartment(department2).withStartDepartment(department2).build();
		RentEntity savedRent1 = rentRepository.save(rent1);
		RentEntity savedRent2 = rentRepository.save(rent2);
		RentEntity savedRent3 = rentRepository.save(rent3);

		List<RentEntity> rentToSave = new ArrayList<>();
		rentToSave.add(savedRent1);
		rentToSave.add(savedRent2);
		rentToSave.add(savedRent3);

		car.setRents(rentToSave);
		carRepository.save(car);
		// when
		List<RentEntity> findAllRents = rentRepository.findEmployeesByStartDepartmentId(department2.getId());
		// then
		assertEquals(1, findAllRents.size());
	}
}
