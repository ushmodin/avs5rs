package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 12:35
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Seat")
public class Seat {
	/**
	 * Идентификатор места. Обязателен. Может сопадать с названием.
	 */
	private String id;
	/**
	 * Название места. Обязателен. Отображается в интерфейсе пользователя.
	 */
	private String name;
	/**
	 * Тип места. Не обязателен
	 */
	private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
