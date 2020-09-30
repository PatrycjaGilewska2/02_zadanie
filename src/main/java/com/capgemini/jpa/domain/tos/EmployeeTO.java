package com.capgemini.jpa.domain.tos;

import java.time.LocalDateTime;
import java.util.List;

import com.capgemini.jpa.domain.enums.EmployeePosition;

public class EmployeeTO {

	private Long id;
	private Long version;
	private LocalDateTime updateDate;
	private LocalDateTime creationDate;

	private List<CarTO> cars;
	private DepartmentTO department;
	private EmployeePosition employeePosition;
	private PersonalInfoTO personalInfo;

	public EmployeeTO() {

	}

	public EmployeeTO(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate, List<CarTO> cars,
			DepartmentTO department, EmployeePosition employeePosition, PersonalInfoTO personalInfo) {
		this.id = id;
		this.version = version;
		this.updateDate = updateDate;
		this.creationDate = creationDate;
		this.cars = cars;
		this.department = department;
		this.employeePosition = employeePosition;
		this.personalInfo = personalInfo;
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

	public List<CarTO> getCars() {
		return cars;
	}

	public void setCars(List<CarTO> cars) {
		this.cars = cars;
	}

	public DepartmentTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentTO department) {
		this.department = department;
	}

	public EmployeePosition getEmployeePosition() {
		return employeePosition;
	}

	public void setEmployeePosition(EmployeePosition employeePosition) {
		this.employeePosition = employeePosition;
	}

	public PersonalInfoTO getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfoTO personalInfo) {
		this.personalInfo = personalInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((employeePosition == null) ? 0 : employeePosition.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((personalInfo == null) ? 0 : personalInfo.hashCode());
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
		EmployeeTO other = (EmployeeTO) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (employeePosition != other.employeePosition)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (personalInfo == null) {
			if (other.personalInfo != null)
				return false;
		} else if (!personalInfo.equals(other.personalInfo))
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
	public static class EmployeeTOBuilder {
		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private List<CarTO> cars;
		private DepartmentTO department;
		private EmployeePosition employeePosition;
		private PersonalInfoTO personalInfo;

		public EmployeeTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public EmployeeTOBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public EmployeeTOBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public EmployeeTOBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public EmployeeTOBuilder withCars(List<CarTO> cars) {
			this.cars = cars;
			return this;
		}

		public EmployeeTOBuilder withDepartment(DepartmentTO department) {
			this.department = department;
			return this;
		}

		public EmployeeTOBuilder withEmployeePosition(EmployeePosition employeePosition) {
			this.employeePosition = employeePosition;
			return this;
		}

		public EmployeeTOBuilder withPersonalInfo(PersonalInfoTO personalInfo) {
			this.personalInfo = personalInfo;
			return this;
		}

		public EmployeeTO build() {
			return new EmployeeTO(id, version, updateDate, creationDate, cars, department, employeePosition,
					personalInfo);
		}
	}
}
