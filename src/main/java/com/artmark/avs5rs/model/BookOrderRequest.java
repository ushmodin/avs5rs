package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 11:04
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "BookOrderRequest")
public class BookOrderRequest {
	private String tripId;
	private String dispatchStationId;
	private String arrivalStationId;
	@XmlElement(name = "Sale")
	private List<Sale> sales;
	@XmlElement(name = "Agent")
	private Agent agent;

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

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
}
