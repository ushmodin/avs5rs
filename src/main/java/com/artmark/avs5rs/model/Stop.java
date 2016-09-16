package com.artmark.avs5rs.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Остановка рейса
 *
 * @author V.Skorykh
 * @since 28.08.2014 14:46
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Stop {

	/**
	 * ID остановки. Совпадает с ID станции. Обязателен.
	 */
	private String id;

	/**
	 * Название остановки. Совпадает с названием станции. Обязателен.
	 */
	private String name;

	/**
	 * Район расположения остановки. Не обязателен.
	 */
	private String regionName;

	/**
	 * Дата-время прибытия на остановку. Обязателен.
	 */
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	private Date arrivalDate;

	/**
	 * Дата-время отправления с остановки. Обязателен.
	 */
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	private Date dispatchDate;

	/**
	 * Время стоянки в минутах. Не Обязателен.
	 */
	private Integer stopTime;

	/**
	 * Расстояние от пункта отправления до остановки в км. Не Обязателен.
	 */
	private Integer distance;

	/**
	 * Цена полного билета. Обязателен.
	 */
	private BigDecimal price;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Integer getStopTime() {
		return stopTime;
	}

	public void setStopTime(Integer stopTime) {
		this.stopTime = stopTime;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
