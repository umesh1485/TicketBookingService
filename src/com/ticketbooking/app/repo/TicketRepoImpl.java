package com.ticketbooking.app.repo;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ticketbooking.app.entity.TicketDetails;
import com.ticketbooking.app.util.HibernateUtil;

public class TicketRepoImpl implements TicketRepo {

	public Long createTicket(TicketDetails details) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Query query = session.createQuery("from TicketDetails where doj= :date and passport= :passprt");
			query.setParameter("passprt", details.getPassport());
			query.setParameter("date", details.getDoj(), TemporalType.DATE);
			if (query.getResultList().size() == 0) {
				session.save(details);
			}
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return details.getId();
	}

	public TicketDetails getTicket(Long id) {
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
}
