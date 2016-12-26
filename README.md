Спецификация на протокол AVS5RS продажи билетов для автотранспорта
==================================================================

**Версия документа: 1.4**

**Дата изменения: 26.12.2016**

Введение
========

Данный документ содержит спецификацию протокола AVS5RS, предназначенного
для организации удаленной продажи билетов на автотранспорте.
Спецификация предназначена для унификации процесса обмена данными между
перевозчиками, автовокзалами и агентами по продаже билетов.

Описание протокола
==================

Общие сведения
--------------

Обмен данными в протоколе AVS5RS производится через протокол HTTP.
Передача и прием данных производится в формате XML, с использованием
кодировки UTF-8.

Все запросы оправляются методом POST. Каждый метод протокола реализуется
через отдельный URL, который строится относительно базового адреса
сервиса, далее обозначаемого как \[BASE\_URL\].

Ответы с сервера должны поступать по протоколу HTTP c кодом 200 и
HTTP-заголовком “Content-Type”, имеющим значение “application/xml; charset=UTF-8”.

Доступ к веб-сервису, реализующему протокол AVS5RS, должен быть закрыт с
применением Basic-аутентификации. Допускается использование протокола
HTTPS, контроля доступа по IP, передача данных через VPN-соединение.

Форматы данных
--------------

Тело XML- ответа должно начинаться с объявления
`<?xml version="1.0" encoding="UTF-8"?>`. Регистр
названий тегов и атрибутов должен совпадать с регистром из примеров.

XML-ответ сервиса, реализующего протокол в обязательном порядке имеет
корневой тег `<Response>` с атрибутом success, который указывает на
результат выполнения запроса: true - корректно, false - нет. Если ответ
корректный, то данные ответа содержатся во вложенном теге &lt;Body&gt;.
Если ответ не корректный, информация об ошибке должна находиться во
вложенном теге &lt;Error&gt;, который состоит из кода ошибки в теге
&lt;code&gt; и описания ошибки в теге &lt;message&gt;. Коды ошибок не
регламентируются. Описание - это произвольные текст на русском языке,
поясняющий причину ошибки.

Формат даты: `yyyy-MM-dd`, формат даты и времени:
`yyyy-MM-dd'T'HH:mm:ss`. Пример:
2016-09-07T13:10:00 (символ T латинский, обязательный) (секунды
обязательны). Время указано в часовом поясе сервера который
предоставляет контент. Все идентификаторы сущностей (id) это строки,
произвольного формата, длинной до 36 символов.

Пример ответа в случае успешной обработки запроса:

```xml
 <?xml version="1.0" encoding="UTF-8"?>
 <Response success="true">
    <Body>
        <message>Test</message>
    </Body>
 </Response>
```

Пример ответа в случае обработки запроса с ошибкой:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Response success="false">
    <Error>
        <code>ERROR</code>
        <message>Место 5 занято</message>
    </Error>
</Response>
```

Методы протокола
----------------

### echo

Используется для проверки доступности сервиса.

Метод принимает в параметре произвольную строку и возвращает её в теле
ответа.

**URL: \[BASE\_URL\]/sales/echo**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<EchoRequest>
    <!-- Сообщение которое будет возвращено в ответ. Обязательно. -->
    <message>Test</message>
</EchoRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Response success="true">
    <Body>
        <!-- Сообщение переданное в запросе -->
        <message>Test</message>
    </Body>
</Response>
```

### getDispatchStations

Метод получения станций отправления. Продажа происходит от станции
отправления до станции назначения, поэтому метод должен вернуть хотя бы
один элемент. Обычно станциями отправления являются автовокзалы или
автоматизированные остановочные пункты с функцией продажи билетов.

