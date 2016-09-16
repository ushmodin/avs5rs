package com.artmark.avs5rs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 11:34
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TicketType")
public class TicketType {
	/**
	 * Идентификатор типа билета. Обязателен. Может совпадать с названием.
	 */
	private String id;
	/**
	 * Название типа билета. Обязателен.
	 */
	private String name;
	/**
	 * Цена для заданного типа билета (со сборами).
	 */
	private BigDecimal price;
	/**
	 * Класс билета
	 */
	private TicketClassCode ticketClass;


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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public TicketClassCode getTicketClass() {
		return ticketClass;
	}

	public void setTicketClass(TicketClassCode ticketClass) {
		this.ticketClass = ticketClass;
	}
}
