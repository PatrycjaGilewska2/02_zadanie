package com.capgemini.jpa.testdata;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.capgemini.jpa.domain.entities.AddressEntity;
import com.capgemini.jpa.domain.entities.CarEntity;
import com.capgemini.jpa.domain.entities.CarModelEntity;
import com.capgemini.jpa.domain.entities.ClientEntity;
import com.capgemini.jpa.domain.entities.ContactDataEntity;
import com.capgemini.jpa.domain.entities.DepartmentEntity;
import com.capgemini.jpa.domain.entities.EmployeeEntity;
import com.capgemini.jpa.domain.entities.PersonalInfoEntity;
import com.capgemini.jpa.domain.entities.RentEntity;
import com.capgemini.jpa.domain.enums.CarBrand;
import com.capgemini.jpa.domain.enums.CarType;
import com.capgemini.jpa.domain.enums.EmployeePosition;

public class TestData {

//	Address
	public AddressEntity addressEntity1 = new AddressEntity.AddressEntityBuilder().withCity("Lebsackfort")
			.withHouseNumber("40").withPostalCode("52533").withStreet("Rhiannon Knolls").build();
	public AddressEntity addressEntity2 = new AddressEntity.AddressEntityBuilder().withCity("Port Hattiefort")
			.withHouseNumber("31").withPostalCode("22222").withStreet("Towne Mount").build();
	public AddressEntity addressEntity3 = new AddressEntity.AddressEntityBuilder().withCity("East Alice")
			.withHouseNumber("69").withPostalCode("55555").withStreet("Gislason Lake").build();
	public AddressEntity addressEntity4 = new AddressEntity.AddressEntityBuilder().withCity("West Evelyn")
			.withHouseNumber("90").withPostalCode("66666").withStreet("Anderson Spring").build();
	public AddressEntity addressEntity5 = new AddressEntity.AddressEntityBuilder().withCity("New Karsonshire")
			.withHouseNumber("86").withPostalCode("55465").withStreet("Erdman Mission").build();
	public AddressEntity addressEntity6 = new AddressEntity.AddressEntityBuilder().withCity("East Herber")
			.withHouseNumber("68").withPostalCode("52533").withStreet("Connell Roads").build();
	public AddressEntity addressEntity7 = new AddressEntity.AddressEntityBuilder().withCity("Alfonzoside")
			.withHouseNumber("71").withPostalCode("12353").withStreet("Mabelle Tunnel").build();
	public AddressEntity addressEntity8 = new AddressEntity.AddressEntityBuilder().withCity("North Doris")
			.withHouseNumber("79").withPostalCode("55865").withStreet("Rupert Canyon").build();
	public AddressEntity addressEntity9 = new AddressEntity.AddressEntityBuilder().withCity("West Cassie")
			.withHouseNumber("51").withPostalCode("21256").withStreet("Meredith Drives").build();
	public AddressEntity addressEntity10 = new AddressEntity.AddressEntityBuilder().withCity("West Percival")
			.withHouseNumber("83").withPostalCode("52533").withStreet("Rachel Mills").build();

// Email
	public ContactDataEntity contactDataEntity1 = new ContactDataEntity.ContactDataEntityBuilder()
			.withEmail("pziemann@example.com").withPhoneNumber("648-540-286").build();
	public ContactDataEntity contactDataEntity2 = new ContactDataEntity.ContactDataEntityBuilder()
			.withEmail("jdickinson@example.org").withPhoneNumber("091-796-320").build();
	public ContactDataEntity contactDataEntity3 = new ContactDataEntity.ContactDataEntityBuilder()
			.withEmail("melissa.hilpert@example.com").withPhoneNumber("790-358-058").build();
	public ContactDataEntity contactDataEntity4 = new ContactDataEntity.ContactDataEntityBuilder()
			.withEmail("zemlak.vincent@example.com").withPhoneNumber("242-570-558").build();
	public ContactDataEntity contactDataEntity5 = new ContactDataEntity.ContactDataEntityBuilder()
			.withEmail("vbotsford@example.com").withPhoneNumber("780-739-162").build();
	public ContactDataEntity contactDataEntity6 = new ContactDataEntity.ContactDataEntityBuilder()
			.withEmail("mkilback@example.com").withPhoneNumber("554-700-072").build();
	public ContactDataEntity contactDataEntity7 = new ContactDataEntity.ContactDataEntityBuilder()
			.withEmail("goyette.rene@example.com").withPhoneNumber("753-686-217").build();
	public ContactDataEntity contactDataEntity8 = new ContactDataEntity.ContactDataEntityBuilder()
			.withEmail("beer.jules@example.org").withPhoneNumber("851-536-906").build();
	public ContactDataEntity contactDataEntity9 = new ContactDataEntity.ContactDataEntityBuilder()
			.withEmail("jessy23@example.net").withPhoneNumber("858-617-427").build();
	public ContactDataEntity contactDataEntity10 = new ContactDataEntity.ContactDataEntityBuilder()
			.withEmail("blanda.hillard@example.org").withPhoneNumber("868-851-911").build();

//	 Personal Info
	public PersonalInfoEntity personalInfoEntity1 = new PersonalInfoEntity.PersonalInfoEntityBuilder()
			.withBirthDate(LocalDate.of(1979, 8, 4)).withName("Giuseppe").withSurename("Brakus")
			.withAddres(addressEntity1).build();
	public PersonalInfoEntity personalInfoEntity2 = new PersonalInfoEntity.PersonalInfoEntityBuilder()
			.withBirthDate(LocalDate.of(1994, 11, 8)).withName("Harley").withSurename("Jacobson")
			.withAddres(addressEntity2).build();
	public PersonalInfoEntity personalInfoEntity3 = new PersonalInfoEntity.PersonalInfoEntityBuilder()
			.withBirthDate(LocalDate.of(1991, 6, 7)).withName("Newton").withSurename("Watsica")
			.withAddres(addressEntity3).build();
	public PersonalInfoEntity personalInfoEntity4 = new PersonalInfoEntity.PersonalInfoEntityBuilder()
			.withBirthDate(LocalDate.of(1979, 9, 23)).withName("Bulah").withSurename("Bednar")
			.withAddres(addressEntity4).build();
	public PersonalInfoEntity personalInfoEntity5 = new PersonalInfoEntity.PersonalInfoEntityBuilder()
			.withBirthDate(LocalDate.of(2000, 3, 17)).withName("Erling").withSurename("Cole").withAddres(addressEntity5)
			.build();
	public PersonalInfoEntity personalInfoEntity6 = new PersonalInfoEntity.PersonalInfoEntityBuilder()
			.withBirthDate(LocalDate.of(2000, 3, 21)).withName("Wendell").withSurename("Beahan")
			.withAddres(addressEntity6).build();
	public PersonalInfoEntity personalInfoEntity7 = new PersonalInfoEntity.PersonalInfoEntityBuilder()
			.withBirthDate(LocalDate.of(1996, 4, 23)).withName("Jazlyn").withSurename("Bogisich")
			.withAddres(addressEntity7).build();
	public PersonalInfoEntity personalInfoEntity8 = new PersonalInfoEntity.PersonalInfoEntityBuilder()
			.withBirthDate(LocalDate.of(1982, 3, 29)).withName("Tremayne").withSurename("Tromp")
			.withAddres(addressEntity8).build();
	public PersonalInfoEntity personalInfoEntity9 = new PersonalInfoEntity.PersonalInfoEntityBuilder()
			.withBirthDate(LocalDate.of(2000, 5, 23)).withName("Jalen").withSurename("Ledner")
			.withAddres(addressEntity9).build();
	public PersonalInfoEntity personalInfoEntity10 = new PersonalInfoEntity.PersonalInfoEntityBuilder()
			.withBirthDate(LocalDate.of(1974, 8, 20)).withName("Emilie").withSurename("Skiles")
			.withAddres(addressEntity10).build();

//	Car Model
	public CarModelEntity carModelEntity1 = new CarModelEntity.CarModelEntityBuilder().withCarBrand(CarBrand.OPEL)
			.withCarType(CarType.OFFROAD).withModel("Frontera").withVin("82qh30adof6o52vxh").build();
	public CarModelEntity carModelEntityToFindById = new CarModelEntity.CarModelEntityBuilder()
			.withCarBrand(CarBrand.OPEL).withCarType(CarType.OFFROAD).withModel("Frontera").withVin("82qh30adof6o52vxh")
			.build();
	public CarModelEntity carModelEntity2 = new CarModelEntity.CarModelEntityBuilder()
			.withCarBrand(CarBrand.LAMBORGHINI).withCarType(CarType.CABRIO).withModel("Huracan Spider")
			.withVin("87nk27erqz9f64tyk").build();

// Car
	public CarEntity carEntity1 = new CarEntity.CarEntityBuilder().withCarPower(180).withColor("black")
			.withEngineCapacity(2900).withMileage(388197).withProductionYear(2000).withCarModel(carModelEntity1)
			.build();