**URL: \[BASE\_URL\]/sales/getDispatchStations**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<GetDispatchStationsRequest>
</GetDispatchStationsRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Response success="true">
    <Body>
        <!-- Станция -->
        <Station>
            <!-- Идентификатор станции. Обязателен. -->
            <id>983</id>
            <!-- Наименование станции. Обязателен. Используется для отображения в интерфейсе пользователя -->
            <name>ВДНХ АС</name>
            <!-- Название региона станции. Не обязателен. Используется для отображения в интерфейсе пользователя -->
            <region>Москва</region>
            <!-- ОКАТО станции. Не обязателен. Используется для поиска одинаковых станций и отображения в интерфейсе пользователя -->
            <okato>45000000000</okato>
        </Station>
        <Station>
            <id>853</id>
            <name>Варшавская АС</name>
            <region>Москва</region>
            <okato>45000000000</okato>
        </Station>
        <Station>
            <id>6</id>
            <name>Красногвардейская АС</name>
            <region>Москва</region>
            <okato>45000000000</okato>
        </Station>
    </Body>
</Response>
```

### getArrivalStations

Метод получения станций назначения от станции отправления. В параметре
принимает идентификатор станции отправления. Станциями назначения могут
быть любые остановочные пункты до которых есть хотя бы один рейс. Если
станций назначения нет, метод должен вернуть пустой список.

**URL: \[BASE\_URL\]/sales/getArrivalStations**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<GetArrivalStationsRequest>
    <!-- Идентификатор станции отправления. Обязательно. -->
    <dispatchStationId>983</dispatchStationId>
</GetArrivalStationsRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Response success="true">
    <Body>
        <Station>
            <id>1069</id>
            <name>Рыбинск</name>
            <region>Ярославская область</region>
            <okato>78415000000</okato>
        </Station>
        <Station>
            <id>1018</id>
            <name>Сергиев Посад</name>
            <region>Московская область</region>
            <okato>46215501000</okato>
        </Station>
        <Station>
            <id>1084</id>
            <name>Углич</name>
            <region>Ярославская область</region>
            <okato>78420000000</okato>
        </Station>
        <Station>
            <id>1078</id>
            <name>Утена</name>
            <region>Литва</region>
        </Station>
    </Body>
</Response>
```

### searchTrips

Метод возвращает список рейсов от станции отправления до станции
назначения на заданную дату. В параметрах передается идентификатор
станции отправления, идентификатор станции назначения и дата.

**URL: \[BASE\_URL\]/sales/searchTrips**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<SearchTripsRequest>
    <!-- Идентификатор станции отправления. Обязательно.-->
    <dispatchStationId>983</dispatchStationId>
    <!-- Идентификатор станции назначения. Обязательно. -->
    <arrivalStationId>678</arrivalStationId>
    <!-- Дата на которую выполняется поиск рейса. Обязательно. -->
    <date>2016-07-12</date>
</SearchTripsRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Response success="true">
    <Body>
         <!-- Рейс-->
        <Trip>
            <!-- Идентификатор рейса. Обязательно. -->
            <id>570104</id>
            <!-- Номер маршрута. Не обязателен. -->
            <num>000</num>
            <!-- Название маршрута. Обязателен. -->
            <name>ВДНХ АС - Пенза</name>
            <!-- Дата и время отправления. Обязателен. -->
            <dispatchDate>2016-07-13T19:30:00</dispatchDate>
            <!-- Дата и время прибытия. Обязателен. -->
            <arrivalDate>2016-07-14T05:30:00</arrivalDate>
            <!-- ID станции отправления. Обязателен. -->
            <dispatchStationId>983</dispatchStationId>
            <!-- Станция отправления рейса. Обязателен. -->
            <dispatchStationName>ВДНХ АС</dispatchStationName>
            <!-- ID станции назначения. Обязателен. -->
            <arrivalStationId>744</arrivalStationId>
            <!-- Станция назначения рейса. Обязателен. -->
            <arrivalStationName>Пенза</arrivalStationName>
            <!-- Цена полного проездного билета (включая сборы). Обязателен. -->
            <price>1391</price>
            <!-- Название перевозчика. Не Обязателен. -->
            <carrierName>ИП Ерашова Валентина Анатольевна</carrierName>
            <!-- ИНН перевозчика. Обязателен. -->
            <carrierInn>ИНН 582700056092</carrierInn>
            <!-- Описание автобуса. Обязателен. -->
            <busInfo>49 Мест Категория ТС &quot;М3&quot;  </busInfo>
            <!-- 
            тип рейса. Обязателен. см. ФЗ-220

            INTERNATIONAL           - Международный
            INTERREGIONAL           - Межрегиональный.
            ADJACENT_INTERREGIONAL  - Смежный межрегиональный.
            INTERMUNICIPAL          - Межмуниципальный.
            MUNICIPAL               - Муниципальный.
            -->
            <type>INTERREGIONAL</type>
            <!--
            Статус рейса. Обязателен.
            ON_SALE - В продаже. Можно продавать билеты на этот рейс,
            SUSPENDED - Приостановка продажи. Продажа запрещена.
            CANCELED - Рейс отменен. Продажа запрещена.
            DISPATCHED - Рейс отправлен. Продажа запрещена.
            UNKNOWN - Неопределенный статус. Рейс не доступен для продажи.
            -->
            <status>ON_SALE</status>
            <!--
            Класс рейса. Не обязателен. По умолчанию - регулярный
            REGULAR - Регулярный рейс
            CUSTOM  - Заказной рейс
            -->
            <class>REGULAR</class>
            <!-- Количество мест в автобусе. Обязателен. -->
            <seatCount>49</seatCount>
            <!-- Кол-во мест, доступных для продажи. Обязателен.-->
            <freeSeatCount>49</freeSeatCount>
        </Trip>
        <Trip>
            <id>570105</id>
            <num>000</num>
            <name>ВДНХ АС - Пенза</name>
            <dispatchDate>2016-07-13T21:30:00</dispatchDate>
            <arrivalDate>2016-07-14T07:30:00</arrivalDate>
            <dispatchStationId>983</dispatchStationId>
            <dispatchStationName>ВДНХ АС</dispatchStationName>
            <arrivalStationId>744</arrivalStationId>
            <arrivalStationName>Пенза</arrivalStationName>
            <price>1391</price>
            <carrierName>ИП Ерашова Валентина Анатольевна</carrierName>
            <carrierInn>ИНН 582700056092</carrierInn>
            <busInfo>49 Мест Категория ТС &quot;М3&quot;  </busInfo>
            <type>INTERREGIONAL</type>
            <status>ON_SALE</status>
            <seatCount>49</seatCount>
            <freeSeatCount>49</freeSeatCount>
        </Trip>
    </Body>
</Response>
```

### getFreeSeats

Получение списка свободных мест для рейса. В параметре принимает
идентификатор рейса, идентификатор станции отправления и идентификатор
станции назначения.

**URL: \[BASE\_URL\]/sales/getFreeSeats**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<GetFreeSeatsRequest>
    <!-- Идентификатор рейса. Обязательный. -->
    <tripId>570101</tripId>
    <!-- Идентификатор станции отправления. Обязательный. -->
    <dispatchStationId>983</dispatchStationId>
    <!-- Идентификатор станции назначения. Обязательный. -->
    <arrivalStationId>1080</arrivalStationId>   
</GetFreeSeatsRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Response success="true">
    <Body>
        <!-- Место-->
        <Seat>
            <!-- Идентификатор места. Обязателен. Может совпадать с названием.-->
            <id>17926</id>
            <!-- Название места. Обязателен. Отображается в интерфейсе пользователя. -->
            <name>Место 1</name>
            <!-- Тип места. Не обязателен -->
            <type>Сидячее</type>
        </Seat>
        <Seat>
            <id>17927</id>
            <name>Место 2</name>
            <type>Сидячее</type>
        </Seat>
        <Seat>
            <id>17928</id>
            <name>Место 3</name>
            <type>Сидячее</type>
        </Seat>
    </Body>
</Response>
```

### getTicketTypes

Получение списка типов билетов, доступных для продажи. В параметре
принимает идентификатор рейса, идентификатор станции отправления и
идентификатор станции назначения.

