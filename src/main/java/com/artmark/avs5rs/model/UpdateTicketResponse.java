package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Ushmodin N.
 * @since 12.07.2016 12:13
 */
@XmlType(name = "UpdateTicketResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateTicketResponse {
	@XmlElement(name = "Ticket")
	private Ticket ticket;

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
}
