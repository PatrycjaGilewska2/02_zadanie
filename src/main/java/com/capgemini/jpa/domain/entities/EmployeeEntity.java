package com.capgemini.jpa.domain.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.capgemini.jpa.domain.enums.EmployeePosition;

@Entity
@Table(name = "T_EMPLOYEE")
public class EmployeeEntity extends AbstractEntity {

	@ManyToMany(mappedBy = "employees")
	private List<CarEntity> cars;

	@ManyToOne
	private DepartmentEntity department;

	@Enumerated(EnumType.STRING)
	private EmployeePosition employeePosition;

	@OneToOne(cascade = CascadeType.ALL)
	private PersonalInfoEntity personalInfo;

	public EmployeeEntity() {

	}

	public EmployeeEntity(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate,
			List<CarEntity> cars, DepartmentEntity department, EmployeePosition employeePosition,
			PersonalInfoEntity personalInfo) {
		super(id, version, updateDate, creationDate);
		this.cars = cars;
		this.department = department;
		this.employeePosition = employeePosition;
		this.personalInfo = personalInfo;
	}

	public List<CarEntity> getCars() {
		return cars;
	}

	public void setCars(List<CarEntity> cars) {
		this.cars = cars;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public EmployeePosition getEmployeePosition() {
		return employeePosition;
	}

	public void setEmployeePosition(EmployeePosition employeePosition) {
		this.employeePosition = employeePosition;
	}

	public PersonalInfoEntity getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfoEntity personalInfo) {
		this.personalInfo = personalInfo;
	}

	public void addCar(CarEntity car) {
		if (cars == null) {
			cars = new ArrayList<>();
		}
		cars.add(car);
	}

	public void removeEmployee(CarEntity car) {
		cars.remove(car);
	}

	// builder
	public static class EmployeeEntityBuilder {
		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private List<CarEntity> cars;
		private DepartmentEntity department;
		private EmployeePosition employeePosition;
		private PersonalInfoEntity personalInfo;

		public EmployeeEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public EmployeeEntityBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public EmployeeEntityBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public EmployeeEntityBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public EmployeeEntityBuilder withCars(List<CarEntity> cars) {
			this.cars = cars;
			return this;
		}

		public EmployeeEntityBuilder withDepartment(DepartmentEntity department) {
			this.department = department;
			return this;
		}

		public EmployeeEntityBuilder withEmployeePosition(EmployeePosition employeePosition) {
			this.employeePosition = employeePosition;
			return this;
		}

		public EmployeeEntityBuilder withPersonalInfo(PersonalInfoEntity personalInfo) {
			this.personalInfo = personalInfo;
			return this;
		}

		public EmployeeEntity build() {
			return new EmployeeEntity(id, version, updateDate, creationDate, cars, department, employeePosition,
					personalInfo);
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
			EmployeeEntityBuilder other = (EmployeeEntityBuilder) obj;
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
	}
}
