package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 10:53
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GetFreeSeatsRequest")
public class GetFreeSeatsRequest {

	/**
	 * Идентификатор рейса. Обязательный.
	 */
	private String tripId;
	/**
	 * Идентификатор станции отправления. Обязательный.
	 */
	private String dispatchStationId;
	/**
	 * Идентификатор станции назначения. Обязательный.
	 */
	private String arrivalStationId;

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getDispatchStationId() {
		return dispatchStationId;
	}

	public void setDispatchStationId(String dispatchStationId) {
		this.dispatchStationId = dispatchStationId;
	}

	public String getArrivalStationId() {
		return arrivalStationId;
	}

	public void setArrivalStationId(String arrivalStationId) {
		this.arrivalStationId = arrivalStationId;
	}
}
