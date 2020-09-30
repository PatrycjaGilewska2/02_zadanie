package com.capgemini.jpa.service;

import java.util.List;

import com.capgemini.jpa.domain.enums.CarBrand;
import com.capgemini.jpa.domain.enums.CarType;
import com.capgemini.jpa.domain.tos.CarCreationDataTO;
import com.capgemini.jpa.domain.tos.CarTO;
import com.capgemini.jpa.service.exception.IncorrectInputException;

public interface CarService {

	public CarTO saveCar(CarCreationDataTO carCreation) throws IncorrectInputException; 
	
	public void removeCar(Long id) throws IncorrectInputException; 
	
	public void removeCar(CarTO car); 
	
	public CarTO updateCarData(Long carId, String color, float mileage) throws IncorrectInputException; 
	
	public void assignCarToEmployee(Long carId, Long employeeId) throws IncorrectInputException;
	
	public List<CarTO> findAll(); 
	
	public CarTO findCarById(Long id); 
	
	public List<CarTO> findByTypeAndBrand(CarType type, CarBrand brand);
	
	public List<CarTO> findByEmployee(Long employeeId);

}
