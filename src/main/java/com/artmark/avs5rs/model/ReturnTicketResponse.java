package com.artmark.avs5rs.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 11:21
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnTicketResponse")
public class ReturnTicketResponse {
	@XmlElement(name = "Ticket")
	private Ticket ticket;

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
}
