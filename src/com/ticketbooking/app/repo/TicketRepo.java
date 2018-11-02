package com.ticketbooking.app.repo;

import com.ticketbooking.app.Entity.TicketDetails;

public interface TicketRepo {

	public long createTicket(TicketDetails details);
	public TicketDetails getTicket(long id);
	public TicketDetails[] getAllTickets();
}
