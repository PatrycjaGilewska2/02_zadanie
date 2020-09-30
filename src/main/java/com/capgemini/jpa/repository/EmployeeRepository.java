package com.capgemini.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.jpa.domain.entities.EmployeeEntity;
import com.capgemini.jpa.domain.enums.EmployeePosition;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	@Query("SELECT e FROM EmployeeEntity e WHERE e.department.id = :id")
	public List<EmployeeEntity> findEmployeesByDepartmentId(@Param("id") Long departmentId);

	@Query("SELECT e FROM EmployeeEntity e JOIN e.department d JOIN e.cars c WHERE d.id = :departmentId OR c.id = :carId OR e.employeePosition = :employeePosition")
	public List<EmployeeEntity> findEmployees(@Param("departmentId") Long departmentId, @Param("carId") Long carId,
			@Param("employeePosition") EmployeePosition employeePosition);
}
