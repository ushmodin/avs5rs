package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 11:09
 */


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BookOrderResponse")
public class BookOrderResponse {
	/**
	 * Идентификато договора
	 */
	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
