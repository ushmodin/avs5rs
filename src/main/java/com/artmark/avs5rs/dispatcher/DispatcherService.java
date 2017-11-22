package com.artmark.avs5rs.dispatcher;


import com.artmark.avs5rs.dispatcher.model.UpdateTicketRequest;
import com.artmark.avs5rs.dispatcher.model.UpdateTicketResponse;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Сервис операций диспетчера.
 * @author Ushmodin N.
 * @since 07.07.2016 10:06
 */

@Path("/dispatcher")
public interface DispatcherService {
	@POST
	@Path("updateTicket")
	UpdateTicketResponse updateTicket(UpdateTicketRequest request);
}
