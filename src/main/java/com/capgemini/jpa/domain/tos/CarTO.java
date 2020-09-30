package com.capgemini.jpa.domain.tos;

import java.time.LocalDateTime;
import java.util.List;

public class CarTO {

	private Long id;
	private Long version;
	private LocalDateTime updateDate;
	private LocalDateTime creationDate;

	private CarModelTO carModel;
	private List<RentTO> rents;
	private List<EmployeeTO> employees;
	private int productionYear;
	private String color;
	private int engineCapacity;
	private int carPower;
	private float mileage;

	public CarTO() {

	}

	public CarTO(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate, CarModelTO carModel,
			List<RentTO> rents, List<EmployeeTO> employees, int productionYear, String color, int engineCapacity,
			int carPower, float mileage) {
		this.id = id;
		this.version = version;
		this.updateDate = updateDate;
		this.creationDate = creationDate;
		this.carModel = carModel;
		this.rents = rents;
		this.employees = employees;
		this.productionYear = productionYear;
		this.color = color;
		this.engineCapacity = engineCapacity;
		this.carPower = carPower;
		this.mileage = mileage;
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

	public CarModelTO getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModelTO carModel) {
		this.carModel = carModel;
	}

	public List<RentTO> getRents() {
		return rents;
	}

	public void setRents(List<RentTO> rents) {
		this.rents = rents;
	}

	public List<EmployeeTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeTO> employees) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carModel == null) ? 0 : carModel.hashCode());
		result = prime * result + carPower;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + engineCapacity;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(mileage);
		result = prime * result + productionYear;
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
		CarTO other = (CarTO) obj;
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
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (engineCapacity != other.engineCapacity)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(mileage) != Float.floatToIntBits(other.mileage))
			return false;
		if (productionYear != other.productionYear)
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
	public static class CarTOBuilder {
		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private CarModelTO carModel;
		private List<RentTO> rents;
		private List<EmployeeTO> employees;
		private int productionYear;
		private String color;
		private int engineCapacity;
		private int carPower;
		private float mileage;

		public CarTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public CarTOBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public CarTOBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public CarTOBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public CarTOBuilder withCarModel(CarModelTO carModel) {
			this.carModel = carModel;
			return this;
		}

		public CarTOBuilder withRents(List<RentTO> rents) {
			this.rents = rents;
			return this;
		}

		public CarTOBuilder withEmployees(List<EmployeeTO> employees) {
			this.employees = employees;
			return this;
		}

		public CarTOBuilder withProductionYear(int productionYear) {
			this.productionYear = productionYear;
			return this;
		}

		public CarTOBuilder withColor(String color) {
			this.color = color;
			return this;
		}

		public CarTOBuilder withEngineCapacity(int engineCapacity) {
			this.engineCapacity = engineCapacity;
			return this;
		}

		public CarTOBuilder withCarPower(int carPower) {
			this.carPower = carPower;
			return this;
		}

		public CarTOBuilder withMileage(float mileage) {
			this.mileage = mileage;
			return this;
		}

		public CarTO build() {
			return new CarTO(id, version, updateDate, creationDate, carModel, rents, employees, productionYear, color,
					engineCapacity, carPower, mileage);
		}
	}
}
