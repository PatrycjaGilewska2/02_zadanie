package com.capgemini.jpa.domain.tos;

import java.time.LocalDateTime;

public class RentTO {

	private Long id;
	private Long version;
	private LocalDateTime updateDate;
	private LocalDateTime creationDate;

	private DepartmentTO startDepartment;
	private DepartmentTO endDepartment;
	private CarTO car;
	private ClientTO client;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private float rentCost;

	public RentTO() {

	}

	public RentTO(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate,
			DepartmentTO startDepartment, DepartmentTO endDepartment, CarTO car, ClientTO client,
			LocalDateTime startDate, LocalDateTime endDate, float rentCost) {
		super();
		this.version = version;
		this.updateDate = updateDate;
		this.creationDate = creationDate;
		this.startDepartment = startDepartment;
		this.endDepartment = endDepartment;
		this.car = car;
		this.client = client;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rentCost = rentCost;
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

	public DepartmentTO getStartDepartment() {
		return startDepartment;
	}

	public void setStartDepartment(DepartmentTO startDepartment) {
		this.startDepartment = startDepartment;
	}

	public DepartmentTO getEndDepartment() {
		return endDepartment;
	}

	public void setEndDepartment(DepartmentTO endDepartment) {
		this.endDepartment = endDepartment;
	}

	public CarTO getCar() {
		return car;
	}

	public void setCar(CarTO car) {
		this.car = car;
	}

	public ClientTO getClient() {
		return client;
	}

	public void setClient(ClientTO client) {
		this.client = client;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public float getRentCost() {
		return rentCost;
	}

	public void setRentCost(float rentCost) {
		this.rentCost = rentCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((endDepartment == null) ? 0 : endDepartment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(rentCost);
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((startDepartment == null) ? 0 : startDepartment.hashCode());
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
		RentTO other = (RentTO) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (endDepartment == null) {
			if (other.endDepartment != null)
				return false;
		} else if (!endDepartment.equals(other.endDepartment))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(rentCost) != Float.floatToIntBits(other.rentCost))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (startDepartment == null) {
			if (other.startDepartment != null)
				return false;
		} else if (!startDepartment.equals(other.startDepartment))
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
	public static class RentTOBuilder {

		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private DepartmentTO startDepartment;
		private DepartmentTO endDepartment;
		private CarTO car;
		private ClientTO client;
		private LocalDateTime startDate;
		private LocalDateTime endDate;
		private float rentCost;

		public RentTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public RentTOBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public RentTOBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public RentTOBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public RentTOBuilder withStartDepartment(DepartmentTO startDepartment) {
			this.startDepartment = startDepartment;
			return this;
		}

		public RentTOBuilder withEndDepartment(DepartmentTO endDepartment) {
			this.endDepartment = endDepartment;
			return this;
		}

		public RentTOBuilder withCar(CarTO car) {
			this.car = car;
			return this;
		}

		public RentTOBuilder withClient(ClientTO client) {
			this.client = client;
			return this;
		}

		public RentTOBuilder withStartDate(LocalDateTime startDate) {
			this.startDate = startDate;
			return this;
		}

		public RentTOBuilder withEndDate(LocalDateTime endDate) {
			this.endDate = endDate;
			return this;
		}

		public RentTOBuilder withRentCost(float rentCost) {
			this.rentCost = rentCost;
			return this;
		}

		public RentTO build() {
			return new RentTO(id, version, updateDate, creationDate, startDepartment, endDepartment, car, client,
					startDate, endDate, rentCost);
		}
	}
}
