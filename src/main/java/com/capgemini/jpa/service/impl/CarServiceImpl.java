package com.capgemini.jpa.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jpa.domain.entities.CarEntity;
import com.capgemini.jpa.domain.entities.CarModelEntity;
import com.capgemini.jpa.domain.entities.EmployeeEntity;
import com.capgemini.jpa.domain.enums.CarBrand;
import com.capgemini.jpa.domain.enums.CarType;
import com.capgemini.jpa.domain.tos.CarCreationDataTO;
import com.capgemini.jpa.domain.tos.CarTO;
import com.capgemini.jpa.repository.CarRepository;
import com.capgemini.jpa.repository.EmployeeRepository;
import com.capgemini.jpa.service.CarService;
import com.capgemini.jpa.service.exception.IncorrectInputException;
import com.capgemini.jpa.service.validation.ValidationService;
import com.google.gson.reflect.TypeToken;

@Service
public class CarServiceImpl implements CarService {

	private ModelMapper modelMapper = new ModelMapper();
	private Type listCarTOType = new TypeToken<ArrayList<CarTO>>() {
	}.getType();

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ValidationService validationService;

	@Override
	@Transactional
	public CarTO saveCar(CarCreationDataTO carCreation) throws IncorrectInputException {

		validationService.validateCarBrand(carCreation.getCarBrand());
		validationService.validateCarType(carCreation.getCarType());
		validationService.validateVin(carCreation.getVin());
		validationService.validateProductionYear(carCreation.getProductionYear());
		validationService.validateColor(carCreation.getColor());

		CarModelEntity carModelEntity = new CarModelEntity();
		carModelEntity.setBrand(carCreation.getCarBrand());
		carModelEntity.setType(carCreation.getCarType());
		carModelEntity.setModel(carCreation.getModel());
		carModelEntity.setVin(carCreation.getVin());
		CarEntity carEntity = new CarEntity();
		carEntity.setCarModel(carModelEntity);
		carEntity.setProductionYear(carCreation.getProductionYear());
		carEntity.setColor(carCreation.getColor());
		carEntity.setEngineCapacity(carCreation.getEngineCapacity());
		carEntity.setCarPower(carCreation.getCarPower());
		carEntity.setMileage(carCreation.getMileage());
		CarEntity savedEntity = carRepository.save(carEntity);		
		return modelMapper.map(savedEntity, CarTO.class);
	}

	@Override
	@Transactional
	public void removeCar(Long id) throws IncorrectInputException {
		validationService.validateCar(id);
		CarTO carTO = findCarById(id);
		CarEntity carEntity = modelMapper.map(carTO, CarEntity.class);
		carRepository.delete(carEntity);
	}

	@Override
	@Transactional
	public void removeCar(CarTO carTO) {
		CarEntity carEntity = modelMapper.map(carTO, CarEntity.class);		
		carRepository.delete(carEntity);
	}

	@Override
	@Transactional
	public CarTO updateCarData(Long carId, String color, float mileage) throws IncorrectInputException {

		validationService.validateCar(carId);

		CarEntity carEntity = carRepository.findById(carId).get();

		validationService.validateColor(carEntity.getColor());
		validationService.validateMileage(carEntity.getMileage());

		carEntity.setColor(color);
		carEntity.setMileage(mileage);
		CarEntity updatedEntity = carRepository.save(carEntity);
		return modelMapper.map(updatedEntity, CarTO.class);
	}

	@Override
	@Transactional
	public void assignCarToEmployee(Long carId, Long employeeId) throws IncorrectInputException {
		validationService.validateCar(carId);
		validationService.validateEmployee(employeeId);

		CarEntity findCar = carRepository.findById(carId).get();
		EmployeeEntity findEmployee = employeeRepository.findById(employeeId).get();

		findCar.addEmployee(findEmployee);
		findEmployee.addCar(findCar);

		carRepository.save(findCar);
		employeeRepository.save(findEmployee);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CarTO> findAll() {
		List<CarEntity> cars = carRepository.findAll();
		List<CarTO> result = modelMapper.map(cars, listCarTOType);
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public CarTO findCarById(Long id) {
		Optional<CarEntity> carOptional = carRepository.findById(id);
		return carOptional.isPresent() ? modelMapper.map(carRepository.findById(id).get(), CarTO.class) : null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CarTO> findByTypeAndBrand(CarType type, CarBrand brand) {
		List<CarEntity> findCars = carRepository.findCarsByTypeAndBrand(type, brand);
		List<CarTO> result = modelMapper.map(findCars, listCarTOType);
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CarTO> findByEmployee(Long employeeId) {
		List<CarEntity> findCars = carRepository.findByEmployee(employeeId);
		List<CarTO> result = modelMapper.map(findCars, listCarTOType);
		return result;
	}

}