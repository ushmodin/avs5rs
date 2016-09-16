package com.artmark.avs5rs.model;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 12:24
 */

public enum TripStatusCode {
	/**
	 * В продаже. На рейса доступны все опрерации.
	 */
	ON_SALE,
	/**
	 * Приостановка остановка продажи. Рейс не доступен для продажи.
	 */
	SUSPENDED,
	/**
	 * Рейс отменен. Рейс не доступен для продажи.
	 */
	CANCELED,
	/**
	 * Неопределенный статус. Рейс не доступен для продажи.
	 */
	UNKNOWN
}
