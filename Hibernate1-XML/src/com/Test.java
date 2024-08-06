package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	
	// Step to create hibernate xml project
//	1) Create the java project
//	2) Add jar files for hibernate
//	3) Create the Persistent class
//	4) Create the mapping file for Persistent class
//	5) Create the Configuration file
//	6) Create the class that retrieves or stores the persistent object
//	7) Run the application

	public static void main(String[] args) {

		Configuration cnf = new Configuration().configure("hibernate.cfg.xml");

		Student s = new Student();
//		s.setId(101);
//		s.setSname("Raju");
		
		s.setId(102);
		s.setSname("Ram");


		SessionFactory sf = cnf.buildSessionFactory();
		Session session = sf.openSession();
		session.save(s);
		session.beginTransaction().commit();

	}
}

