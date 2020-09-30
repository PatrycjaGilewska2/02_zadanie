package com.capgemini.jpa.service;

import java.util.List;

import com.capgemini.jpa.domain.tos.DepartmentCreationDataTO;
import com.capgemini.jpa.domain.tos.DepartmentTO;
import com.capgemini.jpa.domain.tos.EmployeeTO;
import com.capgemini.jpa.service.exception.IncorrectInputException;

public interface DepartmentService {

	public DepartmentTO saveDepartment(DepartmentCreationDataTO departmentCreationDataTO) throws IncorrectInputException;
	
	public void removeDepartment(Long id) throws IncorrectInputException;
	
	public void removeDepartment(DepartmentTO department);
	
	public DepartmentTO updateDepartmentData(Long departmentId, String phoneNumber, String email) throws IncorrectInputException;
	
	public void assignEmployeeToDepartment(Long employeeId, Long departmentId) throws IncorrectInputException;
	
	public void removeEmployeeFromDepartment(Long employeeId, Long departmentId) throws IncorrectInputException;
	
	public List<DepartmentTO> findAll();
	
	public DepartmentTO findDepartmentById(Long id); 
	
	public List<EmployeeTO> findAllDepartmentEmployee(Long departmentId);
	
	public List<EmployeeTO> findDepartmentEmployeeAssignedToCar(Long departmentId, Long carId);
	
}
