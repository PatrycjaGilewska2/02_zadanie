package com.capgemini.jpa.service;

import java.util.List;

import com.capgemini.jpa.domain.tos.EmployeeTO;

public interface EmployeeService {

	public List<EmployeeTO> findAll(); 

	public EmployeeTO findById(Long id);

	public void detachDepartment(Long departmentId);
}
