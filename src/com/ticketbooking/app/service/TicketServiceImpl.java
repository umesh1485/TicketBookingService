package com.ticketbooking.app.service;

import javax.jws.WebService;
import com.ticketbooking.app.Entity.TicketDetails;

@WebService(endpointInterface = "com.ticketbooking.app.service.TicketService")
public class TicketServiceImpl implements TicketService {


	public long createTicket(TicketDetails tkt) {
		
		return 125;
	}

	public TicketDetails getTicket(long id) {
		
		return null;
	}

	public TicketDetails[] getAllTickets() {
		
		return null;
	}

}