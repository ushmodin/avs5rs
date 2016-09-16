package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 11:38
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Station")
public class Station {
	/**
	 * Идентификатор станции. Обязателен.
	 */
	private String id;
	/**
	 * Наименование станции. Обязателен. Использется для отображения в интерфейсе пользователя
	 */
	private String name;
	/**
	 * Название региона станции. Не обязателен. Использется для отображения в интерфейсе пользователя
	 */
	private String region;
	/**
	 * ОКАТО станции. Не обязателен. Использется для поиска одинковых станций и отображения в интерфейсе пользователя
	 * TODO: обязателен или нет?
	 */
	private String okato;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getOkato() {
		return okato;
	}

	public void setOkato(String okato) {
		this.okato = okato;
	}
}
