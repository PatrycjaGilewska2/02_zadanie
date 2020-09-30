package com.capgemini.jpa.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "	T_PERSONAL_INFO")
public class PersonalInfoEntity extends AbstractEntity {

	@Column(length = 45, nullable = false)
	private String name;

	@Column(length = 45, nullable = false)
	private String surname;

	@Column(length = 45, nullable = false)
	private LocalDate birthDate;

	@OneToOne(cascade = CascadeType.ALL)
	private AddressEntity address;

	public PersonalInfoEntity() {

	}

	public PersonalInfoEntity(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate, String name,
			String surname, LocalDate birthDate, AddressEntity address) {
		super(id, version, updateDate, creationDate);
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurename() {
		return surname;
	}

	public void setSurename(String surename) {
		this.surname = surename;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public AddressEntity getAddres() {
		return address;
	}

	public void setAddres(AddressEntity address) {
		this.address = address;
	}

	// builder
	public static class PersonalInfoEntityBuilder {

		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private String name;
		private String surename;
		private LocalDate birthDate;
		private AddressEntity addres;

		public PersonalInfoEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public PersonalInfoEntityBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public PersonalInfoEntityBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public PersonalInfoEntityBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public PersonalInfoEntityBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public PersonalInfoEntityBuilder withSurename(String surename) {
			this.surename = surename;
			return this;
		}

		public PersonalInfoEntityBuilder withBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public PersonalInfoEntityBuilder withAddres(AddressEntity addres) {
			this.addres = addres;
			return this;
		}

		public PersonalInfoEntity build() {
			return new PersonalInfoEntity(id, version, updateDate, creationDate, name, surename, birthDate, addres);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonalInfoEntity other = (PersonalInfoEntity) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
