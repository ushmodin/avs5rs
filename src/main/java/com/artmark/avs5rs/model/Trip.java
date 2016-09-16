package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 11:42
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Trip")
public class Trip {
	/**
	 * ID рейса. Обязателен.
	 */
	private String id;

	/**
	 * Номер маршрута. Не обязателен.
	 */
	private String num;

	/**
	 * Название маршрута. Обязателен.
	 */
	private String name;

	/**
	 * Дата и время отправления. Обязателен.
	 */
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	private Date dispatchDate;

	/**
	 * Дата и время прибытия. Обязателен.
	 */
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	private Date arrivalDate;

	/**
	 * ID станции отправления. Обязателен.
	 */
	private String dispatchStationId;

	/**
	 * Станция отправления рейса. Обязателен.
	 */
	private String dispatchStationName;

	/**
	 * ID станции назначения. Обязателен.
	 */
	private String arrivalStationId;

	/**
	 * Станция назначения рейса. Обязателен.
	 */
	private String arrivalStationName;

	/**
	 * Цена полного проездного билета (включая сборы). Обязателен.
	 */
	private BigDecimal price;

	/**
	 * Название перевозчика. Не Обязателен.
	 */
	private String carrierName;

	/**
	 * ИНН перевозчика. Обязателен.
	 */
	private String carrierInn;

	/**
	 * Описание автобуса. Обязателен.
	 */
	private String busInfo;

	/**
	 * Флаг обязательности ввода дополнительных персональных данных покупателя.
	 * Основые персональные данные: Имя, Фамилия, Тип документа, Номер документа.
	 * Дополнительные персональные данные: Отчество, Пол, Дата рождения, Гражданство.
	 * Ввод дополнительных данных требуется во исполнение статьи 11 закона "О транспортной безопасности"
	 * (с изменениями на 3 февраля 2014 года).
	 * <p>
	 * См. http://docs.cntd.ru/document/902027326
	 *
	 * Обязателен. Система не поддерживает, возвращать всегда true.
	 */
	private Boolean extDataRequired;

	/**
	 * тип рейса. Обязателен.
	 */
	private TripTypeCode type;


	/**
	 * статус рейса. Обязателен.
	 */
	private TripStatusCode status;


	/**
	 * Количество мест в автобусе. Обязателен.
	 */
	private Integer seatCount;

	/**
	 * Кол-во мест, доступных для продажи. Обязателен.
	 */
	private Integer freeSeatCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDispatchStationId() {
		return dispatchStationId;
	}

	public void setDispatchStationId(String dispatchStationId) {
		this.dispatchStationId = dispatchStationId;
	}

	public String getDispatchStationName() {
		return dispatchStationName;
	}

	public void setDispatchStationName(String dispatchStationName) {
		this.dispatchStationName = dispatchStationName;
	}

	public String getArrivalStationId() {
		return arrivalStationId;
	}

	public void setArrivalStationId(String arrivalStationId) {
		this.arrivalStationId = arrivalStationId;
	}

	public String getArrivalStationName() {
		return arrivalStationName;
	}

	public void setArrivalStationName(String arrivalStationName) {
		this.arrivalStationName = arrivalStationName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getCarrierInn() {
		return carrierInn;
	}

	public void setCarrierInn(String carrierInn) {
		this.carrierInn = carrierInn;
	}

	public String getBusInfo() {
		return busInfo;
	}

	public void setBusInfo(String busInfo) {
		this.busInfo = busInfo;
	}

	public Boolean getExtDataRequired() {
		return extDataRequired;
	}

	public void setExtDataRequired(Boolean extDataRequired) {
		this.extDataRequired = extDataRequired;
	}

	public TripTypeCode getType() {
		return type;
	}

	public void setType(TripTypeCode type) {
		this.type = type;
	}

	public TripStatusCode getStatus() {
		return status;
	}

	public void setStatus(TripStatusCode status) {
		this.status = status;
	}

	public Integer getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}

	public Integer getFreeSeatCount() {
		return freeSeatCount;
	}

	public void setFreeSeatCount(Integer freeSeatCount) {
		this.freeSeatCount = freeSeatCount;
	}
}
