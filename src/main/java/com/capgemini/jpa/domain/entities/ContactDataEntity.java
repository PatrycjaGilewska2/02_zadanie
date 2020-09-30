package com.capgemini.jpa.domain.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_CONTACT_DATA")
public class ContactDataEntity extends AbstractEntity {

	@Column(length = 45, nullable = false, unique = true)
	private String phoneNumber;

	@Column(length = 45, nullable = false, unique = true)
	private String email;

	public ContactDataEntity() {

	}

	public ContactDataEntity(Long id, Long version, LocalDateTime updateDate, LocalDateTime creationDate,
			String phoneNumber, String email) {
		super(id, version, updateDate, creationDate);
		this.phoneNumber = phoneNumber;
		this.email = email;
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

	// builder
	public static class ContactDataEntityBuilder {

		private Long id;
		private Long version;
		private LocalDateTime updateDate;
		private LocalDateTime creationDate;

		private String phoneNumber;
		private String email;

		public ContactDataEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public ContactDataEntityBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public ContactDataEntityBuilder withUpdateDate(LocalDateTime updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public ContactDataEntityBuilder withCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public ContactDataEntityBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public ContactDataEntityBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public ContactDataEntity build() {
			return new ContactDataEntity(id, version, updateDate, creationDate, phoneNumber, email);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		ContactDataEntity other = (ContactDataEntity) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

}
