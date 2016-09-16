package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 12:36
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class DocumentType {
	/**
	 * ID типа документа. Обязателен. Может совпадать с названием.
	 */
	protected String id;

	/**
	 * Название типа документа. Обязателен.
	 */
	protected String name;

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
}
