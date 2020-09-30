package com.capgemini.jpa.service.impl;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jpa.domain.entities.CarEntity;
import com.capgemini.jpa.domain.entities.EmployeeEntity;
import com.capgemini.jpa.domain.tos.CarTO;
import com.capgemini.jpa.domain.tos.EmployeeSearchCriteria;
import com.capgemini.jpa.domain.tos.EmployeeTO;
import com.capgemini.jpa.repository.EmployeeRepository;
import com.capgemini.jpa.repository.RentRepository;
import com.capgemini.jpa.service.QueryService;
 import com.google.gson.reflect.TypeToken;

 @Service
public class QueryServiceImpl implements QueryService {
	
	private ModelMapper modelMapper = new ModelMapper();
	private Type listEmployeeTOType = new TypeToken<ArrayList<EmployeeTO>>() {}.getType();
	private Type listCarsTOType = new TypeToken<ArrayList<CarTO>>() {}.getType();	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RentRepository rentRepository;
	
	public List<EmployeeTO> findEmployees(EmployeeSearchCriteria criteria) {
		List<EmployeeEntity> findEmployees = employeeRepository.findEmployees(criteria.getDepartmentId(), criteria.getCarId(), criteria.getEmployeePosition());
		List<EmployeeTO> result = modelMapper.map(findEmployees, listEmployeeTOType);
		return result;
	}

	@Override
	public List<CarTO> findCarsByNumberOfRents(int numberOfRents) {
		List<CarEntity> cars = rentRepository.findCarsByNumberOfRents(numberOfRents);
		List<CarTO> result = modelMapper.map(cars, listCarsTOType);
		return result;
	}

	@Override
	public int numberOfCarsUsedBeetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
		List<CarEntity> cars = rentRepository.numberOfCarsUsedBetweenDates(startDate, endDate);
		return cars.size();
	}
}
