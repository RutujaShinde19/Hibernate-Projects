package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Application {
	
	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getConnection();
		
		Session session=sf.openSession();
		
//		Employee e1=new Employee();
//		e1.setEname("Rahul");
		
		Employee e1=new Employee();
		e1.setEname("Samir");
		
		Department d=new Department();
		d.setDname("Testing");
		
		session.save(e1);
		session.save(d);
		session.beginTransaction().commit();
	}

}
