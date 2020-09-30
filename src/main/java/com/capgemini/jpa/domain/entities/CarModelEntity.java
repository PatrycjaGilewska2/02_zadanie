package com.capgemini.jpa.domain.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.capgemini.jpa.domain.enums.CarBrand;
import com.capgemini.jpa.domain.enums.CarType;

@Entity
@Table(name = "T_CAR_MODEL")
public class CarModelEntity extends AbstractEntity {

	@Enumerated(EnumType.STRING)
	private CarBrand carBrand;

	@Enumerated(EnumType.STRING)
	private CarType carType;

	@Column(length = 45)
	private String model;

	@Column(length = 17, unique = true)
	private String vin;

	public CarModelEntity() {

	}

	public CarModelEntity(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate,
			CarBrand carBrand, CarType carType, String model, String vin) {
		super(id, version, updateDate, creationDate);
		this.carBrand = carBrand;
		this.carType = carType;
		this.model = model;
		this.vin = vin;
	}

	public CarBrand getBrand() {
		return carBrand;
	}

	public void setBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}

	public CarType getType() {
		return carType;
	}

	public void setType(CarType carType) {
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

	// builder
	public static class CarModelEntityBuilder {
		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private CarBrand carBrand;
		private CarType carType;
		private String model;
		private String vin;

		public CarModelEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public CarModelEntityBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public CarModelEntityBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public CarModelEntityBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public CarModelEntityBuilder withCarBrand(CarBrand carBrand) {
			this.carBrand = carBrand;
			return this;
		}

		public CarModelEntityBuilder withCarType(CarType carType) {
			this.carType = carType;
			return this;
		}

		public CarModelEntityBuilder withModel(String model) {
			this.model = model;
			return this;
		}

		public CarModelEntityBuilder withVin(String vin) {
			this.vin = vin;
			return this;
		}

		public CarModelEntity build() {
			return new CarModelEntity(id, version, updateDate, creationDate, carBrand, carType, model, vin);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((carBrand == null) ? 0 : carBrand.hashCode());
		result = prime * result + ((carType == null) ? 0 : carType.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
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
		CarModelEntity other = (CarModelEntity) obj;
		if (carBrand != other.carBrand)
			return false;
		if (carType != other.carType)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		return true;
	}
}
