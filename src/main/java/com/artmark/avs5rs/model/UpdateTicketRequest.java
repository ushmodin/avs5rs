package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ushmodin N.
 * @since 12.07.2016 12:14
 */
@XmlRootElement(name = "UpdateTicketRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateTicketRequest {
	private String ticketId;
	@XmlElement(name = "Passenger")
	private Passenger passenger;
	@XmlElement(name = "Agent")
	private Agent agent;

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
}
