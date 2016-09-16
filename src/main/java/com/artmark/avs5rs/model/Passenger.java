package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Пассажир
 *
 * @author V.Skorykh
 * @since 31.01.2008 21:36:36
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Passenger")
public class Passenger {

	/**
	 * Фамилия. Лимит: 64 символа.
	 */
	protected String lastName;

	/**
	 * Имя. Лимит: 64 символа.
	 */
	protected String firstName;

	/**
	 * Отчество. Заполняется для международных рейсов. Лимит: 64 символа.
	 */
	protected String middleName;

	/**
	 * Номер документа. Лимит: 16 символов.
	 */
	protected String docNum;

	/**
	 * Серия документа. Лимит: 16 символов.
	 */
	protected String docSeries;

	/**
	 * ID типа документа
	 */
	protected String docTypeId;

	/**
	 * Телефон пассажира. Может использоваться для экстренной связи с пассажиром
	 */
	protected String phone;

	/**
	 * Дата рождения. Заполняется для международных рейсов.
	 */
	@XmlJavaTypeAdapter(DateAdapter.class)
	protected Date birthday;

	/**
	 * Гражданство. Лимит: 32 символа. Начиная с версии 5.2.2 можно подавать не название страны, а двузначный код страны
	 */
	protected String citizenshipISO2;

	/**
	 * Пол. См. константы GENDER_MALE и GENDER_FEMALE
	 */
	protected Gender gender;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getDocNum() {
		return docNum;
	}

	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}

	public String getDocSeries() {
		return docSeries;
	}

	public void setDocSeries(String docSeries) {
		this.docSeries = docSeries;
	}

	public String getDocTypeId() {
		return docTypeId;
	}

	public void setDocTypeId(String docTypeId) {
		this.docTypeId = docTypeId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCitizenshipISO2() {
		return citizenshipISO2;
	}

	public void setCitizenshipISO2(String citizenshipISO2) {
		this.citizenshipISO2 = citizenshipISO2;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}