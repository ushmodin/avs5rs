package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 10:27
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GetArrivalStationsRequest")
public class GetArrivalStationsRequest {
	/**
	 * Идентификатор станции отправления. Обязательно.
	 */
	private String dispatchStationId;

	public String getDispatchStationId() {
		return dispatchStationId;
	}

	public void setDispatchStationId(String dispatchStationId) {
		this.dispatchStationId = dispatchStationId;
	}
}