**URL: \[BASE\_URL\]/sales/getTicketTypes**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<GetTicketTypesRequest>
    <!-- Идентификатор рейса. Обязательный. -->
    <tripId>570101</tripId>
    <!-- Идентификатор станции отправления. Обязательный. -->
    <dispatchStationId>983</dispatchStationId>
    <!-- Идентификатор станции назначения. Обязательный. -->
    <arrivalStationId>1080</arrivalStationId>
</GetTicketTypesRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Response success="true">
    <Body>
        <TicketType>
            <!-- Идентификатор типа билета. Обязателен. Может совпадать с названием. -->
            <id>1#1#0</id>
            <!-- Название типа билета. Обязателен. -->
            <name>Полный</name>
            <!-- Цена для заданного типа билета (со сборами). Обязателен. -->
            <price>1391</price>
            <!-- 
            Класс билета. Обязателен.
            PASSENGER Пассажирский билет, с выделением места
            BAGGAGE Багажный билет, без выделения места
            -->
            <ticketClass>PASSENGER</ticketClass>
        </TicketType>
        <TicketType>
            <id>38#6#0</id>
            <name>Детский</name>
            <price>696</price>
            <ticketClass>PASSENGER</ticketClass>
        </TicketType>
        <TicketType>
            <id>0#0#0</id>
            <name>Багажный</name>
            <price>40</price>
            <ticketClass>BAGGAGE</ticketClass>
        </TicketType>
    </Body>
</Response>
```

### getDocumentTypes

Получение списка типов документов, допустимых для удостоверения личности
при оформлении билетов через интернет. Система должна предоставить хотя
бы один тип документа. Допустимые идентификаторы и названия документов
перечислены в таблице 1 Приказа Минтранса РФ от 19 июля 2012 г. N 243
"Об утверждении Порядка формирования и ведения автоматизированных
централизованных баз персональных данных о пассажирах и персонале
(экипаже) транспортных средств, а также предоставления содержащихся в
них данных".

Текст документа в системе ГАРАНТ: <http://base.garant.ru/70229008/>

**URL: \[BASE\_URL\]/sales/getDocumentTypes**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<GetDocumentTypesRequest>
    <!-- Идентификатор рейса. Обязательный. -->
    <tripId>570101</tripId>
    <!-- Идентификатор станции отправления. Обязательный. -->
    <dispatchStationId>983</dispatchStationId>
    <!-- Идентификатор станции назначения. Обязательный. -->
    <arrivalStationId>1080</arrivalStationId>
</GetDocumentTypesRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Response success="true">
<Body>
    <DocumentType>
        <!-- ID типа документа. Обязателен. -->
        <id>0</id>
        <!-- Название типа документа. Обязателен. -->
        <name>Паспорт РФ</name>
    </DocumentType>
    <DocumentType>
        <id>3</id>
        <name>Паспорт иностранного гражданина</name>
    </DocumentType>
    <DocumentType>
        <id>4</id>
        <name>Свидетельство о рождении</name>
    </DocumentType>
/Body>
</Response>
```

Таблица 1. Коды документов, удостоверяющих личность, при передаче в АЦБПДП
---------------------------------------------------------------


-------------------------------------------------------------------------
Код   Наименование документа
---   -------------------------------------------------------------------
00    Паспорт гражданина Российской Федерации

01    Паспорт моряка

02    Общегражданский заграничный паспорт гражданина Российской Федерации

03    Паспорт иностранного гражданина

04    Свидетельство о рождении

05    Удостоверение личности военнослужащего

06    Удостоверение личности лица без гражданства

07    Временное удостоверение личности, выдаваемое органами внутренних дел

08    Военный билет военнослужащего срочной службы

09    Вид на жительство иностранного гражданина или лица без гражданства

10    Справка об освобождении из мест лишения свободы

11    Паспорт гражданина СССР

12    Паспорт дипломатический

13    Паспорт служебный (кроме паспорта моряка и дипломатического)

