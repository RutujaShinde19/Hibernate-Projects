package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Application {
	
	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getFactory();
		
		Session session=sf.openSession();
		
//		Employee emp1=new Employee();
//		emp1.setEid(1);
//		emp1.setEname("Rahul");
//		emp1.setAddress("PCMC");
		
//		Employee emp1=new Employee();
//		emp1.setEid(2);
//		emp1.setEname("Ram");
//		emp1.setAddress("Pune");
		
		Employee emp1=new Employee();
		emp1.setEid(3);
		emp1.setEname("Yash");
		emp1.setAddress("Ravet");
		 
		session.save(emp1);
		
//		session.beginTransaction().commit();
		
		//get() method
//		Employee emp=session.get(Employee.class,1);
//		System.out.println(emp.getEid());
//		System.out.println(emp.getEname());
//		System.out.println(emp.getAddress());
		
		//if id not present==it returns null
//		Employee emp=session.get(Employee.class,4);
//		System.out.println(emp.getEid());
		
		
		//load() method
//		Employee e=session.load(Employee.class,1);
//		System.out.println(e.getEid());
//		System.out.println(e.getEname());
//		System.out.println(e.getAddress());
		
		//if id not present==it returns null
		//it throws ObjectNotFoundException
		Employee e=session.load(Employee.class,4);
		System.out.println(e.getEid());
		System.out.println(e.getEname());
		
	}

}
