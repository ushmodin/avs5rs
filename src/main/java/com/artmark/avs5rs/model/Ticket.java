package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 12:38
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ticket")
public class Ticket {
	/**
	 * Идентификатор квитанции билета. Обязателен.
	 */
	protected String id;

	/**
	 * Серия билета. Не Обязателен.
	 */
	protected String series;

	/**
	 * Номер билета. Обязателен.
	 */
	protected String number;

	/**
	 * Дата и время продажи билета. Обязателен.
	 */
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	protected Date created;

	/**
	 * Дата и время возврата билета. Заполняется после возврата или отмены билета.
	 */
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	protected Date returned;

	/**
	 * ID статуса билета. Обязателен
	 */
	protected TicketStatusCode status;

	/**
	 * класс билета. Обязателен.
	 */
	protected TicketClassCode ticketClass;

	/**
	 * ID типа билета. Обязателен.
	 */
	protected String typeId;

	/**
	 * Номер маршрута. Не Обязателен.
	 */
	protected String routeNum;

	/**
	 * Название маршрута. Обязателен.
	 */
	protected String routeName;

	/**
	 * Описание рейса. Не Обязателен.
	 */
	protected String description;

	/**
	 * Описание автобуса. Обязателен.
	 */
	protected String busInfo;

	/**
	 * Перевозчик. Обязателен.
	 */
	protected String carrierName;

	/**
	 * ИНН перевозчика. Обязателен.
	 */
	protected String carrierInn;

	/**
	 * Платформа. Не Обязателен.
	 */
	protected String platform;

	/**
	 * Дата отправления рейса. Обязателен.
	 */
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	protected Date dispatchDate;

	/**
	 * Станция отправления. Обязателен.
	 */
	protected String dispatchStation;

	/**
	 * Адрес отправления. Не Обязателен.
	 */
	protected String dispatchAddress;

	/**
	 * Дата и время прибытия на станцию. Обязателен.
	 */
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	protected Date arrivalDate;

	/**
	 * Станция назначения. Обязателен.
	 */
	protected String arrivalStation;

	/**
	 * Адрес станции прибытия. Не Обязателен.
	 */
	protected String arrivalAddress;

	/**
	 * Место. Обязателен.
	 */
	protected String seatName;


	/**
	 * Информация о пассажире. Обязателен.
	 */
	@XmlElement(name = "Passenger")
	protected Passenger passenger;

	/**
	 * Тариф (руб). Обязателен.
	 */
	protected BigDecimal fare;

	/**
	 * Cборы (руб). Обязателен. Если нет то 0.
	 */
	protected BigDecimal fees;

	/**
	 * Удержано Тариф (руб). Заполняется в случает возврата или отмены.
	 */
	protected BigDecimal chargeFare;

	/**
	 * Удержано Остальные сборы (руб). Заполняется в случает возврата или отмены.
	 */
	protected BigDecimal chargeOthers;

	/**
	 * Возврат Тариф (руб). Заполняется в случает возврата или отмены.
	 */
	protected BigDecimal repaymentFare;

	/**
	 * Возврат Остальные сборы (руб). Заполняется в случает возврата или отмены.
	 */
	protected BigDecimal repaymentOthers;

	/**
	 * Информация о страховании. Обязательно. Неоходим при печати билета.
	 */
	protected String insuranceInfo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getReturned() {
		return returned;
	}

	public void setReturned(Date returned) {
		this.returned = returned;
	}

	public TicketStatusCode getStatus() {
		return status;
	}

	public void setStatus(TicketStatusCode status) {
		this.status = status;
	}

	public TicketClassCode getTicketClass() {
		return ticketClass;
	}

	public void setTicketClass(TicketClassCode ticketClass) {
		this.ticketClass = ticketClass;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getRouteNum() {
		return routeNum;
	}

	public void setRouteNum(String routeNum) {
		this.routeNum = routeNum;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBusInfo() {
		return busInfo;
	}

	public void setBusInfo(String busInfo) {
		this.busInfo = busInfo;
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

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Date getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public String getDispatchStation() {
		return dispatchStation;
	}

	public void setDispatchStation(String dispatchStation) {
		this.dispatchStation = dispatchStation;
	}

	public String getDispatchAddress() {
		return dispatchAddress;
	}

	public void setDispatchAddress(String dispatchAddress) {
		this.dispatchAddress = dispatchAddress;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public String getArrivalAddress() {
		return arrivalAddress;
	}

	public void setArrivalAddress(String arrivalAddress) {
		this.arrivalAddress = arrivalAddress;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public BigDecimal getFare() {
		return fare;
	}

	public void setFare(BigDecimal fare) {
		this.fare = fare;
	}

	public BigDecimal getFees() {
		return fees;
	}

	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}

	public BigDecimal getChargeFare() {
		return chargeFare;
	}

	public void setChargeFare(BigDecimal chargeFare) {
		this.chargeFare = chargeFare;
	}

	public BigDecimal getChargeOthers() {
		return chargeOthers;
	}

	public void setChargeOthers(BigDecimal chargeOthers) {
		this.chargeOthers = chargeOthers;
	}

	public BigDecimal getRepaymentFare() {
		return repaymentFare;
	}

	public void setRepaymentFare(BigDecimal repaymentFare) {
		this.repaymentFare = repaymentFare;
	}

	public BigDecimal getRepaymentOthers() {
		return repaymentOthers;
	}

	public void setRepaymentOthers(BigDecimal repaymentOthers) {
		this.repaymentOthers = repaymentOthers;
	}

	public String getInsuranceInfo() {
		return insuranceInfo;
	}

	public void setInsuranceInfo(String insuranceInfo) {
		this.insuranceInfo = insuranceInfo;
	}
}
