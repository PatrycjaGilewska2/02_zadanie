package com.capgemini.jpa.domain.tos;

import java.time.LocalDateTime;
import java.util.List;

public class DepartmentTO {

	private Long id;
	private Long version;
	private LocalDateTime updateDate;
	private LocalDateTime creationDate;

	private AddressTO address;
	private ContactDataTO contactData;
	private List<EmployeeTO> employees;

	public DepartmentTO() {

	}

	public DepartmentTO(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate, AddressTO address,
			ContactDataTO contactData, List<EmployeeTO> employees) {
		this.id = id;
		this.version = version;
		this.updateDate = updateDate;
		this.creationDate = creationDate;
		this.address = address;
		this.contactData = contactData;
		this.employees = employees;
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

	public AddressTO getAddress() {
		return address;
	}

	public void setAddress(AddressTO address) {
		this.address = address;
	}

	public ContactDataTO getContactData() {
		return contactData;
	}

	public void setContactData(ContactDataTO contactData) {
		this.contactData = contactData;
	}

	public List<EmployeeTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeTO> employees) {
		this.employees = employees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((contactData == null) ? 0 : contactData.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DepartmentTO other = (DepartmentTO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (contactData == null) {
			if (other.contactData != null)
				return false;
		} else if (!contactData.equals(other.contactData))
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
	public static class DepartmentTOBuilder {

		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private AddressTO address;
		private ContactDataTO contactData;
		private List<EmployeeTO> employees;

		public DepartmentTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public DepartmentTOBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public DepartmentTOBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public DepartmentTOBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public DepartmentTOBuilder withAddress(AddressTO address) {
			this.address = address;
			return this;
		}

		public DepartmentTOBuilder withContactData(ContactDataTO contactData) {
			this.contactData = contactData;
			return this;
		}

		public DepartmentTOBuilder withEmployees(List<EmployeeTO> employees) {
			this.employees = employees;
			return this;
		}

		public DepartmentTO build() {
			return new DepartmentTO(id, version, updateDate, creationDate, address, contactData, employees);
		}
	}
}
