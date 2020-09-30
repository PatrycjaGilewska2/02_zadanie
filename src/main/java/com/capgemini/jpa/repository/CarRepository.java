package com.capgemini.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.jpa.domain.entities.CarEntity;
import com.capgemini.jpa.domain.enums.CarBrand;
import com.capgemini.jpa.domain.enums.CarType;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

	@Query("select car from CarEntity car where car.carModel.carType = :type AND car.carModel.carBrand = :brand")
	public List<CarEntity> findCarsByTypeAndBrand(@Param("type") CarType type,@Param("brand") CarBrand brand);

	@Query("select car from CarEntity car join car.employees empl where :employeeId = empl.id")
	public List<CarEntity> findByEmployee(@Param("employeeId") Long employeeId);

}
