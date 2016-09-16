package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 11:18
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ConfirmOrderRequest")
public class ConfirmOrderRequest {
	private String orderId;
	@XmlElement(name = "Agent")
	private Agent agent;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
}
