package com.capgemini.jpa.domain.tos;

import java.time.LocalDateTime;

public class ClientTO {

	private Long id;
	private Long version;
	private LocalDateTime updateDate;
	private LocalDateTime creationDate;

	private PersonalInfoTO personalInfo;
	private ContactDataTO contactData;
	private String creditCardNumber;

	public ClientTO() {

	}

	public ClientTO(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate,
			PersonalInfoTO personalInfo, ContactDataTO contactData, String creditCardNumber) {
		this.id = id;
		this.version = version;
		this.updateDate = updateDate;
		this.creationDate = creationDate;
		this.personalInfo = personalInfo;
		this.contactData = contactData;
		this.creditCardNumber = creditCardNumber;
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

	public PersonalInfoTO getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfoTO personalInfo) {
		this.personalInfo = personalInfo;
	}

	public ContactDataTO getContactData() {
		return contactData;
	}

	public void setContactData(ContactDataTO contactData) {
		this.contactData = contactData;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactData == null) ? 0 : contactData.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((creditCardNumber == null) ? 0 : creditCardNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((personalInfo == null) ? 0 : personalInfo.hashCode());
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
		ClientTO other = (ClientTO) obj;
		if (contactData == null) {
			if (other.contactData != null)
				return false;
		} else if (!contactData.equals(other.contactData))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (creditCardNumber == null) {
			if (other.creditCardNumber != null)
				return false;
		} else if (!creditCardNumber.equals(other.creditCardNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (personalInfo == null) {
			if (other.personalInfo != null)
				return false;
		} else if (!personalInfo.equals(other.personalInfo))
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
	public static class ClientTOBuilder {

		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private PersonalInfoTO personalInfo;
		private ContactDataTO contactData;
		private String creditCardNumber;

		public ClientTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public ClientTOBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public ClientTOBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public ClientTOBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public ClientTOBuilder withPersonalInfo(PersonalInfoTO personalInfo) {
			this.personalInfo = personalInfo;
			return this;
		}

		public ClientTOBuilder withContactData(ContactDataTO contactData) {
			this.contactData = contactData;
			return this;
		}

		public ClientTOBuilder withCreditCardNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
			return this;
		}

		public ClientTO build() {
			return new ClientTO(id, version, updateDate, creationDate, personalInfo, contactData, creditCardNumber);
		}
	}
}
