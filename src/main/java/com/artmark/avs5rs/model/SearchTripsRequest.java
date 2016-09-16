package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 10:33
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SearchTripsRequest")
public class SearchTripsRequest {

	/**
	 * Идентификатор станции отправления
	 */
	private String dispatchStationId;
	/**
	 * Идентификатор станции назначения
	 */
	private String arrivalStationId;
	/**
	 * Дата на которую выполняется поиск рейса
	 */
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