14    Свидетельство о возвращении из стран СНГ

15    Справка об утере паспорта

--------------------------------------------------------------------------

### getTripStops

Метод возвращает список остановочных пунктов для рейса. В параметре
принимает идентификатор рейса. Информация имеет справочный характер.

**URL: \[BASE\_URL\]/sales/getTripStops**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<GetTripStopsRequest>
    <!-- Идентификатор рейса. Обязателен. -->
    <tripId>569839</tripId>
</GetTripStopsRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Response success="true">
    <Body>
        <Stop>
            <!-- ID остановки. Совпадает с ID станции. Обязателен. -->
            <id>1011</id>
            <!-- Название остановки. Совпадает с названием станции. Обязателен. -->
            <name>Скопин (трасса)</name>
            <!-- Район расположения остановки. Не обязателен. -->
            <regionName>Рязанская область</regionName>
            <!-- Дата-время прибытия на остановку. Обязателен. -->
            <arrivalDate>2016-07-14T16:20:00</arrivalDate>
            <!-- Дата-время отправления с остановки. Обязателен. -->
            <dispatchDate>2016-07-13T21:00:00</dispatchDate>
            <!-- Время стоянки в минутах. Не Обязателен. -->
            <stopTime>10</stopTime>
            <!-- Расстояние от пункта отправления до остановки в км. Не Обязателен. -->
            <distance>260</distance>
            <!-- Цена полного билета. Обязателен. -->
            <price>1177</price>
        </Stop>
        <Stop>
            <id>1010</id>
            <name>Мичуринск (трасса)</name>
            <regionName>Тамбовская область</regionName>
            <arrivalDate>2016-07-14T16:20:00</arrivalDate>
            <dispatchDate>2016-07-13T21:00:00</dispatchDate>
            <stopTime>10</stopTime>
            <distance>385</distance>
            <price>1177</price>
        </Stop>
        <Stop>
            <id>818</id>
            <name>Тамбов (трасса)</name>
            <regionName>Тамбовская область</regionName>
            <arrivalDate>2016-07-14T16:20:00</arrivalDate>
            <dispatchDate>2016-07-13T21:00:00</dispatchDate>
            <stopTime>10</stopTime>
            <distance>455</distance>
            <price>1177</price>
        </Stop>
    </Body>
