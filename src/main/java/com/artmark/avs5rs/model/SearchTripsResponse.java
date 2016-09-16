package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 10:32
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchTripsResponse")
public class SearchTripsResponse {
	/**
	 * Список рейсов
	 */
	@XmlElement(name = "Trip")
	private List<Trip> trips;

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
}
