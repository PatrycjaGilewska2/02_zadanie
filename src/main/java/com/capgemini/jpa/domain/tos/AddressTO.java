package com.capgemini.jpa.domain.tos;

import java.time.LocalDateTime;

public class AddressTO {

	private Long id;
	private Long version;
	private LocalDateTime updateDate;
	private LocalDateTime creationDate;

	private String city;
	private String postalCode;
	private String street;
	private String houseNumber;

	public AddressTO() {
		
	}

	public AddressTO(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate, String city,
			String postalCode, String street, String houseNumber) {
		this.id = id;
		this.version = version;
		this.updateDate = updateDate;
		this.creationDate = creationDate;
		this.city = city;
		this.postalCode = postalCode;
		this.street = street;
		this.houseNumber = houseNumber;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((houseNumber == null) ? 0 : houseNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		AddressTO other = (AddressTO) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (houseNumber == null) {
			if (other.houseNumber != null)
				return false;
		} else if (!houseNumber.equals(other.houseNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
	public static class AddressTOBuilder {

		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private String city;
		private String postalCode;
		private String street;
		private String houseNumber;

		public AddressTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public AddressTOBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public AddressTOBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public AddressTOBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public AddressTOBuilder withCity(String city) {
			this.city = city;
			return this;
		}

		public AddressTOBuilder withPostalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public AddressTOBuilder withStreet(String street) {
			this.street = street;
			return this;
		}

		public AddressTOBuilder withHouseNumber(String houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}

		public AddressTO build() {
			return new AddressTO(id, version, updateDate, creationDate, city, postalCode, street, houseNumber);
		}
	}
}
