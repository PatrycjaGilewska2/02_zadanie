package com.capgemini.jpa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.jpa.domain.entities.CarEntity;
import com.capgemini.jpa.domain.entities.RentEntity;

@Repository
public interface RentRepository extends JpaRepository<RentEntity, Long> {

	@Query("SELECT r FROM RentEntity r WHERE r.startDepartment.id = :id")
	public List<RentEntity> findEmployeesByStartDepartmentId(@Param("id") Long id);
	
	@Query("SELECT r FROM RentEntity r WHERE r.endDepartment.id = :id")
	public List<RentEntity> findEmployeesByEndDepartmentId(@Param("id") Long id);
	
	@Query("SELECT DISTINCT r.car FROM RentEntity r WHERE (r.startDate BETWEEN :startDate AND :endDate) AND (r.endDate BETWEEN :startDate AND :endDate)")  
	public List<CarEntity> numberOfCarsUsedBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
	
	@Query("SELECT DISTINCT r.car FROM RentEntity r GROUP BY r.car HAVING COUNT(r) >= :numberOfRents")
	public List<CarEntity> findCarsByNumberOfRents(int numberOfRents);

}
