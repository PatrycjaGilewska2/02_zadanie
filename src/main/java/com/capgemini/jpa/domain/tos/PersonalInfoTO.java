package com.capgemini.jpa.domain.tos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PersonalInfoTO {

	private Long id;
	private Long version;
	private LocalDateTime updateDate;
	private LocalDateTime creationDate;

	private String name;
	private String surename;
	private LocalDate birthDate;
	private AddressTO addres;
	
	public PersonalInfoTO() {
		
	}
	
	public PersonalInfoTO(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate, String name,
			String surename, LocalDate birthDate, AddressTO addres) {
		this.id = id;
		this.version = version;
		this.updateDate = updateDate;
		this.creationDate = creationDate;
		this.name = name;
		this.surename = surename;
		this.birthDate = birthDate;
		this.addres = addres;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurename() {
		return surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public AddressTO getAddres() {
		return addres;
	}

	public void setAddres(AddressTO addres) {
		this.addres = addres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addres == null) ? 0 : addres.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surename == null) ? 0 : surename.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonalInfoTO other = (PersonalInfoTO) obj;
		if (addres == null) {
			if (other.addres != null)
				return false;
		} else if (!addres.equals(other.addres))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surename == null) {
			if (other.surename != null)
				return false;
		} else if (!surename.equals(other.surename))
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	// builder
	public static class PersonalInfoTOBuilder{
		
		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private String name;
		private String surename;
		private LocalDate birthDate;
		private AddressTO addres;
		
		public PersonalInfoTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public PersonalInfoTOBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public PersonalInfoTOBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public PersonalInfoTOBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public PersonalInfoTOBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public PersonalInfoTOBuilder withSurename(String surename) {
			this.surename = surename;
			return this;
		}

		public PersonalInfoTOBuilder withBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public PersonalInfoTOBuilder withAddres(AddressTO addres) {
			this.addres = addres;
			return this;
		}
		
		public PersonalInfoTO build() {
			return new PersonalInfoTO(id, version, updateDate, creationDate, name, surename, birthDate, addres);
		}
	}
}
