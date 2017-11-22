
package com.artmark.avs5rs.transit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RouteKey complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RouteKey">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dispatchStationUid" type="{}UidType"/>
 *         &lt;element name="arrivalStationUid" type="{}UidType"/>
 *         &lt;element name="dispatchTime" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteKey", propOrder = {
    "dispatchStationUid",
    "arrivalStationUid",
    "dispatchTime"
})
public class RouteKey {

    @XmlElement(required = true)
    protected String dispatchStationUid;
    @XmlElement(required = true)
    protected String arrivalStationUid;
    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar dispatchTime;

    /**
     * Gets the value of the dispatchStationUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispatchStationUid() {
        return dispatchStationUid;
    }

    /**
     * Sets the value of the dispatchStationUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispatchStationUid(String value) {
        this.dispatchStationUid = value;
    }

    /**
     * Gets the value of the arrivalStationUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalStationUid() {
        return arrivalStationUid;
    }

    /**
     * Sets the value of the arrivalStationUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalStationUid(String value) {
        this.arrivalStationUid = value;
    }

    /**
     * Gets the value of the dispatchTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDispatchTime() {
        return dispatchTime;
    }

    /**
     * Sets the value of the dispatchTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDispatchTime(XMLGregorianCalendar value) {
        this.dispatchTime = value;
    }

}