</Response>
```

### bookOrder

Бронирование заказа. Бронь сохраняется в течение ограниченного времени,
от 20 до 60 минут. Если в указанный период времени не поступает
подтверждение оплаты через метод confirmOrder(), то бронирование
автоматически отменяется. Метод должен выполнить все возможные проверки
корректности переданных данных. В случае ошибки заказ не должен быть
создан. Допускается бронирование нескольких билетов в рамках одного
заказа. В параметрах запроса передаются идентификатор рейса,
идентификатор станции отправления, идентификатор станции назначения,
информацию о бронируемых билетах, информацию об агенте совершивший эту
операцию. Информации о бронируемых билетах включает в себя идентификатор
типа билета, идентификатор места и информацию о пассажире. Информация об
агенте включает в себя наименование и ИНН агента.

**URL: \[BASE\_URL\]/sales/bookOrder**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<BookOrderRequest>
     <!-- Идентификатор рейса. Обязательный. -->
    <tripId>570101</tripId>
    <!-- Идентификатор станции отправления. Обязательный. -->
    <dispatchStationId>983</dispatchStationId>
    <!-- Идентификатор станции назначения. Обязательный. -->
    <arrivalStationId>1080</arrivalStationId>
    <!-- Информация о бронируемом билете. Для каждой брони отдельный тег Sale -->
    <Sale>
        <!-- Идентификатор места, полученный из getFreeSeats. Обязателен. -->
        <seatId>25862</seatId>
        <!-- Идентификатор типа билета, полученный из getDocumentTypes. Обязателен. -->
        <ticketTypeId>1#1#0</ticketTypeId>
        <!-- Персональные данные пассажира. Один пассажир на один билет -->
        <Passenger>
            <!-- Имя пассажира. Обязательно -->
            <firstName>goxUEpWCud</firstName>
            <!-- Фамилия пассажира. Обязательно-->
            <lastName>sKZXIloHFn</lastName>
            <!-- Отчество пассажира. Обязательно для Международных, Межобластных и Межреспубликанских рейсов-->
            <middleName>pCaEgXgfWO</middleName>         
            <!-- Номер документа удостоверяющего личности. Обязателен.-->
            <docNum>jwcmdIrmcc</docNum>         
            <!-- Серия документа удостоверяющего личности. Не Обязателен.-->
            <docSeries>iFAElsnFHn</docSeries>           
            <!-- Идентификатор типа документа полученный при вызове getDocumentTypes. Обязателен. -->
            <docTypeId>1</docTypeId>            
            <!-- Дата рождения. Обязательно для Международных, Межобластных и Межреспубликанских рейсов -->
            <birthday>1986-01-01</birthday>
            <!-- Гражданство виде ISO2.  Обязательно для Международных, Межобластных и Межреспубликанских рейсов -->
            <citizenshipISO2>RU</citizenshipISO2>
            <!-- 
            Пол. Обязательно для Международных, Межобластных и Межреспубликанских рейсов 
            MALE - Мужской
            FEMALE - Женский
            -->
            <gender>MALE</gender>
       </Passenger>
    </Sale>
    <!-- Агент выполнивший операцию. Не Обязателен. -->
    <Agent>
        <!-- Имя агента. Не обязателен.-->
        <name>ИП Твои билеты</name>
        <!-- ИНН агента. Не обязателен.-->
        <inn>2225555777</inn>
    </Agent>
</BookOrderRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Response success="true">
    <Body>
        <!-- Идентификатор заказ. Обязателен. -->
        <orderId>9828350</orderId>
        <!-- Время жизни заказа. В минутах. Не обязателен. По умолчанию значение 30 -->
        <lifetime>30</lifetime>
    </Body>
</Response>
```

### getOrder

Получение информации о заказе. В параметрах принимает идентификатор
заказа, полученный в результате bookOrder. Метод должен вернуть такое же
количество билетов сколько было передано при вызове bookOrder. Метод
должен работать на любом этапе жизни заказа т.е. после создания,
подтверждения, отмены, возврата.

**URL: \[BASE\_URL\]/sales/getOrder**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<GetOrderRequest>
    <!-- Идентификатор заказа, полученный при вызове bookOrder. Обязателен.-->
    <orderId>9828350</orderId>
</GetOrderRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Response success="true">
    <Body>
    <!-- Идентификатор заказа. Обязателен. -->
        <orderId>9828350</orderId>
        <!-- Информация о билетах. Отдельный тег для каждого билета -->
        <Ticket>
            <!-- Идентификатор билет. Обязателен. -->
            <id>12435438</id>
            <!-- Номер билета. Обязателен после подтверждения заказа. -->
            <number></number>
            <!-- Серия билета. Не обязателен. -->
            <series></series>
            <!-- Дата и время создания билета. Обязателен. -->
            <created>2016-07-13T05:48:15</created>
            <!-- Дата и время возврата билета. Обязателен после возврата или отмены. -->
            <returned></returned>
            <!-- 
             Статус билета
