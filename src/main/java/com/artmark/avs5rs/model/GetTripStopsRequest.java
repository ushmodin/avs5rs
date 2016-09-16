package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 10:49
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GetTripStopsRequest")
public class GetTripStopsRequest {

	/**
	 * Идентификатор рейса. Обязательно.
	 */
	private String tripId;

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}
}
