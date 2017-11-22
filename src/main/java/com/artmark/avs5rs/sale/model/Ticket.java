
package com.artmark.avs5rs.sale.model;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Ticket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ticket">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{}IDType"/>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="series" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="returned" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="status" type="{}TicketStatus"/>
 *         &lt;element name="ticketClass" type="{}TicketClass"/>
 *         &lt;element name="typeId" type="{}IDType"/>
 *         &lt;element name="routeNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeName" type="{}NameType"/>
 *         &lt;element name="busInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="carrierName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="carrierInn" type="{}InnType"/>
 *         &lt;element name="platform" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dispatchDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="arrivalDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="dispatchStation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="arrivalStation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="seatNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Passenger" type="{}Passenger" minOccurs="0"/>
 *         &lt;element name="fare" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="fees" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="repayment" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="insuranceInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ticket", propOrder = {
    "id",
    "number",
    "series",
    "created",
    "returned",
    "status",
    "ticketClass",
    "typeId",
    "routeNum",
    "routeName",
    "busInfo",
    "carrierName",
    "carrierInn",
    "platform",
    "dispatchDate",
    "arrivalDate",
    "dispatchStation",
    "arrivalStation",
    "seatNum",
    "passenger",
    "fare",
    "fees",
    "repayment",
    "insuranceInfo"
})
public class Ticket {

    @XmlElement(required = true)
    protected String id;
    protected String number;
    protected String series;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar returned;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TicketStatus status;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TicketClass ticketClass;
    @XmlElement(required = true)
    protected String typeId;
    protected String routeNum;
    @XmlElement(required = true)
    protected String routeName;
    @XmlElement(required = true)
    protected String busInfo;
    protected String carrierName;
    @XmlElement(required = true)
    protected String carrierInn;
    protected String platform;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dispatchDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar arrivalDate;
    @XmlElement(required = true)
    protected String dispatchStation;
    @XmlElement(required = true)
    protected String arrivalStation;
    protected int seatNum;
    @XmlElement(name = "Passenger")
    protected Passenger passenger;
    @XmlElement(required = true)
    protected BigDecimal fare;
    @XmlElement(required = true)
    protected BigDecimal fees;
    protected BigDecimal repayment;
    @XmlElement(required = true)
    protected String insuranceInfo;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the series property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeries() {
        return series;
    }

    /**
     * Sets the value of the series property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeries(String value) {
        this.series = value;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreated(XMLGregorianCalendar value) {
        this.created = value;
    }

    /**
     * Gets the value of the returned property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReturned() {
        return returned;
    }

    /**
     * Sets the value of the returned property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReturned(XMLGregorianCalendar value) {
        this.returned = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link TicketStatus }
     *     
     */
    public TicketStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link TicketStatus }
     *     
     */
    public void setStatus(TicketStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the ticketClass property.
     * 
     * @return
     *     possible object is
     *     {@link TicketClass }
     *     
     */
    public TicketClass getTicketClass() {
        return ticketClass;
    }

    /**
     * Sets the value of the ticketClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link TicketClass }
     *     
     */
    public void setTicketClass(TicketClass value) {
        this.ticketClass = value;
    }

    /**
     * Gets the value of the typeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * Sets the value of the typeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeId(String value) {
        this.typeId = value;
    }

    /**
     * Gets the value of the routeNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRouteNum() {
        return routeNum;
    }

    /**
     * Sets the value of the routeNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRouteNum(String value) {
        this.routeNum = value;
    }

    /**
     * Gets the value of the routeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * Sets the value of the routeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRouteName(String value) {
        this.routeName = value;
    }

    /**
     * Gets the value of the busInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusInfo() {
        return busInfo;
    }

    /**
     * Sets the value of the busInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusInfo(String value) {
        this.busInfo = value;
    }

    /**
     * Gets the value of the carrierName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrierName() {
        return carrierName;
    }

    /**
     * Sets the value of the carrierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrierName(String value) {
        this.carrierName = value;
    }

    /**
     * Gets the value of the carrierInn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrierInn() {
        return carrierInn;
    }

    /**
     * Sets the value of the carrierInn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrierInn(String value) {
        this.carrierInn = value;
    }

    /**
     * Gets the value of the platform property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the value of the platform property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatform(String value) {
        this.platform = value;
    }

    /**
     * Gets the value of the dispatchDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDispatchDate() {
        return dispatchDate;
    }

    /**
     * Sets the value of the dispatchDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDispatchDate(XMLGregorianCalendar value) {
        this.dispatchDate = value;
    }

    /**
     * Gets the value of the arrivalDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the value of the arrivalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArrivalDate(XMLGregorianCalendar value) {
        this.arrivalDate = value;
    }

    /**
     * Gets the value of the dispatchStation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispatchStation() {
        return dispatchStation;
    }

    /**
     * Sets the value of the dispatchStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispatchStation(String value) {
        this.dispatchStation = value;
    }

    /**
     * Gets the value of the arrivalStation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalStation() {
        return arrivalStation;
    }

    /**
     * Sets the value of the arrivalStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalStation(String value) {
        this.arrivalStation = value;
    }

    /**
     * Gets the value of the seatNum property.
     * 
     */
    public int getSeatNum() {
        return seatNum;
    }

    /**
     * Sets the value of the seatNum property.
     * 
     */
    public void setSeatNum(int value) {
        this.seatNum = value;
    }

    /**
     * Gets the value of the passenger property.
     * 
     * @return
     *     possible object is
     *     {@link Passenger }
     *     
     */
    public Passenger getPassenger() {
        return passenger;
    }

    /**
     * Sets the value of the passenger property.
     * 
     * @param value
     *     allowed object is
     *     {@link Passenger }
     *     
     */
    public void setPassenger(Passenger value) {
        this.passenger = value;
    }

    /**
     * Gets the value of the fare property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFare() {
        return fare;
    }

    /**
     * Sets the value of the fare property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFare(BigDecimal value) {
        this.fare = value;
    }

    /**
     * Gets the value of the fees property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFees() {
        return fees;
    }

    /**
     * Sets the value of the fees property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFees(BigDecimal value) {
        this.fees = value;
    }

    /**
     * Gets the value of the repayment property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRepayment() {
        return repayment;
    }

    /**
     * Sets the value of the repayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRepayment(BigDecimal value) {
        this.repayment = value;
    }

    /**
     * Gets the value of the insuranceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuranceInfo() {
        return insuranceInfo;
    }

    /**
     * Sets the value of the insuranceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuranceInfo(String value) {
        this.insuranceInfo = value;
    }

}
