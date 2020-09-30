package com.capgemini.jpa.service;

import java.time.LocalDateTime;
import java.util.List;

import com.capgemini.jpa.domain.tos.CarTO;
import com.capgemini.jpa.domain.tos.EmployeeSearchCriteria;
import com.capgemini.jpa.domain.tos.EmployeeTO;

public interface QueryService {

	public List<EmployeeTO> findEmployees(EmployeeSearchCriteria criteria);
	
	public List<CarTO> findCarsByNumberOfRents(int numberOfRents);
	
	public int numberOfCarsUsedBeetweenDates(LocalDateTime startDate, LocalDateTime endDate);
	
}
