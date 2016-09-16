package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 12:29
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Sale")
public class Sale {
	private String seatId;
	private String ticketTypeId;
	@XmlElement(name = "Passenger")
	private Passenger passenger;

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public String getTicketTypeId() {
		return ticketTypeId;
	}

	public void setTicketTypeId(String ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
}
