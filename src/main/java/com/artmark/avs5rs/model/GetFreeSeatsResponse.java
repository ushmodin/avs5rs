package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 10:54
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFreeSeatsResponse")
public class GetFreeSeatsResponse {
	@XmlElement(name = "Seat")
	private List<Seat> seats;

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
}
