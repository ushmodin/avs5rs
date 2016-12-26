package com.artmark.avs5rs.model;

/**
 * @author Ushmodin N.
 * @since 07.07.2016 12:23
 */
public enum TripTypeCode {
    /**
     * Типа рейса - Междугородный
     */
    @Deprecated
    INTERURBAN,

    /**
     * Типа рейса - Пригородный
     */
    @Deprecated
    SUBURBAN,

    /**
     * Типа рейса - Внутриобластной
     */
    @Deprecated
    INTRAREGIONAL,


    /**
     * Типа рейса - Межреспубликанский
     */
    @Deprecated
    INTERREPUBLICAN,

    /**
     * Типа рейса - Внутрирайонный
     */
    @Deprecated
    INTRADISTRICT,

    /**
     * Международный
     */
    INTERNATIONAL,
    /**
     * Межрегиональный
     */
    INTERREGIONAL,
    /**
     * Смежный межрегиональный.
     */
    ADJACENT_INTERREGIONAL,
    /**
     * Межмуниципальный.
     */
    INTERMUNICIPAL,
    /**
     * Муниципальный.
     */
    MUNICIPAL,
}
