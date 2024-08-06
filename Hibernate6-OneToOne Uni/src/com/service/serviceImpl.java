package com.service;

import java.util.Scanner;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;
import com.model.Mobile;
import com.model.Person;

public class serviceImpl implements Services {

	Scanner sc = new Scanner(System.in);
	SessionFactory sf = HibernateUtil.getConnection();

	@Override
	public void addPersonWithMobile() {
		Session session = sf.openSession();
		Person p = new Person();
		System.out.println("Enter name of Person: ");
		p.setPname(sc.next());

		Mobile m = new Mobile();
		System.out.println("Enter name of Mobile: ");
		m.setMname(sc.next());

		p.setMobile(m);

		session.save(p);
		session.beginTransaction().commit();
		System.out.println("Person and Mobile added successfully...");

	}

	@Override
	public void getPersonDataWithMobile() {
		Session session = sf.openSession();
		System.out.println("Enter Person id: ");
		int pid = sc.nextInt();
		Person p = session.get(Person.class, pid);

		if (p != null) {
			System.out.println(p);
		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void updatePersonAndMobileData() {
		Session session = sf.openSession();
		System.out.println("Enter Person id: ");
		int pid = sc.nextInt();

		Person p = session.get(Person.class, pid);

		if (p != null) {
			System.out.println("Enter new name of Person: ");
			p.setPname(sc.next());

			System.out.println("Enter new name of Mobile: ");
			p.getMobile().setMname(sc.next());

			session.update(p);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid Id!!!");
		}

	}

	@Override
	public void deletePersonWithMobile() {
		Session session=sf.openSession();
		
		System.out.println("Enter Person id: ");
		Person p=session.get(Person.class, sc.nextInt());
		
		if(p!=null) {
			session.delete(p);
			session.beginTransaction().commit();
		}
		else {
			System.out.println("Invalid Id!!!");
		}

	}

	@Override
	public void deleteMobileOnly() {
		Session session=sf.openSession();
		System.out.println("Enter Person id: ");
		int pid=sc.nextInt();
		Person p=session.get(Person.class, pid);
		
		if(p!=null) {
			Mobile m=p.getMobile();
			p.setMobile(null);
			session.delete(m);
			session.beginTransaction().commit();
			
		}
		else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deletePersonOnly() {
		Session session=sf.openSession();
		System.out.println("Enter Person id: ");
		int pid=sc.nextInt();
		Person p=session.get(Person.class,pid);
		if(p!=null) {
			Mobile m=p.getMobile();
			p.setMobile(null);
			session.delete(p);
			session.beginTransaction().commit();
			
		}
		else {
			System.out.println("Invalid Id!!!");
		}

	}

	@Override
	public void addExistingMobileToExistingPerson() {
		
		Session session=sf.openSession();
		System.out.println("Enter Person id: ");
		int pid=sc.nextInt();
		
		Person p=session.get(Person.class, pid);
		
		if(p!=null) {
		
			System.out.println("Enter Mobile id: ");
			int mid=sc.nextInt();
			Mobile m=session.get(Mobile.class, mid);
			
			if(p!=null && p.getMobile()==null) {
			p.setMobile(m);	
	         session.update(p);
	         session.beginTransaction().commit();
		}
		}
		else {
			System.out.println("Invalid id!!!");
		}
		
	}

}
