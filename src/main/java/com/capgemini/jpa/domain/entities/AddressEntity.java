package com.capgemini.jpa.domain.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_ADDRESS")
public class AddressEntity extends AbstractEntity {

	@Column(length = 45, nullable = false)
	private String city;

	@Column(length = 5, nullable = false)
	private String postalCode;

	@Column(length = 45, nullable = false)
	private String street;

	@Column(length = 5, nullable = false)
	private String houseNumber;

	public AddressEntity() {

	}

	public AddressEntity(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate, String city,
			String postalCode, String street, String houseNumber) {
		super(id, version, updateDate, creationDate);
		this.city = city;
		this.postalCode = postalCode;
		this.street = street;
		this.houseNumber = houseNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	// builder
	public static class AddressEntityBuilder {

		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private String city;
		private String postalCode;
		private String street;
		private String houseNumber;

		public AddressEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public AddressEntityBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public AddressEntityBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public AddressEntityBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public AddressEntityBuilder withCity(String city) {
			this.city = city;
			return this;
		}

		public AddressEntityBuilder withPostalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public AddressEntityBuilder withStreet(String street) {
			this.street = street;
			return this;
		}

		public AddressEntityBuilder withHouseNumber(String houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}

		public AddressEntity build() {
			return new AddressEntity(id, version, updateDate, creationDate, city, postalCode, street, houseNumber);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((houseNumber == null) ? 0 : houseNumber.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		AddressEntity other = (AddressEntity) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (houseNumber == null) {
			if (other.houseNumber != null)
				return false;
		} else if (!houseNumber.equals(other.houseNumber))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
}
