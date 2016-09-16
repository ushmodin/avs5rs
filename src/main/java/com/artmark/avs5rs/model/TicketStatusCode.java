package com.artmark.avs5rs.model;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 12:45
 */

public enum TicketStatusCode {
	/**
	 * Забронирован. Данный статус билет получает после бронирования. bookOrder
	 */
	RESERVED,

	/**
	 * Продан. Данный статус билет получает после операции продажи. confirmOrder
	 */
	SOLD,


	/**
	 * Отмена билета. Данный статус билет получает после отмены билета. cancelTicket
	 */
	CANCELED,

	/**
	 * Выполнен возврат билета. Данный статус билет получает после возрата билета. returnTicket
	 */
	RETURNED
}
