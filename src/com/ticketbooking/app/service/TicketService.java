package com.ticketbooking.app.service;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.ticketbooking.app.entity.TicketDetails;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface TicketService {

	@WebMethod
	public String createTicket(TicketDetails tkt) throws Throwable;
	
	@WebMethod
	public TicketDetails getTicket(Long id);
	
}