package com.capgemini.jpa.domain.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "T_CAR")
public class CarEntity extends AbstractEntity {

	@OneToOne(cascade = CascadeType.ALL)
	private CarModelEntity carModel;

	@OneToMany(mappedBy="car", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RentEntity> rents;

	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<EmployeeEntity> employees;

	@Column(length = 4, nullable = false)
	private int productionYear;

	@Column(length = 45, nullable = false)
	private String color;

	@Column(nullable = false)
	private int engineCapacity;

	@Column(nullable = false)
	private int carPower;

	@Column(nullable = false)
	private float mileage;

	public CarEntity() {

	}

	public CarEntity(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate,
			CarModelEntity carModel, List<RentEntity> rents, List<EmployeeEntity> employees, int productionYear,
			String color, int engineCapacity, int carPower, float mileage) {
		super(id, version, updateDate, creationDate);
		this.carModel = carModel;
		this.rents = rents;
		this.employees = employees;
		this.productionYear = productionYear;
		this.color = color;
		this.engineCapacity = engineCapacity;
		this.carPower = carPower;
		this.mileage = mileage;
	}

	public CarModelEntity getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModelEntity carModel) {
		this.carModel = carModel;
	}

	public List<RentEntity> getRents() {
		return rents;
	}

	public void setRents(List<RentEntity> rents) {
		this.rents = rents;
	}

	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public int getCarPower() {
		return carPower;
	}

	public void setCarPower(int carPower) {
		this.carPower = carPower;
	}

	public float getMileage() {
		return mileage;
	}

	public void setMileage(float mileage) {
		this.mileage = mileage;
	}

	public void addEmployee(EmployeeEntity employee) {
		if (employees == null) {
			employees = new ArrayList<>();
		}
		employees.add(employee);
	}

	public void removeEmployee(EmployeeEntity employee) {
		employees.remove(employee);
	}

	// builder
	public static class CarEntityBuilder {
		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private CarModelEntity carModel;
		private List<RentEntity> rents;
		private List<EmployeeEntity> employees;
		private int productionYear;
		private String color;
		private int engineCapacity;
		private int carPower;
		private float mileage;

		public CarEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public CarEntityBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public CarEntityBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public CarEntityBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public CarEntityBuilder withCarModel(CarModelEntity carModel) {
			this.carModel = carModel;
			return this;
		}

		public CarEntityBuilder withRents(List<RentEntity> rents) {
			this.rents = rents;
			return this;
		}

		public CarEntityBuilder withEmployees(List<EmployeeEntity> employees) {
			this.employees = employees;
			return this;
		}

		public CarEntityBuilder withProductionYear(int productionYear) {
			this.productionYear = productionYear;
			return this;
		}

		public CarEntityBuilder withColor(String color) {
			this.color = color;
			return this;
		}

		public CarEntityBuilder withEngineCapacity(int engineCapacity) {
			this.engineCapacity = engineCapacity;
			return this;
		}

		public CarEntityBuilder withCarPower(int carPower) {
			this.carPower = carPower;
			return this;
		}

		public CarEntityBuilder withMileage(float mileage) {
			this.mileage = mileage;
			return this;
		}

		public CarEntity build() {
			return new CarEntity(id, version, updateDate, creationDate, carModel, rents, employees, productionYear,
					color, engineCapacity, carPower, mileage);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((carModel == null) ? 0 : carModel.hashCode());
		result = prime * result + carPower;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + engineCapacity;
		result = prime * result + Float.floatToIntBits(mileage);
		result = prime * result + productionYear;
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
		CarEntity other = (CarEntity) obj;
		if (carModel == null) {
			if (other.carModel != null)
				return false;
		} else if (!carModel.equals(other.carModel))
			return false;
		if (carPower != other.carPower)
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (engineCapacity != other.engineCapacity)
			return false;
		if (Float.floatToIntBits(mileage) != Float.floatToIntBits(other.mileage))
			return false;
		if (productionYear != other.productionYear)
			return false;
		return true;
	}
}
