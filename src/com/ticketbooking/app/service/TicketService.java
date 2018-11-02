package com.ticketbooking.app.service;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import com.ticketbooking.app.Entity.TicketDetails;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface TicketService {

	@WebMethod
	public long createTicket(TicketDetails tkt);
	
	@WebMethod
	public TicketDetails getTicket(long id);
	
	@WebMethod
	public TicketDetails[] getAllTickets();
}