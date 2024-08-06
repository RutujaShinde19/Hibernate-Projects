package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Application {
	
	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getFactory();
		
		Session session=sf.openSession();
		
		Student s=new Student();
		
//		s.setSid(11);
//		s.setSname("Ram");
		
//		s.setSid(12);
//		s.setAddress("PCMC");
		
		s.setSid(16);
		s.setSname("Aditi");
		s.setAddress("Ravet");
		
//		int i=(int)session.save(s);//returns serializable int
//		session.save(s);
//		session.persist(s);//returns void
		
		//update
//		session.update(s);
		
		//delete
//		session.delete(s);
		
		//SaveorUpdate()
		session.saveOrUpdate(s);
		
		
		session.beginTransaction().commit();
		
		System.out.println("Success...");
		
	}

}
