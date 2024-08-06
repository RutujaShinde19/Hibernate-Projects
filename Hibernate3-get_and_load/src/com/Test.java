package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getFactory();
		 
		Session session=sf.openSession();
//		Session session1=sf.openSession();
//		
//		//every time different instance of session is created
//		System.out.println(session.hashCode());
//		System.out.println(session1.hashCode());
		
//		Session session=sf.getCurrentSession();
//		Session session1=sf.getCurrentSession();
		
		//here only one time session is open 
//		System.out.println(session.hashCode());
//		System.out.println(session1.hashCode());
		
		
		
		
	}

}
