package com.capgemini.jpa.domain.tos;

import java.time.LocalDateTime;

import com.capgemini.jpa.domain.enums.CarBrand;
import com.capgemini.jpa.domain.enums.CarType;

public class CarModelTO {

	private Long id;
	private Long version;
	private LocalDateTime updateDate;
	private LocalDateTime creationDate;

	private CarBrand carBrand;
	private CarType carType;
	private String model;
	private String vin;

	public CarModelTO() {

	}

	public CarModelTO(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate, CarBrand carBrand,
			CarType carType, String model, String vin) {
		this.id = id;
		this.version = version;
		this.updateDate = updateDate;
		this.creationDate = creationDate;
		this.carBrand = carBrand;
		this.carType = carType;
		this.model = model;
		this.vin = vin;
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

	public CarBrand getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carBrand == null) ? 0 : carBrand.hashCode());
		result = prime * result + ((carType == null) ? 0 : carType.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
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
		CarModelTO other = (CarModelTO) obj;
		if (carBrand != other.carBrand)
			return false;
		if (carType != other.carType)
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
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
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
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		return true;
	}

	// builder
	public static class CarModelTOBuilder {
		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private CarBrand carBrand;
		private CarType carType;
		private String model;
		private String vin;

		public CarModelTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public CarModelTOBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public CarModelTOBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public CarModelTOBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public CarModelTOBuilder withCarBrand(CarBrand carBrand) {
			this.carBrand = carBrand;
			return this;
		}

		public CarModelTOBuilder withCarType(CarType carType) {
			this.carType = carType;
			return this;
		}

		public CarModelTOBuilder withModel(String model) {
			this.model = model;
			return this;
		}

		public CarModelTOBuilder withVin(String vin) {
			this.vin = vin;
			return this;
		}

		public CarModelTO build() {
			return new CarModelTO(id, version, updateDate, creationDate, carBrand, carType, model, vin);
		}
	}
}
