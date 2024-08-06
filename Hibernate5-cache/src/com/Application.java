package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Application {
	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getConnection();
		Session session=sf.openSession();
		Session session1=sf.openSession();
//		Employee emp=new Employee();
//		emp.setEname("Priya");
//		emp.setAddress("Chinchawad");
		
		//First level cache
		//only one time query fires
//		Employee e1=session.get(Employee.class,1);
//		Employee e2=session.get(Employee.class,1);
		
		//two times query fires because of 2 different session instance
//		Employee e1=session.get(Employee.class,1);
//		Employee e2=session1.get(Employee.class,1);

		//Second level cache
//				only one time query fires
//				Employee e1=session.get(Employee.class,1);
//				Employee e2=session.get(Employee.class,1);
				
				//one times query fires because of sessionfactory level cache
				Employee e1=session.get(Employee.class,1);
				Employee e2=session1.get(Employee.class,1);
		
		System.out.println(e1);
		System.out.println(e2);
//		session.save(emp);
		session.beginTransaction().commit();
		
		
	}

}
