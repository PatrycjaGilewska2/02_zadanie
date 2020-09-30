package com.capgemini.jpa.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jpa.domain.entities.RentEntity;
import com.capgemini.jpa.domain.tos.RentTO;
import com.capgemini.jpa.repository.RentRepository;
import com.capgemini.jpa.service.RentService;
import com.google.gson.reflect.TypeToken;

@Service
public class RentServiceImpl implements RentService {

	private ModelMapper modelMapper = new ModelMapper();
	private Type listRentTOType = new TypeToken<ArrayList<RentTO>>() {
	}.getType();

	@Autowired
	private RentRepository rentRepository;

	@Override
	@Transactional(readOnly = true)
	public List<RentTO> findAll() {
		List<RentEntity> rents = rentRepository.findAll();
		List<RentTO> result = modelMapper.map(rents, listRentTOType);
		return result;
	}

	@Override
	@Transactional
	public void detachDepartment(Long departmentId) {
		List<RentEntity> endRents = rentRepository.findEmployeesByEndDepartmentId(departmentId);
		List<RentEntity> startRents = rentRepository.findEmployeesByStartDepartmentId(departmentId);

		for (RentEntity rentEntity : startRents) {
			rentEntity.setStartDepartment(null);
			rentRepository.save(rentEntity);
		}

		for (RentEntity rentEntity : endRents) {
			rentEntity.setEndDepartment(null);
			rentRepository.save(rentEntity);
		}
	}
}
