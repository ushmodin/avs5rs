
package com.artmark.avs5rs.sale.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TripType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TripType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INTERNATIONAL"/>
 *     &lt;enumeration value="INTERREGIONAL"/>
 *     &lt;enumeration value="ADJACENT_INTERREGIONAL"/>
 *     &lt;enumeration value="INTERMUNICIPAL"/>
 *     &lt;enumeration value="MUNICIPAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TripType")
@XmlEnum
public enum TripType {

    INTERNATIONAL,
    INTERREGIONAL,
    ADJACENT_INTERREGIONAL,
    INTERMUNICIPAL,
    MUNICIPAL;

    public String value() {
        return name();
    }

    public static TripType fromValue(String v) {
        return valueOf(v);
    }

}
