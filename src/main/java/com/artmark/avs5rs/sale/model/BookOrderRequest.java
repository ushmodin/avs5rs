
package com.artmark.avs5rs.sale.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tripId" type="{}IDType"/>
 *         &lt;element name="dispatchStationId" type="{}IDType"/>
 *         &lt;element name="arrivalStationId" type="{}IDType"/>
 *         &lt;element name="Sale" type="{}Sale" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Agent" type="{}Agent" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tripId",
    "dispatchStationId",
    "arrivalStationId",
    "sale",
    "agent"
})
@XmlRootElement(name = "BookOrderRequest")
public class BookOrderRequest {

    @XmlElement(required = true)
    protected String tripId;
    @XmlElement(required = true)
    protected String dispatchStationId;
    @XmlElement(required = true)
    protected String arrivalStationId;
    @XmlElement(name = "Sale")
    protected List<Sale> sale;
    @XmlElement(name = "Agent")
    protected Agent agent;

    /**
     * Gets the value of the tripId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripId() {
        return tripId;
    }

    /**
     * Sets the value of the tripId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripId(String value) {
        this.tripId = value;
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
     * Gets the value of the sale property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sale property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSale().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Sale }
     * 
     * 
     */
    public List<Sale> getSale() {
        if (sale == null) {
            sale = new ArrayList<Sale>();
        }
        return this.sale;
    }

    /**
     * Gets the value of the agent property.
     * 
     * @return
     *     possible object is
     *     {@link Agent }
     *     
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * Sets the value of the agent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Agent }
     *     
     */
    public void setAgent(Agent value) {
        this.agent = value;
    }

}
