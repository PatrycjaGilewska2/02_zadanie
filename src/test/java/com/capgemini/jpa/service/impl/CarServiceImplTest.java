package com.capgemini.jpa.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import com.capgemini.jpa.domain.entities.EmployeeEntity;
import com.capgemini.jpa.domain.entities.RentEntity;
import com.capgemini.jpa.domain.enums.CarBrand;
import com.capgemini.jpa.domain.enums.CarType;
import com.capgemini.jpa.domain.tos.CarCreationDataTO;
import com.capgemini.jpa.domain.tos.CarTO;
import com.capgemini.jpa.domain.tos.EmployeeTO;
import com.capgemini.jpa.domain.tos.RentTO;
import com.capgemini.jpa.repository.CarRepository;
import com.capgemini.jpa.repository.ClientRepository;
import com.capgemini.jpa.repository.DepartmentRepository;
import com.capgemini.jpa.repository.EmployeeRepository;
import com.capgemini.jpa.repository.RentRepository;
import com.capgemini.jpa.service.CarService;
import com.capgemini.jpa.service.EmployeeService;
import com.capgemini.jpa.service.RentService;
import com.capgemini.jpa.service.exception.IncorrectInputException;
import com.capgemini.jpa.testdata.TestData;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@PropertySource("classpath:application-hsql.properties")
public class CarServiceImplTest {

	private TestData testData = new TestData();

	@Autowired
	private CarService carService;
	@Autowired
	private RentService rentService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private RentRepository rentRepository;

	@Test
	public void shouldFindAllCars() {
		// given
		carRepository.save(testData.carEntity1);
		carRepository.save(testData.carEntity2);
		// when
		List<CarTO> findAllCars = carService.findAll();
		// then
		assertEquals(2, findAllCars.size());
	}

	@Test
	public void shouldSaveCar() throws IncorrectInputException {
		// given
		CarCreationDataTO car1 = new CarCreationDataTO.CarCreationDataTOBuilder().withCarBrand(CarBrand.BMW)
				.withCarType(CarType.CABRIO).withModel("E46").withVin("ee8102cy0q292r74l").withProductionYear(2002)
				.withColor("black").withEngineCapacity(2000).withCarPower(150).withMileage(200000).build();
		// when
		CarTO carToSave = carService.saveCar(car1);
		// then
		List<CarTO> cars = carService.findAll();
		CarTO savedCar = carService.findCarById(carToSave.getId());
		assertEquals(1, cars.size());
		assertNotNull(savedCar);
		assertEquals(CarBrand.BMW, savedCar.getCarModel().getCarBrand());
		assertEquals(CarType.CABRIO, savedCar.getCarModel().getCarType());
		assertEquals("E46", savedCar.getCarModel().getModel());
		assertEquals("ee8102cy0q292r74l", savedCar.getCarModel().getVin());
		assertEquals(2002, savedCar.getProductionYear());
		assertEquals("black", savedCar.getColor());
		assertEquals(2000, savedCar.getEngineCapacity());
		assertEquals(200000, savedCar.getMileage(), 0.01);
	}

	@Test
	public void shouldFindCarById() {
		// given
		CarEntity savedCar = carRepository.save(testData.carEntityToFindById);
		// when
		CarTO firstCar = carService.findCarById(savedCar.getId());
		// then
		assertEquals(CarBrand.OPEL, firstCar.getCarModel().getCarBrand());
		assertEquals(CarType.OFFROAD, firstCar.getCarModel().getCarType());
		assertEquals("Frontera", firstCar.getCarModel().getModel());
		assertEquals("82qh30adof6o52vxh", firstCar.getCarModel().getVin());
		assertEquals(2000, firstCar.getProductionYear());
		assertEquals("black", firstCar.getColor());
		assertEquals(2900, firstCar.getEngineCapacity());
		assertEquals(388197, firstCar.getMileage(), 0.01);
	}

	@Test
	public void shouldReturnNullWhenCarIdIsIncorrect() {
		// when
		CarTO nonExsistingCar = carService.findCarById(22L);
		// then
		assertNull(nonExsistingCar);
	}

	@Test
	public void shouldRemoveCarById() throws IncorrectInputException {
		// given
		CarEntity savedCar1 = carRepository.save(testData.carEntity1);
		carRepository.save(testData.carEntity2);

		Long carToDeleteId = savedCar1.getId();
		// when
		carService.removeCar(carToDeleteId);
		// then
		assertEquals(1, carService.findAll().size());
		assertNull(carService.findCarById(carToDeleteId));
	}

