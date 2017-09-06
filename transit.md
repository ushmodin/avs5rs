Спецификация протокола взаимной продажи билетов на транзиные рейсы
===========================================================================

**Версия документа: 1.0**

**Дата изменения: 06.09.2017**

Введение
========

Данный документ содержит спецификацию протокола AVS5RS, предназначенного
для организации взаимной продажи билетов меджу автовокзалами на транзитные рейсы.
Для унификации в протоколе используются термины UID остановочного пункта и ключ маршрута.
UID остановочного пункта это ID станции одинаковый на всех вокзалах. 
Ключ маршрута это структура состоящая из:

* UID начальной станции
* UID конечной станции
* время выхода из начальной станции

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

Доступ к веб-сервису, реализующему протокол AVS5RS, должен быть закрыт с
применением Basic-аутентификации. Допускается использование протокола
HTTPS, контроля доступа по IP, передача данных через VPN-соединение.


Общие форматы данных:
---------------------

Формат даты: `yyyy-MM-dd`, формат даты и времени:
`yyyy-MM-dd'T'HH:mm:ss`. Пример:
2016-09-07T13:10:00 (символ T латинский, обязательный) (секунды
обязательны). Время указано в часовом поясе сервера который
предоставляет контент.

Числа с плавающий точко в качестве разделителя используют точку. 
Дробная часть не обязательна и не более 2 знаков.

Все идентификаторы сущностей (id и uid) это строки, произвольного формата, длинной до 36 символов.
Разрешенные символы: цифры, латинские буквы в любом регистре, и символы -={}[]$
Могут быть как искусственными (sequence) так и реальными значениями (номер билета, номер места и.т.д.)

Форматы данных XML
------------------

Ответы с сервера должны поступать по протоколу HTTP c кодом 200 и
HTTP-заголовком “Content-Type”, имеющим значение “application/xml; charset=UTF-8”.

Тело XML- ответа должно начинаться с объявления
`<?xml version="1.0" encoding="UTF-8"?>`. Регистр
названий тегов и атрибутов должен совпадать с регистром из примеров.

XML-ответ в обязательном порядке имеет корневой тег, название которого 
должно соответствовать формату "&lt;НазваниеМетодаResponse&gt;" (например EchoResponse, SearchTripsResponse)
Если ответ корректный, то данные ответа содержатся во вложенном теге &lt;Body&gt;.
Если ответ не корректный, информация об ошибке должна находиться во
вложенном теге &lt;Error&gt;, который состоит из кода ошибки в теге
&lt;code&gt; и описания ошибки в теге &lt;message&gt;. Код ошибок в приложении. 
Описание - это произвольные текст на русском языке,
поясняющий причину ошибки. Некоторые методы допускают пустой ответ. 
Пустой ответ содержит только корневой тег.

Пустой ответ:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<UpdateTicketResponse>
</UpdateTicketResponse>
```

Пример ответа в случае успешной обработки запроса:

```xml
<?xml version="1.0" encoding="UTF-8"?>
 <EchoResponse>
    <Body>
        <message>Test</message>
    </Body>
 </EchoResponse>
```

Пример ответа в случае обработки запроса с ошибкой:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<BookResponse>
    <Error>
        <code>ERROR</code>
        <message>Место 5 занято</message>
    </Error>
</BookResponse>
```

Методы протокола
----------------

### getFreeSeats

Получение списка свободных мест для рейса между указанными станциями. В параметре принимает ключ маршрута, дату и UIDы станции отправления и назначения

**URL: \[BASE\_URL\]/transit/getFreeSeats**


Запрос:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<GetFreeSeatsRequest>
    <!-- ключ маршрута -->
    <RouteKey>
        <!-- UID станции отправления рейса -->        
        <dispatchStationUid>523243243209840293840293849895781093</dispatchStationUid>
        <!-- UID конечной станции -->        
        <arrivalStationUid>90929359890589203498093209904288</arrivalStationUid>
        <!-- время отправления со станции отпраления. в часовом поясе станции отправления. -->        
        <dispatchTime>10:00:00</dispatchTime>
    </RouteKey>
    <!-- Дата отправления рейса со станции посадки поссажира -->
    <date>2017-08-11</date>
    <!-- UID станции посадки пассажира -->
    <dispatchStationUid>hhwrl23kjhjj434kjljkshakjlk2j3l2</dispatchStationUid>
    <!-- UID станции высадки пассажира -->
    <arrivalStationUid>34l5klk435l435j34jjjk345jjk344CC</arrivalStationUid>
</GetFreeSeatsRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<GetFreeSeatsResponse>
    <Body>
        <TransitSeat>
            <!-- ID места. Обязателен -->
            <seatId>26</seatId>
            <!-- Номер места места. Обязателен -->
            <seatNum>26</seatNum>
        </TransitSeat>
        <TransitSeat>
            <seatId>29</seatId>
            <seatNum>29</seatNum>
        </TransitSeat>
        ..............
        <TransitSeat>
            <seatId>47</seatId>
            <seatNum>47</seatNum>
        </TransitSeat>
    </Body>
</GetFreeSeatsResponse>
```

### book

Бронирование заказа. Бронь должна сохраняться в течение ограниченного времени,
от 20 до 60 минут. Если в указанный период времени не поступает
подтверждение оплаты через метод transit/confirm, то система реализующая протокол 
обязана отменить бронь. Допускается бронирование нескольких билетов в рамках одного
заказа. В параметрах запроса передаются ключ маршрута, дата рейса
идентификатор станции отправления, идентификатор станции назначения, 
 информацию об агенте совершивший эту операцию. 

**URL: \[BASE\_URL\]/transit/bookOrder**

Запрос:

```xml
<?xml version="1.0"?>
<TransitBookRequest>
    <!-- ключ маршрута -->
    <RouteKey>
        <!-- UID станции отправления рейса -->        
        <dispatchStationUid>523243243209840293840293849895781093</dispatchStationUid>
        <!-- UID конечной станции -->        
        <arrivalStationUid>90929359890589203498093209904288</arrivalStationUid>
        <!-- время отправления со станции отпраления. в часовом поясе станции отправления. -->        
        <dispatchTime>10:00:00</dispatchTime>
    </RouteKey>
    <!-- Дата отправления рейса со станции посадки поссажира -->
    <date>2017-08-11</date>
    <!-- UID станции посадки пассажира -->
    <dispatchStationUid>hhwrl23kjhjj434kjljkshakjlk2j3l2</dispatchStationUid>
    <!-- UID станции высадки пассажира -->
    <arrivalStationUid>34l5klk435l435j34jjjk345jjk344CC</arrivalStationUid>
    <Agent>
        <!-- Имя агента. Не обязателен.-->
        <name>ИП Твои билеты</name>
        <!-- ИНН агента. Не обязателен.-->
        <inn>2225555777</inn>
    </Agent>    
</TransitBookRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<TransitBookResponse>
    <Body>
        <TransitTicket>
            <!-- ID билета на мастер сервере -->
            <ticketId>25074373</ticketId>
            <!-- Номер места -->
            <seatNum>48</seatNum>
        </TransitTicket>
    </Body>
</TransitBookResponse>
```

### confirm

**URL: \[BASE\_URL\]/transit/confirm**

Подтверждение оплаты заказа. Переводит временную бронь созданную после операции book в постоянную.

Запрос:

```xml
<?xml version="1.0"?>
<TransitConfirmRequest>
    <!-- ключ маршрута -->
    <RouteKey>
        <!-- UID станции отправления рейса -->        
        <dispatchStationUid>523243243209840293840293849895781093</dispatchStationUid>
        <!-- UID конечной станции -->        
        <arrivalStationUid>90929359890589203498093209904288</arrivalStationUid>
        <!-- время отправления со станции отпраления. в часовом поясе станции отправления. -->        
        <dispatchTime>10:00:00</dispatchTime>
    </RouteKey>
    <Ticket>
        <!-- ID билета. Обязательно --> 
    	<ticketId>21326881</ticketId>	
    	<Passenger>
            <!-- Имя пассажира. Необязательно --> 
    		<firstName>Ivan</firstName>
            <!-- Фамилия пассажира. Необязательно --> 
    		<lastName>Ivanov</lastName>
            <!-- Отчество пассажира. Необязательно --> 
    		<middleName>Ivanovich</middleName>
            <!-- ID типа документа. Из справочника МИНТРАС. Необязательно --> 
    		<docTypeId>0</docTypeId>
            <!-- Номер документа. Необязательно --> 
    		<docNum>0101</docNum>
            <!-- Серия документа. Необязательно --> 
    		<docSeries>010101</docSeries>
            <!-- Дата рождения. Необязательно --> 
    		<birthday>2000-01-01</birthday>
            <!-- Пол. MALE FEMALE. Необязательно --> 
    		<gender>MALE</gender>
    	</Passenger>
        <!-- Серия билета. Необязательно --> 
    	<ticketSeries>1232344</ticketSeries>
        <!-- Номер билета. Необязательно -->
        <ticketNumber>3432423423</ticketNumber>
        <!-- Итоговая цена по которой продан билет. Необязательно -->
        <price>1000</price>
        <!-- Отношения между продовцом и поставщиком контента. OWN AGENT ATP. Необязательно -->
        <relation>AGENT</relation>
    </Ticket>
    <Agent>
        <!-- Имя агента. Не обязателен.-->
        <name>ИП Твои билеты</name>
        <!-- ИНН агента. Не обязателен.-->
        <inn>2225555777</inn>
    </Agent>        
</TransitConfirmRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<TransitConfirmResponse/>
```

### cancel

Отмена ранее забронированного места. Отмена билета допускается после оперций book и confirm.

**URL: \[BASE\_URL\]/transit/cancel**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<TransitCancelRequest>
    <!-- ключ маршрута -->
    <RouteKey>
        <!-- UID станции отправления рейса -->        
        <dispatchStationUid>523243243209840293840293849895781093</dispatchStationUid>
        <!-- UID конечной станции -->        
        <arrivalStationUid>90929359890589203498093209904288</arrivalStationUid>
        <!-- время отправления со станции отпраления. в часовом поясе станции отправления. -->        
        <dispatchTime>10:00:00</dispatchTime>
    </RouteKey>
    <!-- ID билета. Обязательно --> 
    <ticketId>4561143</ticketId>
    <Agent>
        <!-- Имя агента. Не обязателен.-->
        <name>ИП Твои билеты</name>
        <!-- ИНН агента. Не обязателен.-->
        <inn>2225555777</inn>
    </Agent>    
</TransitCancelRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<TransitCancelResponse/>
```

### getTripInfo

Возвращет информацию о пассажирах на указанном рейсе.
 В выборку должны попасть пассажиры которые будут находится в автобусе при его движении между запрашиваемыми станциями. 

**URL: \[BASE\_URL\]/transit/getTripInfo**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<TransitTripInfoRequest>
    <!-- ключ маршрута -->
    <RouteKey>
        <!-- UID станции отправления рейса -->        
        <dispatchStationUid>523243243209840293840293849895781093</dispatchStationUid>
        <!-- UID конечной станции -->        
        <arrivalStationUid>90929359890589203498093209904288</arrivalStationUid>
        <!-- время отправления со станции отпраления. в часовом поясе станции отправления. -->        
        <dispatchTime>10:00:00</dispatchTime>
    </RouteKey>
    <!-- Дата отправления рейса со станции посадки поссажира -->
    <date>2017-08-11</date>
    <!-- UID станции посадки пассажира. Не обязательный. Если не указан, то равен станции отправления рейса -->
    <dispatchStationUid>523243243209840293840293849895781093</dispatchStationUid>
    <!-- UID станции высадки пассажира. Не обязательный. Если не указан, то равен конечной станции рейса -->
    <arrivalStationUid>90929359890589203498093209904288</arrivalStationUid>    
</TransitTripInfoRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<TransitTripInfoResponse>
    <Body>
        <Ticket>
            <!-- UID станции посадки пассажира. -->        
            <dispatchStationUid>E19A767A4C4C43F3855E10DA31CD3749</dispatchStationUid>
            <!-- UID станции высадки пассажира. -->
            <arrivalStationUid>AE751908D644441298AEBD4001871311</arrivalStationUid>
            <!-- ID билета. -->
            <ticketId>4562182</ticketId>
            <!-- серия билета. -->
            <ticketSeries>2202022202</ticketSeries>
            <!-- номер билета. -->
            <ticketNumber>2457677</ticketNumber>
            <!-- место билета. -->
            <seatNum>3</seatNum>
            <!-- цена билета. -->
            <price>470</price>
        </Ticket>
        <Ticket>
            <dispatchStationUid>AE751908D644441298AEBD4001871311</dispatchStationUid>
            <arrivalStationUid>25CBF1CE4E224C0A85C4CCEAD3E4C537</arrivalStationUid>
            <ticketId>4562669</ticketId>
            <seatNum>3</seatNum>
        </Ticket>
        <Ticket>
            <dispatchStationUid>E19A767A4C4C43F3855E10DA31CD3749</dispatchStationUid>
            <arrivalStationUid>88184B22DA28440590D6202D2014E5F3</arrivalStationUid>
            <Passenger>
                <!-- Имя пассажира. Необязательно --> 
                <firstName>Ivan</firstName>
                <!-- Фамилия пассажира. Необязательно --> 
                <lastName>Ivanov</lastName>
                <!-- Отчество пассажира. Необязательно --> 
                <middleName>Ivanovich</middleName>
                <!-- ID типа документа. Из справочника МИНТРАС. Необязательно --> 
                <docTypeId>0</docTypeId>
                <!-- Номер документа. Необязательно --> 
                <docNum>0101</docNum>
                <!-- Серия документа. Необязательно --> 
                <docSeries>010101</docSeries>
                <!-- Дата рождения. Необязательно --> 
                <birthday>2000-01-01</birthday>
                <!-- Пол. MALE FEMALE. Необязательно --> 
                <gender>MALE</gender>
            </Passenger>
            <ticketId>4553771</ticketId>
            <ticketSeries>2202982202</ticketSeries>
            <ticketNumber>41159</ticketNumber>
            <seatNum>4</seatNum>
            <price>167</price>
        </Ticket>
        <!-- Вместимость автобуса -->
        <maxSeats>43</maxSeats>
        <!-- Количество свободных мест между указанными станциями -->
        <freeSeats>22</freeSeats>
        <Carrier>
            <!-- Имя перевозчика -->
            <name>ПАП города N</name>
            <!-- ИНН перевозчика -->
            <inn>4534995945</inn>
        </Carrier>
    </Body>
</TransitTripInfoResponse>
```

### getRouteInfo

Возвращает информацию по маршруту. Информация содержит название и описание остановочных пунктов маршрута.

**URL: \[BASE\_URL\]/transit/getRouteInfo**

Запрос:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<TransitRouteInfoRequest>
    <!-- ключ маршрута -->
    <RouteKey>
        <!-- UID станции отправления рейса -->        
        <dispatchStationUid>523243243209840293840293849895781093</dispatchStationUid>
        <!-- UID конечной станции -->        
        <arrivalStationUid>90929359890589203498093209904288</arrivalStationUid>
        <!-- время отправления со станции отпраления. в часовом поясе станции отправления. -->        
        <dispatchTime>10:00:00</dispatchTime>
    </RouteKey>
</TransitRouteInfoRequest>
```

Ответ:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<TransitRouteInfoResponse>
    <Body>
        <!-- Название маршрута. Обязательно -->
        <name>Белокуриха - Рубцовск</name>
        <RouteItem>
            <!-- порядок остановочного пункта. Обязательно -->
            <order>1</order>
            <!-- Название остановочного пункта. Обязательно -->
            <stationName>Белокуриха</stationName>
            <!-- UID остановочного пункта. Обязательно -->
            <stationUid>E19A767A4C4C43F3855E10DA31CD3749</stationUid>
            <!-- Расстояние. Необязательно -->
            <distance>0</distance>
        </RouteItem>
        <RouteItem>
            <order>2</order>
            <stationName>Быканов Мост</stationName>
            <stationUid>0ae247cb-b7b3-41df-8814-04065f7867fc</stationUid>
            <distance>10</distance>
        </RouteItem>
        .........
        <RouteItem>
            <order>17</order>
            <stationName>Рубцовск</stationName>
            <stationUid>25CBF1CE4E224C0A85C4CCEAD3E4C537</stationUid>
            <distance>559</distance>
        </RouteItem>
    </Body>
</TransitRouteInfoResponse>
```