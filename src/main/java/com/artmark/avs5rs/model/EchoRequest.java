package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 10:25
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "EchoRequest")
public class EchoRequest {
	/**
	 * Сообщение которое будет возвращено в ответ
	 */
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
