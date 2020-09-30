package com.capgemini.jpa.domain.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "T_DEPARTMENT")
public class DepartmentEntity extends AbstractEntity {

	@OneToOne(cascade = CascadeType.ALL)
	private AddressEntity address;

	@OneToOne(cascade = CascadeType.ALL)
	private ContactDataEntity contactData;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<EmployeeEntity> employees;

	public DepartmentEntity() {

	}

	public DepartmentEntity(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate,
			AddressEntity address, ContactDataEntity contactData, List<EmployeeEntity> employees) {
		super(id, version, updateDate, creationDate);
		this.address = address;
		this.contactData = contactData;
		this.employees = employees;
	}

	public ContactDataEntity getContactData() {
		return contactData;
	}

	public void setContactData(ContactDataEntity contactData) {
		this.contactData = contactData;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	public void addEmployee(EmployeeEntity employee) {
		if (employees == null ) {
			employees = new ArrayList<>();
		}
		employees.add(employee);
	}

	public void removeEmployee(EmployeeEntity employee) {
		if (employees == null ) {
			employees = new ArrayList<>();
		}
		employees.remove(employee);
	}

	// builder
	public static class DepartmentEntityBuilder {

		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private AddressEntity address;
		private ContactDataEntity contactData;
		private List<EmployeeEntity> employees;

		public DepartmentEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public DepartmentEntityBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public DepartmentEntityBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public DepartmentEntityBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public DepartmentEntityBuilder withAddress(AddressEntity address) {
			this.address = address;
			return this;
		}

		public DepartmentEntityBuilder withContactData(ContactDataEntity contactData) {
			this.contactData = contactData;
			return this;
		}

		public DepartmentEntityBuilder withEmployees(List<EmployeeEntity> employees) {
			this.employees = employees;
			return this;
		}

		public DepartmentEntity build() {
			return new DepartmentEntity(id, version, updateDate, creationDate, address, contactData, employees);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((contactData == null) ? 0 : contactData.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
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
		DepartmentEntity other = (DepartmentEntity) obj;
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
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		return true;
	}
}
