package com.ticketbooking.app.repo;

import com.ticketbooking.app.entity.TicketDetails;

public interface TicketRepo {

	public Long createTicket(TicketDetails details);
	public TicketDetails getTicket(Long id);
	
}
