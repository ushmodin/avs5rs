package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 10:25
 */
@XmlType(name = "EchoResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class EchoResponse {
	/**
	 *  Сообщение переданное в запросе
	 */
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
