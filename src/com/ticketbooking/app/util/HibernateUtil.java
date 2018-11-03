package com.ticketbooking.app.util;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.ticketbooking.app.entity.TicketDetails;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static ServiceRegistry serviceRegistry;

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration config = new Configuration();
			config.configure(new File("hibernate.cfg.xml"));
			config.addAnnotatedClass(com.ticketbooking.app.entity.TicketDetails.class); 
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

			return config.buildSessionFactory(serviceRegistry);

		} catch (Throwable ex) {

			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}