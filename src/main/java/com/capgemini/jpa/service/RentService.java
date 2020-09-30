package com.capgemini.jpa.service;

import java.util.List;

import com.capgemini.jpa.domain.tos.RentTO;

public interface RentService {

	public List<RentTO> findAll();

	public void detachDepartment(Long departmentId);
	
}
