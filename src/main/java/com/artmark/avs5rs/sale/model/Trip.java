
package com.artmark.avs5rs.sale.model;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Trip complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Trip">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{}IDType"/>
 *         &lt;element name="name" type="{}NameType"/>
 *         &lt;element name="num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dispatchDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="arrivalDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="dispatchStationId" type="{}IDType"/>
 *         &lt;element name="dispatchStationName" type="{}NameType"/>
 *         &lt;element name="arrivalStationId" type="{}IDType"/>
 *         &lt;element name="arrivalStationName" type="{}NameType"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="carrierName" type="{}NameType" minOccurs="0"/>
 *         &lt;element name="carrierInn" type="{}InnType"/>
 *         &lt;element name="busInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="platform" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{}TripType"/>
 *         &lt;element name="status" type="{}TripStatus"/>
 *         &lt;element name="tripClass" type="{}TripClass" minOccurs="0"/>
 *         &lt;element name="seatCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="freeSeatCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="routeKey" type="{}RouteKey" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Trip", propOrder = {
    "id",
    "name",
    "num",
    "dispatchDate",
    "arrivalDate",
    "dispatchStationId",
    "dispatchStationName",
    "arrivalStationId",
    "arrivalStationName",
    "price",
    "carrierName",
    "carrierInn",
    "busInfo",
    "platform",
    "type",
    "status",
    "tripClass",
    "seatCount",
    "freeSeatCount",
    "routeKey"
})
public class Trip {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String name;
    protected String num;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dispatchDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar arrivalDate;
    @XmlElement(required = true)
    protected String dispatchStationId;
    @XmlElement(required = true)
    protected String dispatchStationName;
    @XmlElement(required = true)
    protected String arrivalStationId;
    @XmlElement(required = true)
    protected String arrivalStationName;
    @XmlElement(required = true)
    protected BigDecimal price;
    protected String carrierName;
    @XmlElement(required = true)
    protected String carrierInn;
    @XmlElement(required = true)
    protected String busInfo;
    protected String platform;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TripType type;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TripStatus status;
    @XmlSchemaType(name = "string")
    protected TripClass tripClass;
    protected int seatCount;
    protected int freeSeatCount;
    protected RouteKey routeKey;

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the num property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNum() {
        return num;
    }

    /**
     * Sets the value of the num property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNum(String value) {
        this.num = value;
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
     * Gets the value of the dispatchStationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispatchStationId() {
        return dispatchStationId;
    }

    /**
     * Sets the value of the dispatchStationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispatchStationId(String value) {
        this.dispatchStationId = value;
    }

    /**
     * Gets the value of the dispatchStationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispatchStationName() {
        return dispatchStationName;
    }

    /**
     * Sets the value of the dispatchStationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispatchStationName(String value) {
        this.dispatchStationName = value;
    }

    /**
     * Gets the value of the arrivalStationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalStationId() {
        return arrivalStationId;
    }

    /**
     * Sets the value of the arrivalStationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalStationId(String value) {
        this.arrivalStationId = value;
    }

    /**
     * Gets the value of the arrivalStationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalStationName() {
        return arrivalStationName;
    }

    /**
     * Sets the value of the arrivalStationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalStationName(String value) {
        this.arrivalStationName = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TripType }
     *     
     */
    public TripType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TripType }
     *     
     */
    public void setType(TripType value) {
        this.type = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link TripStatus }
     *     
     */
    public TripStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link TripStatus }
     *     
     */
    public void setStatus(TripStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the tripClass property.
     * 
     * @return
     *     possible object is
     *     {@link TripClass }
     *     
     */
    public TripClass getTripClass() {
        return tripClass;
    }

    /**
     * Sets the value of the tripClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link TripClass }
     *     
     */
    public void setTripClass(TripClass value) {
        this.tripClass = value;
    }

    /**
     * Gets the value of the seatCount property.
     * 
     */
    public int getSeatCount() {
        return seatCount;
    }

    /**
     * Sets the value of the seatCount property.
     * 
     */
    public void setSeatCount(int value) {
        this.seatCount = value;
    }

    /**
     * Gets the value of the freeSeatCount property.
     * 
     */
    public int getFreeSeatCount() {
        return freeSeatCount;
    }

    /**
     * Sets the value of the freeSeatCount property.
     * 
     */
    public void setFreeSeatCount(int value) {
        this.freeSeatCount = value;
    }

    /**
     * Gets the value of the routeKey property.
     * 
     * @return
     *     possible object is
     *     {@link RouteKey }
     *     
     */
    public RouteKey getRouteKey() {
        return routeKey;
    }

    /**
     * Sets the value of the routeKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteKey }
     *     
     */
    public void setRouteKey(RouteKey value) {
        this.routeKey = value;
    }

}
