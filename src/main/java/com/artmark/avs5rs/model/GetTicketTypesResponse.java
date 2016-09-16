package com.artmark.avs5rs.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 10:58
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTicketTypesResponse")
public class GetTicketTypesResponse {
	@XmlElement(name = "TicketType")
	private List<TicketType> ticketTypes;

	public List<TicketType> getTicketTypes() {
		return ticketTypes;
	}

	public void setTicketTypes(List<TicketType> ticketTypes) {
		this.ticketTypes = ticketTypes;
	}
}