RESERVED Забронирован. Данный статус билет получает после бронирования. bookOrder
SOLD Продан. Данный статус билет получает после операции продажи. confirmOrder
CANCELED Отмена билета. Данный статус билет получает после отмены билета. cancelTicket
RETURNED Выполнен возврат билета. Данный статус билет получает после возврата билета. returnTicket
             -->
            <status>RESERVED</status>
             <!-- 
            Класс билета
            PASSENGER Пассажирский билет, с выделением места
            BAGGAGE Багажный билет, без выделения места
            -->
            <ticketClass>PASSENGER</ticketClass>
            <!-- Идентификато типа билета. Обязателен. -->
            <typeId>1#1#0</typeId>
            <!-- Номер маршрута. Не обязателен. -->
            <routeNum>000</routeNum>
            <!-- Название маршрута. Обязателен. -->
            <routeName>ВДНХ АС - Рыбинск</routeName>
            <!-- Информация об автобусе. Обязателен -->
            <busInfo>19 Мест Категория ТС &quot;М3&quot;  </busInfo>
            <!-- Название перевозчика. Не обязателен -->
            <carrierName>ООО &quot;ВВМЛ&quot;</carrierName>
            <!-- ИНН перевозчика. Обязателен. -->
            <carrierInn>ИНН 7610074937</carrierInn>
            <!-- Платформа отправления. Не обязателен. -->
            <platform>Перрон 11</platform>
            <!-- Дата и время отправления рейса. Обязателен. -->
            <dispatchDate>2016-07-13T12:20:00</dispatchDate>
            <!-- Станция посадки. Обязателен.-->
            <dispatchStation>ВДНХ АС</dispatchStation>
            <!-- Адрес станции посадки. Не обязателен -->
            <dispatchAddress>пл.Шарля де Голля напротив Космонавтов2А,</dispatchAddress>
            <!-- Дата и время прибытия. Обязателен. -->
            <arrivalDate>2016-07-13T16:20:00</arrivalDate>
            <!-- Станция назначения. Обязателен. -->
            <arrivalStation>Углич</arrivalStation>
            <!-- Название места. Обязателен. -->
            <seatName>Место 1</seatName>
            <!-- Информация о пассажире. -->
            <Passenger>
                <lastName>Ckayuukvgn</lastName>
                <firstName>Bgkzxffotu</firstName>
                <middleName>Isdikvryin</middleName>
                <docNum>PUPrvbqlgU</docNum>
                <docSeries>fRHEoBHVbG</docSeries>
                <docTypeId>1</docTypeId>
                <birthday>1985-01-01</birthday>
                <citizenshipISO2>RU</citizenshipISO2>
                <gender>MALE</gender>
            </Passenger>
            <!-- Тариф (руб). Обязателен после подтверждения. -->
            <fare>0</fare>
            <!-- Cборы (руб). Обязателен после подтверждения. Если нет то 0. -->
            <fees>0</fees>
            <!-- Удержано Тариф (руб). Обязателен в случает возврата или отмены. -->
            <chargeFare>0</chargeFare>
            <!-- Удержано Остальные сборы (руб). Обязателен в случает возврата или отмены. -->
            <chargeOthers>0</chargeOthers>
            <!-- Возврат Тариф (руб). Обязателен в случает возврата или отмены. -->
            <repaymentFare>0</repaymentFare>
            <!-- Возврат Остальные сборы (руб). Обязателен в случает возврата или отмены. -->
            <repaymentOthers>0</repaymentOthers>
            <!-- Информация о страховании. Обязательно. Необходим при печати билета. -->
            <insuranceInfo>СТРАХОВЩИК: ПАО &quot;Росстрах&quot;; 119991; г. Москва; ул. Большая Ордынка; д. 40; стр.</insuranceInfo>
        </Ticket>
    </Body>
</Response>
```

### confirmOrder

Подтверждение оплаты заказа. Данный метод должен вызываться только после
того как заказ действительно был оплачен покупателем. Метод не должен
делать проверок корректности заказа, все проверки должны выполняться в
bookOrder или updateTicket. Вызов этого метода означает подтверждение
правильного приема данных и получение денег от покупателя. В параметрах
принимает идентификатор заказа, полученный в результате bookOrder и
информацию об агенте который совершил операцию

**URL: \[BASE\_URL\]/sales/confirmOrder**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ConfirmOrderRequest>
    <orderId>9828585</orderId>
    <!-- Агент выполнивший операцию. Не Обязателен. -->
    <Agent>
        <!-- Имя агента. Не обязателен.-->
        <name>ИП Твои билеты</name>
        <!-- ИНН агента. Не обязателен.-->
        <inn>2225555777</inn>
    </Agent>
</ConfirmOrderRequest>
```

