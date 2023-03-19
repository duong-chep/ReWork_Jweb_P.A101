package com.duong.jweb.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	static {
		if(sessionFactory == null) {
			final String hibernate_cfg_path = "/hibernate.cfg.xml";
			Configuration configuration = new Configuration();
			configuration.configure(hibernate_cfg_path);
			sessionFactory = configuration.buildSessionFactory();
		}
	}
	public static Session openSession() {
		return sessionFactory.openSession();
	}
	public static void closeSession(Session session) {
		if(session != null && session.isOpen())
			session.close();
	}
	
	public static Session getCurrentSessionAndBeginTransaction() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		return session;
	}
	
	public static Session commitCurrentTransaction() {
		Session session = sessionFactory.getCurrentSession();
		if(session != null && session.isOpen()) {
			Transaction tx = session.getTransaction();
			tx.commit();
		}
		return session;
	}
	
	public static void closeCurrentSession() {
		Session session = sessionFactory.getCurrentSession();
		if(session != null && session.isOpen()) {
			session.close();
		}
	}
}
