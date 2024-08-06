package com;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


public class Application {
	
	//NamedQueries
	private static void getAllEmployee(SessionFactory sf) {
		Session session=sf.openSession();
        Query query=session.getNamedQuery("getAllEmployee");
        System.out.println(query.getResultList());
	}
	
	private static void getSingleEmployee(SessionFactory sf) {
		Session session = sf.openSession();

		Query query = session.getNamedQuery("getSingleEmployee");
		query.setParameter("id1", 2);
		System.out.println(query.getSingleResult());

	}
	
	private static void getEmployeeNameStartingWithR(SessionFactory sf) {
		Session session=sf.openSession();
		Query query=session.getNamedQuery("getEmployeeNameStartingWithR");
		List<String> ename=query.getResultList();
		System.out.println(ename);
	}
	
	private static void getCountOfEmployee(SessionFactory sf) {
		Session session=sf.openSession();
		Query query=session.getNamedQuery("getCountOfEmployee");
		System.out.println(query.getSingleResult());
		
	}
	
	//NamedNativeQueries
	private static void getAllEmployeeUsingSQL(SessionFactory sf) {
		Session session=sf.openSession();
		Query query=session.getNamedNativeQuery("getAllEmployeeUsingSQL");
		System.out.println(query.getResultList());
		
	}
	
	private static void getSecondLargestSalary(SessionFactory sf) {
		Session session=sf.openSession();
		Query query=session.getNamedNativeQuery("getSecondLargestSalary");
		System.out.println(query.getSingleResult());
	}
	
	private static void getSumOfSalary(SessionFactory sf) {
		Session session=sf.openSession();
		Query query=session.getNamedNativeQuery("getSumOfSalary");
		System.out.println(query.getSingleResult());
		
	}
	
	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getConnection();
		Session session=sf.openSession();
////		
//		Employee e=new Employee();
//		e.setEname("pavan");
//		e.setEsalary(15000);
//		e.setEmail("pavan@com");
////		
//		Employee e1=new Employee();
//		e1.setEname("Pritesh");
//		e1.setEsalary(60000);
//		e1.setEmail("pritesh@com");
//		
//		Employee e2=new Employee();
//		e2.setEname("Chhaya");
//		e2.setEsalary(67000);
//		e2.setEmail("chhaya@com");
////		
//		List<Employee> emp=new ArrayList<>();
//		emp.add(e);
//		emp.add(e1);
//		emp.add(e2);
//		
//		for(Employee employee:emp) {
//			session.save(employee);
//		}
//		
//		session.beginTransaction().commit();
		
		
//		getAllEmployee(sf);
//		getSingleEmployee(sf);
//		getEmployeeNameStartingWithR(sf);
//		getCountOfEmployee(sf);
//		getAllEmployeeUsingSQL(sf);
//		getSecondLargestSalary(sf);
		getSumOfSalary(sf);
		
	}

}