Ответ:

Ответ аналогичен ответу на запрос [getOrder](#getorder)

### cancelTicket

Отмена билета. Техническая операция, выполняет полный возврат билета без
удержаний. Необходима при нештатных ситуациях: в случае сбоев ККМ или
обнаружения ошибки выбора рейса, персональных данных. В параметрах
принимает идентификатор билета и информацию об агенте который совершил
операцию. Можно выполнять после создания заказа и в течении 5-30 минут
после подтверждения заказа.

**URL: \[BASE\_URL\]/sales/cancelTicket**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<CancelTicketRequest>
    <ticketId>12435434</ticketId>
    <!-- Агент выполнивший операцию. Не Обязателен. -->
    <Agent>
        <!-- Имя агента. Не обязателен.-->
        <name>ИП Твои билеты</name>
        <!-- ИНН агента. Не обязателен.-->
        <inn>2225555777</inn>
    </Agent>
</CancelTicketRequest>
```

Ответ:

Ответ аналогичен ответу на запрос [getOrder](#getorder)

### returnTicket

Возврат билета. При возврате возможны удержания. В параметрах принимает
идентификатор билета и информацию об агенте который совершил операцию.
Билет можно вернуть только после подтверждения confirmOrder.

**URL: \[BASE\_URL\]/sales/returnTicket**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ReturnTicketRequest>
    <ticketId>12435435</ticketId>
    <!-- Агент выполнивший операцию. Не Обязателен. -->
    <Agent>
        <!-- Имя агента. Не обязателен.-->
        <name>ИП Твои билеты</name>
        <!-- ИНН агента. Не обязателен.-->
        <inn>2225555777</inn>
    </Agent>
</ReturnTicketRequest>
```

Ответ:

Ответ аналогичен ответу на запрос [getOrder](#getorder)

### updateTicket

Изменение персональных данных пассажира в забронированном или проданном
билете. В параметрах принимает идентификатор билета, информацию о
пассажире и информацию об агенте который совершил операцию.

**URL: \[BASE\_URL\]/sales/updateTicket**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<UpdateTicketRequest>
    <!-- Идентификатор билета. Обязательный -->
    <ticketId>12435438</ticketId>
    <Passenger>
        <!-- Имя пассажира. Обязательно -->
        <firstName>goxUEpWCud</firstName>
        <!-- Фамилия пассажира. Обязательно-->
        <lastName>sKZXIloHFn</lastName>
        <!-- Отчество пассажира. Обязательно для Международных, Межобластных и Межреспубликанских рейсов-->
        <middleName>pCaEgXgfWO</middleName>         
        <!-- Номер документа удостоверяющего личности. Обязателен.-->
        <docNum>jwcmdIrmcc</docNum>         
        <!-- Серия документа удостоверяющего личности. Не Обязателен.-->
        <docSeries>iFAElsnFHn</docSeries>           
        <!-- Идентификатор типа документа полученный при вызове getDocumentTypes. Обязателен. -->
        <docTypeId>1</docTypeId>            
        <!-- Дата рождения. Обязательно для Международных, Межобластных и Межреспубликанских рейсов -->
        <birthday>1986-01-01</birthday>
        <!-- Гражданство виде ISO2.  Обязательно для Международных, Межобластных и Межреспубликанских рейсов -->
        <citizenshipISO2>RU</citizenshipISO2>
        <!-- 
        Пол. Обязательно для Международных, Межобластных и Межреспубликанских рейсов 
        MALE - Мужской
        FEMALE - Женский
        -->
        <gender>FEMALE</gender>
    </Passenger>
    <!-- Агент выполнивший операцию. Не Обязателен. -->
    <Agent>
        <!-- Имя агента. Не обязателен.-->
        <name>ИП Твои билеты</name>
        <!-- ИНН агента. Не обязателен.-->
        <inn>2225555777</inn>
    </Agent>
</UpdateTicketRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Response success="true">
</Response>
```
