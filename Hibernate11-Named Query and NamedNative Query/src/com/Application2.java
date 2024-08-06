package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Application2 {
	
	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getConnection();
		Session session=sf.openSession();
//		
//		Student stu=new Student();
//		stu.setSname("Chetan");
//		session.save(stu);
//		session.beginTransaction().commit();
//		
		
		
		
		
	}

}
