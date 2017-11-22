package com.artmark.avs5rs.transit;

import com.artmark.avs5rs.transit.model.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author Ushmodin N.
 * @since 14.11.2016 09:07
 */
@Path("/transit")
public interface TransitService {

	@Path("getFreeSeats")
	@POST
	GetFreeSeatsResponse getFreeSeats(GetFreeSeatsRequest request);

	@Path("book")
	@POST
	TransitBookResponse book(TransitBookRequest request);

	@Path("confirm")
	@POST
	TransitConfirmResponse confirm(TransitConfirmRequest request);

	@Path("cancel")
	@POST
	TransitCancelResponse cancel(TransitCancelRequest request);

	@Path("setStationInfo")
	@POST
	SetStationInfoResponse setStationInfo(SetStationInfoRequest request);

	@Path("getTripInfo")
	@POST
	TransitTripInfoResponse getTripInfo(TransitTripInfoRequest request);

	@Path("getRouteInfo")
	@POST
	TransitRouteInfoResponse getRouteInfo(TransitRouteInfoRequest request);
}
