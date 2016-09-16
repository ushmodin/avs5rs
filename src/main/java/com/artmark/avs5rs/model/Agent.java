package com.artmark.avs5rs.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Информация об агенте
 *
 * @author V.Skorykh
 * @since 30.05.2016 13:42
 * @since 5.2
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Agent {

	/**
	 * ИНН агента
	 */
	private String inn;

	/**
	 * Имя агента (название организации)
	 */
	private String name;

	public String getInn() {
		return inn;
	}

	public void setInn(String inn) {
		this.inn = inn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
