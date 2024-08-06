package com.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Model.AdharCard;
import com.Model.Person;
import com.Util.HibernateUtil;

public class ServiceImpl implements ServiceInterface{

	SessionFactory sf=HibernateUtil.getConnection();
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void addPersonWithAdharCard() {
		Session session=sf.openSession();
		
		Person p=new Person();
		System.out.println("Enter name of person: ");
		p.setPname(sc.next());
		
		AdharCard a=new AdharCard();
		System.out.println("Enter name of AdharCard: ");
		a.setAname(sc.next());
		
		p.setAdhar(a);
		a.setPerson(p);
		
		session.save(p);
		session.beginTransaction().commit();
		
	}

	@Override
	public void addAdharCardWithPerson() {
        Session session=sf.openSession();
		
		Person p=new Person();
		System.out.println("Enter name of person: ");
		p.setPname(sc.next());
		
		AdharCard a=new AdharCard();
		System.out.println("Enter name of AdharCard: ");
		a.setAname(sc.next());
		
		p.setAdhar(a);
		a.setPerson(p);
		
		session.save(a);
		session.beginTransaction().commit();
		
		
	}

	@Override
	public void getPersonWithAdharCard() {
		Session session = sf.openSession();
		System.out.println("Enter the person id: ");
		Person p = session.get(Person.class, sc.nextInt());
		if (p != null) {

			System.out.println(p);

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void getAdharCardWithPerson() {
		Session session=sf.openSession();
		System.out.println("Enter the adharcard id: ");
		AdharCard a=session.get(AdharCard.class,sc.nextInt());
		if(a!=null) {
			System.out.println("Person id: "+a.getPerson().getPid());
			System.out.println("Person Name: "+a.getPerson().getPname());
			System.out.println("Adhar id: "+a.getAid());
			System.out.println("Adhar Name: "+a.getAname());
		}
		else {
			System.out.println("Invalid id!!!");
		}
		
	}

	@Override
	public void deletePersonWithAdharCard() {
		Session session=sf.openSession();
		System.out.println("Enter person id: ");
		Person p=session.get(Person.class, sc.nextInt());
		
		if(p!=null) {
			session.delete(p);
			session.beginTransaction().commit();
		}
		else {
			System.out.println("Invalid id!!!");
		}
		
	}

	@Override
	public void deleteAdharCardWithPerson() {
		Session session=sf.openSession();
		System.out.println("Enter adharcard id: ");
		AdharCard a=session.get(AdharCard.class, sc.nextInt());
		
		if(a!=null) {
			session.delete(a);
			session.beginTransaction().commit();
		}
		else {
			System.out.println("Invalid id!!!");
		}		
		
		
	}

	@Override
	public void deleteAdharCardOnly() {
		Session session=sf.openSession();
		System.out.println("Enter adharcard id: ");
		AdharCard a=session.get(AdharCard.class, sc.nextInt());
		
		if(a!=null) {
			a.getPerson().setAdhar(null);
			a.setPerson(null);
			session.delete(a);
			session.beginTransaction().commit();
		}
		else {
			System.out.println("Inavlid id!!!");
		}
		
		
	}

	@Override
	public void deletePersonOnly() {
		Session session=sf.openSession();
		System.out.println("Enter person id: ");
		Person p=session.get(Person.class, sc.nextInt());
		
		if(p!=null) {
			p.getAdhar().setPerson(null);
			p.setAdhar(null);

			session.delete(p);
			session.beginTransaction().commit();
		}
		else {
			System.out.println("Inavlid id!!!");
		}
		
	}

}
