package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 10:30
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetArrivalStationsResponse")
public class GetArrivalStationsResponse {
	@XmlElement(name = "Station")
	private List<Station> stations;

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
}
