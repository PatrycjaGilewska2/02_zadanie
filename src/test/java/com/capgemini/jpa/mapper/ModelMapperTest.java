package com.capgemini.jpa.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import com.capgemini.jpa.domain.entities.AddressEntity;
import com.capgemini.jpa.domain.entities.ContactDataEntity;
import com.capgemini.jpa.domain.entities.PersonalInfoEntity;
import com.capgemini.jpa.domain.tos.AddressTO;
import com.capgemini.jpa.domain.tos.ContactDataTO;
import com.capgemini.jpa.domain.tos.PersonalInfoTO;
import com.google.gson.reflect.TypeToken;

public class ModelMapperTest {

	private ModelMapper modelMapper = new ModelMapper();

	@Test
	public void shouldMapEntityToTO() {
		// given
		String email = "andrzej@fsada.com";
		String phoneNumber = "723062325";
		Long id = 1L;
		Long version = 2L;
		LocalDateTime creationDate = LocalDateTime.now();

		ContactDataEntity contactDataEntity = new ContactDataEntity.ContactDataEntityBuilder().withEmail(email)
				.withPhoneNumber(phoneNumber).withId(id).withVersion(version).withCreationDate(creationDate).build();
		// when
		ContactDataTO contactDataTO = modelMapper.map(contactDataEntity, ContactDataTO.class);
		// then
		assertEquals(email, contactDataTO.getEmail());
		assertEquals(phoneNumber, contactDataTO.getPhoneNumber());
		assertEquals(id, contactDataTO.getId());
		assertEquals(version, contactDataTO.getVersion());
		assertEquals(creationDate, contactDataTO.getCreationDate());
		assertNull(contactDataTO.getUpdateDate());
	}
	
	@Test
	public void shouldMapListOfEntitiesToTOs() {
		// given
		String email = "andrzej@fsada.com";
		String phoneNumber = "723062325";
		Long version = 2L;
		LocalDateTime creationDate = LocalDateTime.now();

		ContactDataEntity contactDataEntity1 = new ContactDataEntity.ContactDataEntityBuilder().withEmail(email)
				.withPhoneNumber(phoneNumber).withId(1L).withVersion(version).withCreationDate(creationDate).build();
		ContactDataEntity contactDataEntity2 = new ContactDataEntity.ContactDataEntityBuilder().withEmail(email)
				.withPhoneNumber(phoneNumber).withId(2L).withVersion(version).withCreationDate(creationDate).build();
		ContactDataEntity contactDataEntity3 = new ContactDataEntity.ContactDataEntityBuilder().withEmail(email)
				.withPhoneNumber(phoneNumber).withId(3L).withVersion(version).withCreationDate(creationDate).build();
		
		List<ContactDataEntity> listToMap = new ArrayList<>();
		listToMap.add(contactDataEntity1);
		listToMap.add(contactDataEntity2);
		listToMap.add(contactDataEntity3);
		// when
		Type targetListType = new TypeToken<ArrayList<ContactDataTO>>() {}.getType();
		List<ContactDataTO> mappedList = modelMapper.map(listToMap, targetListType);
		// then
		assertEquals(3, mappedList.size());
		assertEquals(email, mappedList.get(0).getEmail());
		assertEquals(phoneNumber, mappedList.get(0).getPhoneNumber());
		assertEquals(1L, (long) mappedList.get(0).getId());
		assertEquals(version, mappedList.get(0).getVersion());
		assertEquals(creationDate, mappedList.get(0).getCreationDate());
		assertNull(mappedList.get(0).getUpdateDate());
		
		assertEquals(2L, (long) mappedList.get(1).getId());
		assertEquals(3L, (long) mappedList.get(2).getId());
	}

