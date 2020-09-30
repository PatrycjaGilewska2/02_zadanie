package com.capgemini.jpa.service.impl;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jpa.domain.entities.CarEntity;
import com.capgemini.jpa.domain.entities.ClientEntity;
import com.capgemini.jpa.domain.entities.DepartmentEntity;
import com.capgemini.jpa.domain.entities.RentEntity;
import com.capgemini.jpa.domain.tos.RentTO;
import com.capgemini.jpa.repository.CarRepository;
import com.capgemini.jpa.repository.ClientRepository;
import com.capgemini.jpa.repository.DepartmentRepository;
import com.capgemini.jpa.repository.RentRepository;
import com.capgemini.jpa.service.RentService;
import com.capgemini.jpa.testdata.TestData;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RentServiceImplTest {

	private TestData testData = new TestData();
	
	@Autowired
	private RentService rentService;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private RentRepository rentRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	

	@Test
	public void shouldFindAllData() {
		//given
		CarEntity car = carRepository.save(testData.carEntity1);
		DepartmentEntity department = departmentRepository.save(testData.departmentEntity1);
		ClientEntity client = clientRepository.save(testData.clientEntity1);

		RentEntity rent1 = new RentEntity.RentEntityBuilder().withEndDate(LocalDateTime.of(2018, 5, 13, 5, 59))
				.withStartDate(LocalDateTime.of(2018, 5, 12, 7, 00)).withCar(car).withClient(client)
				.withEndDepartment(department).withStartDepartment(department).build();
		RentEntity rent2 = new RentEntity.RentEntityBuilder().withEndDate(LocalDateTime.of(2017, 5, 13, 5, 59))
				.withStartDate(LocalDateTime.of(2017, 5, 23, 5, 59)).withCar(car).withClient(client)
				.withEndDepartment(department).withStartDepartment(department).build();
		RentEntity rent3 = new RentEntity.RentEntityBuilder().withEndDate(LocalDateTime.of(2018, 3, 13, 5, 59))
				.withStartDate(LocalDateTime.of(2018, 3, 15, 5, 59)).withCar(car).withClient(client)
				.withEndDepartment(department).withStartDepartment(department).build();
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
		List<RentTO> findAllRents = rentService.findAll();
		// then
		assertEquals(3, findAllRents.size());
	}
}
