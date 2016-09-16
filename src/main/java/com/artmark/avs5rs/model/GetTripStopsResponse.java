package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 10:49
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTripStopsResponse")
public class GetTripStopsResponse {
	@XmlElement(name = "Stop")
	private List<Stop> stops;

	public List<Stop> getStops() {
		return stops;
	}

	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}
}
