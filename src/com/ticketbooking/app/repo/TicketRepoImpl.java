package com.ticketbooking.app.repo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketbooking.app.Entity.TicketDetails;
import com.ticketbooking.app.util.HibernateUtil;

public class TicketRepoImpl implements TicketRepo {

	public long createTicket(TicketDetails details) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			session.save(details);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return details.getId();
	}

	public TicketDetails getTicket(long id) {
		Session session = null;
		TicketDetails details = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			details = session.get(TicketDetails.class, id);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return details;
	}

	public TicketDetails[] getAllTickets() {
		Session session = null;
		TicketDetails details = null;
		List<TicketDetails> list = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query<TicketDetails> query = session.createQuery("from TicketDetails");
			list = query.list();
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		TicketDetails[] arr = new TicketDetails[list.size()];
		return arr;
	}

}
