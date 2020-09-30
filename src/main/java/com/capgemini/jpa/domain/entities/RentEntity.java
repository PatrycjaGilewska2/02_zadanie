package com.capgemini.jpa.domain.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_RENT")
public class RentEntity extends AbstractEntity {

	@ManyToOne
	private DepartmentEntity startDepartment;

	@ManyToOne(optional = true)
	private DepartmentEntity endDepartment;

	@ManyToOne
	private CarEntity car;

	@ManyToOne
	private ClientEntity client;

	@Column(nullable = false)
	private LocalDateTime startDate;

	@Column(nullable = false)
	private LocalDateTime endDate;

	@Column(nullable = false)
	private float rentCost;

	public RentEntity() {

	}

	public RentEntity(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate,
			DepartmentEntity startDepartment, DepartmentEntity endDepartment, CarEntity car, ClientEntity client,
			LocalDateTime startDate, LocalDateTime endDate, float rentCost) {
		super(id, version, updateDate, creationDate);
		this.startDepartment = startDepartment;
		this.endDepartment = endDepartment;
		this.car = car;
		this.client = client;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rentCost = rentCost;
	}

	public DepartmentEntity getStartDepartment() {
		return startDepartment;
	}

	public void setStartDepartment(DepartmentEntity startDepartment) {
		this.startDepartment = startDepartment;
	}

	public DepartmentEntity getEndDepartment() {
		return endDepartment;
	}

	public void setEndDepartment(DepartmentEntity endDepartment) {
		this.endDepartment = endDepartment;
	}

	public CarEntity getCar() {
		return car;
	}

	public void setCar(CarEntity car) {
		this.car = car;
	}

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
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

	// builder
	public static class RentEntityBuilder {

		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private DepartmentEntity startDepartment;
		private DepartmentEntity endDepartment;
		private CarEntity car;
		private ClientEntity client;
		private LocalDateTime startDate;
		private LocalDateTime endDate;
		private float rentCost;

		public RentEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public RentEntityBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public RentEntityBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public RentEntityBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public RentEntityBuilder withStartDepartment(DepartmentEntity startDepartment) {
			this.startDepartment = startDepartment;
			return this;
		}

		public RentEntityBuilder withEndDepartment(DepartmentEntity endDepartment) {
			this.endDepartment = endDepartment;
			return this;
		}

		public RentEntityBuilder withCar(CarEntity car) {
			this.car = car;
			return this;
		}

		public RentEntityBuilder withClient(ClientEntity client) {
			this.client = client;
			return this;
		}

		public RentEntityBuilder withStartDate(LocalDateTime startDate) {
			this.startDate = startDate;
			return this;
		}

		public RentEntityBuilder withEndDate(LocalDateTime endDate) {
			this.endDate = endDate;
			return this;
		}

		public RentEntityBuilder withRentCost(float rentCost) {
			this.rentCost = rentCost;
			return this;
		}

		public RentEntity build() {
			return new RentEntity(id, version, updateDate, creationDate, startDepartment, endDepartment, car, client,
					startDate, endDate, rentCost);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((endDepartment == null) ? 0 : endDepartment.hashCode());
		result = prime * result + Float.floatToIntBits(rentCost);
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((startDepartment == null) ? 0 : startDepartment.hashCode());
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
		RentEntity other = (RentEntity) obj;
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
		return true;
	}
}
