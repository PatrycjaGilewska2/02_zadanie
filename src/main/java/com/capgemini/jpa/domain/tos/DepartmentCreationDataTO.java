package com.capgemini.jpa.domain.tos;

public class DepartmentCreationDataTO {

	private String city;
	private String postalCode;
	private String street;
	private String houseNumber;
	private String phoneNumber;
	private String email;

	public DepartmentCreationDataTO() {

	}

	public DepartmentCreationDataTO(String city, String postalCode, String street, String houseNumber,
			String phoneNumber, String email) {
		this.city = city;
		this.postalCode = postalCode;
		this.street = street;
		this.houseNumber = houseNumber;
		this.phoneNumber = phoneNumber;
		this.email = email;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// "builder" pattern methods
	public static class DepartmentCreationDataTOBuilder {

		private String city;
		private String postalCode;
		private String street;
		private String houseNumber;
		private String phoneNumber;
		private String email;

		public DepartmentCreationDataTOBuilder withCity(String city) {
			this.city = city;
			return this;
		}

		public DepartmentCreationDataTOBuilder withPostalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public DepartmentCreationDataTOBuilder withStreet(String street) {
			this.street = street;
			return this;
		}

		public DepartmentCreationDataTOBuilder withHouseNumber(String houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}

		public DepartmentCreationDataTOBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public DepartmentCreationDataTOBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public DepartmentCreationDataTO build() {
			return new DepartmentCreationDataTO(city, postalCode, street, houseNumber, phoneNumber, email);
		}
	}
}
