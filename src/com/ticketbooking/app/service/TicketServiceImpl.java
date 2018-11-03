package com.ticketbooking.app.service;

import java.util.Set;

import javax.jws.WebService;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import com.ticketbooking.app.entity.TicketDetails;
import com.ticketbooking.app.repo.TicketRepo;
import com.ticketbooking.app.repo.TicketRepoImpl;

@WebService(endpointInterface = "com.ticketbooking.app.service.TicketService")
public class TicketServiceImpl implements TicketService {

	private static Validator validator = null;

	public TicketServiceImpl() {
		super();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	public String createTicket(TicketDetails tkt) throws Throwable {
		Set<ConstraintViolation<TicketDetails>> constraintViolations = validator.validate(tkt);
		if (constraintViolations.size() == 0) {
			TicketRepo repo = new TicketRepoImpl();
			Long ackId = repo.createTicket(tkt);
			if (null==ackId) {
				throw new RuntimeException(
						"tciket is already booked for the given passport for date:" + tkt.getDoj().toString());
			} else {
				return "Ticket is booked ackId is : "+ackId;
			}
		} else {
			for (ConstraintViolation<TicketDetails> c : constraintViolations) {
				System.out.println("ERROR MESSAGE " + c.getMessage());
			}
			throw new RuntimeException("Validation failed, please enter valid fields.");
		}
	}

	public TicketDetails getTicket(Long id) {
		TicketRepo repo = new TicketRepoImpl();

		if (id != null) {
			TicketDetails details = repo.getTicket(id);
			if (null == details) {
				System.out.println("No records exist with ID:" + id);
				return details;
			} else
				return details;
		} else {
			throw new RuntimeException("Please provide valid ACK-Id ");
		}
	}
}