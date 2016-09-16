package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 10:27
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDispatchStationsResponse")
public class GetDispatchStationsResponse {
	@XmlElement(name = "Station")
	private List<Station> station;

	public List<Station> getStation() {
		return station;
	}

	public void setStation(List<Station> station) {
		this.station = station;
	}
}