	public CarEntity carEntityToFindById = new CarEntity.CarEntityBuilder().withCarPower(180).withColor("black")
			.withEngineCapacity(2900).withMileage(388197).withProductionYear(2000)
			.withCarModel(carModelEntityToFindById).build();

	public CarEntity carEntity2 = new CarEntity.CarEntityBuilder().withCarPower(145).withColor("green")
			.withEngineCapacity(2000).withMileage(426861).withProductionYear(2017).withCarModel(carModelEntity2)
			.build();

// Employee
	public EmployeeEntity employeeEntity1 = new EmployeeEntity.EmployeeEntityBuilder()
			.withEmployeePosition(EmployeePosition.MANAGER).withPersonalInfo(personalInfoEntity1).build();
	public EmployeeEntity employeeEntity2 = new EmployeeEntity.EmployeeEntityBuilder()
			.withEmployeePosition(EmployeePosition.SALER).withPersonalInfo(personalInfoEntity2).build();
	public EmployeeEntity employeeEntity3= new EmployeeEntity.EmployeeEntityBuilder()
			.withEmployeePosition(EmployeePosition.SALER).withPersonalInfo(personalInfoEntity3).build();
	public EmployeeEntity employeeEntity4= new EmployeeEntity.EmployeeEntityBuilder()
			.withEmployeePosition(EmployeePosition.SALER).withPersonalInfo(personalInfoEntity4).build();
	public EmployeeEntity employeeEntity5= new EmployeeEntity.EmployeeEntityBuilder()
			.withEmployeePosition(EmployeePosition.SALER).withPersonalInfo(personalInfoEntity5).build();

//	Department
	public DepartmentEntity departmentEntity1 = new DepartmentEntity.DepartmentEntityBuilder()
			.withAddress(addressEntity6).withContactData(contactDataEntity6).build();
	public DepartmentEntity departmentEntity2 = new DepartmentEntity.DepartmentEntityBuilder()
			.withAddress(addressEntity7).withContactData(contactDataEntity8).build();

// Client
	public ClientEntity clientEntity1 = new ClientEntity.ClientEntityBuilder().withCreditCardNumber("4716813089805")
			.withContactData(contactDataEntity1).withPersonalInfo(personalInfoEntity1).build();

//	Rent
	public RentEntity rentEntity1 = new RentEntity.RentEntityBuilder()
			.withEndDate(LocalDateTime.of(LocalDate.of(2018, 5, 13), LocalTime.of(5, 59)))
			.withStartDate(LocalDateTime.of(LocalDate.of(2018, 5, 12), LocalTime.of(7, 00))).withCar(carEntity1)
			.withClient(clientEntity1).withEndDepartment(departmentEntity1).withStartDepartment(departmentEntity1)
			.build();
	public RentEntity rentEntity2 = new RentEntity.RentEntityBuilder()
			.withEndDate(LocalDateTime.of(LocalDate.of(2017, 5, 13), LocalTime.of(5, 59)))
			.withStartDate(LocalDateTime.of(LocalDate.of(2017, 5, 12), LocalTime.of(7, 00))).withCar(carEntity1)
			.withClient(clientEntity1).withEndDepartment(departmentEntity1).withStartDepartment(departmentEntity1)
			.build();
	public RentEntity rentEntity3 = new RentEntity.RentEntityBuilder()
			.withEndDate(LocalDateTime.of(LocalDate.of(2018, 3, 13), LocalTime.of(5, 59)))
			.withStartDate(LocalDateTime.of(LocalDate.of(2018, 3, 12), LocalTime.of(7, 00))).withCar(carEntity1)
			.withClient(clientEntity1).withEndDepartment(departmentEntity1).withStartDepartment(departmentEntity1)
			.build();
}
