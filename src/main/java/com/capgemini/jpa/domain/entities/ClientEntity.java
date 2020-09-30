package com.capgemini.jpa.domain.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_CLIENT")
public class ClientEntity extends AbstractEntity {

	@OneToOne(cascade = CascadeType.ALL)
	private PersonalInfoEntity personalInfo;

	@OneToOne(cascade = CascadeType.ALL)
	private ContactDataEntity contactData;

	@Column(length = 16, unique = true, nullable = true)
	private String creditCardNumber;

	public ClientEntity() {

	}

	public ClientEntity(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate,
			PersonalInfoEntity personalInfo, ContactDataEntity contactData, String creditCardNumber) {
		super(id, version, updateDate, creationDate);
		this.personalInfo = personalInfo;
		this.contactData = contactData;
		this.creditCardNumber = creditCardNumber;
	}

	public PersonalInfoEntity getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfoEntity personalInfo) {
		this.personalInfo = personalInfo;
	}

	public ContactDataEntity getContactData() {
		return contactData;
	}

	public void setContactData(ContactDataEntity contactData) {
		this.contactData = contactData;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	// builder
	public static class ClientEntityBuilder {

		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private PersonalInfoEntity personalInfo;
		private ContactDataEntity contactData;
		private String creditCardNumber;

		public ClientEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public ClientEntityBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public ClientEntityBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public ClientEntityBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public ClientEntityBuilder withPersonalInfo(PersonalInfoEntity personalInfo) {
			this.personalInfo = personalInfo;
			return this;
		}

		public ClientEntityBuilder withContactData(ContactDataEntity contactData) {
			this.contactData = contactData;
			return this;
		}

		public ClientEntityBuilder withCreditCardNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
			return this;
		}

		public ClientEntity build() {
			return new ClientEntity(id, version, updateDate, creationDate, personalInfo, contactData, creditCardNumber);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contactData == null) ? 0 : contactData.hashCode());
		result = prime * result + ((creditCardNumber == null) ? 0 : creditCardNumber.hashCode());
		result = prime * result + ((personalInfo == null) ? 0 : personalInfo.hashCode());
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
		ClientEntity other = (ClientEntity) obj;
		if (contactData == null) {
			if (other.contactData != null)
				return false;
		} else if (!contactData.equals(other.contactData))
			return false;
		if (creditCardNumber == null) {
			if (other.creditCardNumber != null)
				return false;
		} else if (!creditCardNumber.equals(other.creditCardNumber))
			return false;
		if (personalInfo == null) {
			if (other.personalInfo != null)
				return false;
		} else if (!personalInfo.equals(other.personalInfo))
			return false;
		return true;
	}
}