	@Test
	public void shouldMapTOToEntity() {
		// given
		String email = "andrzej@fsada.com";
		String phoneNumber = "723062325";
		Long id = 1L;
		Long version = 2L;
		LocalDateTime creationDate = LocalDateTime.now();

		ContactDataTO contactDataTO = new ContactDataTO.ContactDataTOBuilder().withEmail(email)
				.withPhoneNumber(phoneNumber).withId(id).withVersion(version).withCreationDate(creationDate).build();
		// when
		ContactDataEntity contactDataEntity = modelMapper.map(contactDataTO, ContactDataEntity.class);
		// then
		assertEquals(email, contactDataEntity.getEmail());
		assertEquals(phoneNumber, contactDataEntity.getPhoneNumber());
		assertEquals(id, contactDataEntity.getId());
		assertEquals(version, contactDataEntity.getVersion());
		assertEquals(creationDate, contactDataEntity.getCreationDate());
		assertNull(contactDataEntity.getUpdateDate());
	}

	@Test
	public void shouldMapEntityToTOWithEmbededObject() {
		// given
		String street = "Nowa";
		String postalCode = "42125";
		Long addressId = 1L;
		Long profileInfoId = 17L;
		String name = "Andrzej";
		String surename = "Strzelba";
		Long version = 2L;
		LocalDateTime creationDate = LocalDateTime.now();

		AddressEntity addressEntity = new AddressEntity.AddressEntityBuilder().withStreet(street)
				.withPostalCode(postalCode).withId(addressId).build();
		PersonalInfoEntity personalInfoEntity = new PersonalInfoEntity.PersonalInfoEntityBuilder()
				.withAddres(addressEntity).withName(name).withSurename(surename).withVersion(version)
				.withId(profileInfoId).withCreationDate(creationDate).build();
		// when
		PersonalInfoTO personalInfoTO = modelMapper.map(personalInfoEntity, PersonalInfoTO.class);
		// then
		AddressTO addresTO = personalInfoTO.getAddres();

		assertEquals(profileInfoId, personalInfoTO.getId());
		assertEquals(version, personalInfoTO.getVersion());
		assertEquals(creationDate, personalInfoTO.getCreationDate());
		assertEquals(name, personalInfoTO.getName());
		assertEquals(surename, personalInfoTO.getSurename());
		assertNull(personalInfoTO.getUpdateDate());

		assertEquals(addressId, addresTO.getId());
		assertEquals(street, addresTO.getStreet());
		assertEquals(postalCode, addresTO.getPostalCode());
	}

	@Test
	public void shouldMapTOToEntityWithEmbededObject() {
		// given
		String street = "Nowa";
		String postalCode = "42125";
		Long addressId = 1L;
		Long profileInfoId = 17L;
		String name = "Andrzej";
		String surename = "Strzelba";
		Long version = 2L;
		LocalDateTime creationDate = LocalDateTime.now();

		AddressTO addressTO = new AddressTO.AddressTOBuilder().withStreet(street).withPostalCode(postalCode)
				.withId(addressId).build();
		PersonalInfoTO personalInfoTO = new PersonalInfoTO.PersonalInfoTOBuilder().withAddres(addressTO).withName(name)
				.withSurename(surename).withVersion(version).withId(profileInfoId).withCreationDate(creationDate)
				.build();
		// when
		PersonalInfoEntity personalInfoEntity = modelMapper.map(personalInfoTO, PersonalInfoEntity.class);
		// then
		AddressEntity addresEntity = personalInfoEntity.getAddres();

		assertEquals(profileInfoId, personalInfoEntity.getId());
		assertEquals(version, personalInfoEntity.getVersion());
		assertEquals(creationDate, personalInfoEntity.getCreationDate());
		assertEquals(name, personalInfoEntity.getName());
		assertEquals(surename, personalInfoEntity.getSurename());
		assertNull(personalInfoEntity.getUpdateDate());

		assertEquals(addressId, addresEntity.getId());
		assertEquals(street, addresEntity.getStreet());
		assertEquals(postalCode, addresEntity.getPostalCode());
	}
}
