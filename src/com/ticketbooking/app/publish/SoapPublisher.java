package com.ticketbooking.app.publish;

import javax.xml.ws.Endpoint;
import com.ticketbooking.app.service.TicketServiceImpl;

public class SoapPublisher {

	public static void main(String[] args) {
		 
		Endpoint.publish("http://localhost:8888/ws/ticket", new TicketServiceImpl());  
		System.out.println("TicketService is Pulished...");
	}

}