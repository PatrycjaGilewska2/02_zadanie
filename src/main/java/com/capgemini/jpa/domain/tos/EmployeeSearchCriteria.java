package com.capgemini.jpa.domain.tos;

import com.capgemini.jpa.domain.enums.EmployeePosition;

public class EmployeeSearchCriteria {
	private Long departmentId;
	private Long carId;
	private EmployeePosition employeePosition;
	
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	public EmployeePosition getEmployeePosition() {
		return employeePosition;
	}
	public void setEmployeePosition(EmployeePosition employeePosition) {
		this.employeePosition = employeePosition;
	}
}