	@Test
	public void shouldRemoveCarByIdAndHistoryWithoutOtherData() throws IncorrectInputException {
		// given
		CarEntity car = carRepository.save(testData.carEntity1);
		DepartmentEntity department = departmentRepository.save(testData.departmentEntity1);
		ClientEntity client = clientRepository.save(testData.clientEntity1);
		EmployeeEntity employee = employeeRepository.save(testData.employeeEntity1);

		car.addEmployee(employee);
		employee.addCar(car);
		car = carRepository.save(car);
		employeeRepository.save(employee);

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

		int initialNumberOfEmployees = 1;
		// when
		Long id = car.getId();
		carService.removeCar(id);
		// then
		List<RentTO> rents = rentService.findAll();
		assertEquals(0, rents.size());
		assertNull(carService.findCarById(id));
		List<EmployeeTO> employees = employeeService.findAll();
		assertEquals(initialNumberOfEmployees, employees.size());
	}

	@Test
	public void shouldRemoveCarByObject() {
		// given
		CarEntity savedCar1 = carRepository.save(testData.carEntity1);
		carRepository.save(testData.carEntity2);
		Long carToDeleteId = savedCar1.getId();
		CarTO car = carService.findCarById(carToDeleteId);
		// when
		carService.removeCar(car);
		// then
		List<CarTO> allCars = carService.findAll();
		assertEquals(1, allCars.size());
		assertNull(carService.findCarById(carToDeleteId));
	}

	@Test
	public void shouldUpdateCarData() throws IncorrectInputException {
		// given
		CarEntity carToSave = carRepository.save(testData.carEntity1);
		Long id = carToSave.getId();
		// when
		carService.updateCarData(id, "red", 400000f);
		// then
		CarTO car = carService.findCarById(id);
		assertNotNull(car);
		assertEquals("red", car.getColor());
		assertEquals(400000f, car.getMileage(), 0.01);
	}

	@Test
	public void shouldReturnCarByTypeAndBrand() {
		carRepository.save(testData.carEntity1);
		carRepository.save(testData.carEntity2);
		// when
		List<CarTO> findCars = carService.findByTypeAndBrand(CarType.OFFROAD, CarBrand.OPEL);
		CarTO carEntity = findCars.get(0);
		// then
		assertEquals(1, findCars.size());
		assertEquals("Frontera", carEntity.getCarModel().getModel());
		assertEquals(CarType.OFFROAD, carEntity.getCarModel().getCarType());
		assertEquals(CarBrand.OPEL, carEntity.getCarModel().getCarBrand());
		assertEquals(2000, carEntity.getProductionYear());
		assertEquals(2900, carEntity.getEngineCapacity());
		assertEquals(180, carEntity.getCarPower());
	}

	@Test
	public void shouldReturnNullWhenCarDoesNotExsist() {
		// when
		List<CarTO> findCars = carService.findByTypeAndBrand(CarType.LIMUSINE, CarBrand.OPEL);
		// then
		assertEquals(0, findCars.size());
	}

	@Test
	public void shouldAssignCarToEmployee() throws IncorrectInputException {
		// given
		CarEntity savedCar = carRepository.save(testData.carEntity1);
		EmployeeEntity savedEmployee = employeeRepository.save(testData.employeeEntity1);
		Long carId = savedCar.getId();
		Long employeeId = savedEmployee.getId();
		// when
		carService.assignCarToEmployee(carId, employeeId);
		// then
		List<CarTO> cars = carService.findByEmployee(employeeId);
		EmployeeTO employee = employeeService.findById(employeeId);
		CarTO car = carService.findCarById(carId);
		assertTrue(employee.getCars().contains(car));
		assertTrue(car.getEmployees().contains(employee));
		assertTrue(cars.contains(car));
	}

	@Test
	public void shouldFindCarsByEmployee() {
		// given
		CarEntity savedCar = carRepository.save(testData.carEntity1);
		EmployeeEntity savedEmployee = employeeRepository.save(testData.employeeEntity1);
		savedCar.addEmployee(savedEmployee);
		savedEmployee.addCar(savedCar);
		carRepository.save(savedCar);
		employeeRepository.save(savedEmployee);
		Long employeeId = savedEmployee.getId();
		// when
		List<CarTO> cars = carService.findByEmployee(employeeId);
		CarTO carEntity = cars.get(0);
		// then
		assertEquals(1, cars.size());
		assertEquals("black", carEntity.getColor());
		assertEquals(2000, carEntity.getProductionYear());
		assertEquals(388197, carEntity.getMileage(), 0.01);
	}

}
