package com.capgemini.jpa.domain.tos;

import com.capgemini.jpa.domain.enums.CarBrand;
import com.capgemini.jpa.domain.enums.CarType;

public class CarCreationDataTO {

	private int productionYear;
	private String color;
	private int engineCapacity;
	private int carPower;
	private float mileage;
	private CarBrand carBrand;
	private CarType carType;
	private String model;
	private String vin;

	public CarCreationDataTO() {
		
	}
	
	public CarCreationDataTO(int productionYear, String color, int engineCapacity, int carPower, float mileage,
			CarBrand carBrand, CarType carType, String model, String vin) {
		this.productionYear = productionYear;
		this.color = color;
		this.engineCapacity = engineCapacity;
		this.carPower = carPower;
		this.mileage = mileage;
		this.carBrand = carBrand;
		this.carType = carType;
		this.model = model;
		this.vin = vin;
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

	// builder
	public static class CarCreationDataTOBuilder{
		
		private int productionYear;
		private String color;
		private int engineCapacity;
		private int carPower;
		private float mileage;
		private CarBrand carBrand;
		private CarType carType;
		private String model;
		private String vin;
		
		public CarCreationDataTOBuilder withProductionYear(int productionYear) {
			this.productionYear = productionYear;
			return this;
		}

		public CarCreationDataTOBuilder withColor(String color) {
			this.color = color;
			return this;
		}

		public CarCreationDataTOBuilder withEngineCapacity(int engineCapacity) {
			this.engineCapacity = engineCapacity;
			return this;
		}

		public CarCreationDataTOBuilder withCarPower(int carPower) {
			this.carPower = carPower;
			return this;
		}

		public CarCreationDataTOBuilder withMileage(float mileage) {
			this.mileage = mileage;
			return this;
		}

		public CarCreationDataTOBuilder withCarBrand(CarBrand carBrand) {
			this.carBrand = carBrand;
			return this;
		}

		public CarCreationDataTOBuilder withCarType(CarType carType) {
			this.carType = carType;
			return this;
		}

		public CarCreationDataTOBuilder withModel(String model) {
			this.model = model;
			return this;
		}

		public CarCreationDataTOBuilder withVin(String vin) {
			this.vin = vin;
			return this;
		}
		
		public CarCreationDataTO build() {
			return new CarCreationDataTO(productionYear, color, engineCapacity, carPower, mileage, carBrand, carType, model, vin);
		}
		
	}
}
