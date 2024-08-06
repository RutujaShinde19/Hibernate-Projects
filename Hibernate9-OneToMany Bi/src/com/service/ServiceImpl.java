package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;
import com.model.Student;
import com.model.Subject;

public class ServiceImpl implements ServiceInterface {

	SessionFactory sf = HibernateUtil.getConnection();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addStudentWithSubjects() {
		Session session = sf.openSession();

		Student stu = new Student();
		System.out.println("Enter name of student: ");
		stu.setStuName(sc.next());

		System.out.println("How many subjects you want to add: ");
		int n = sc.nextInt();

		List<Subject> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			Subject sub = new Subject();
			System.out.println("Enter name of subject " + i + " :");
			sub.setSubName(sc.next());
			sub.setStudent(stu);

			list.add(sub);
		}
		stu.setList(list);
		session.save(stu);
		session.beginTransaction().commit();

	}

	@Override
	public void getStudentWithSubjects() {
		Session session = sf.openSession();
		System.out.println("Enter Student id: ");
		Student stu = session.get(Student.class, sc.nextInt());

		List<Subject> list = stu.getList();
		if (stu != null) {
			System.out.println("Student Id: " + stu.getStuId());
			System.out.println("Student Name: " + stu.getStuName());
			System.out.println("Subjects: ");
			for (Subject sub : list) {
				System.out.println(sub);
			}
		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void updateStudentWithSubjects() {
		Session session = sf.openSession();
		System.out.println("Enter student id: ");
		Student stu = session.get(Student.class, sc.nextInt());

		if (stu != null) {
			System.out.println("Enter new name of student: ");
			stu.setStuName(sc.next());

			List<Subject> list = stu.getList();
			System.out.println("Enter subject id: ");
			int subid = sc.nextInt();

			for (Subject sub : list) {
				if (subid == sub.getSubId()) {
					System.out.println("Enter new of subject: ");
					sub.setSubName(sc.next());
				}
			}
			session.saveOrUpdate(stu);
			session.beginTransaction().commit();
		} else {
			System.out.println("Invaild id!!!");
		}

	}

	@Override
	public void deleteStudentWithSubjects() {
		Session session = sf.openSession();
		System.out.println("Enter student id: ");
		Student stu = session.get(Student.class, sc.nextInt());
		if (stu != null) {
			session.delete(stu);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deleteSubjectWithStudent() {
		Session session = sf.openSession();
		System.out.println("Enter subject id: ");
		Subject sub = session.get(Subject.class, sc.nextInt());
		if (sub != null) {
			session.delete(sub);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deleteStudentOnly() {
		Session session = sf.openSession();
		System.out.println("Enter Student id: ");
		Student stu = session.get(Student.class, sc.nextInt());

		if (stu != null) {
			List<Subject> list = stu.getList();
			for (Subject sub : list) {
				sub.setStudent(null);
			}
			stu.setList(null);

			session.delete(stu);
			session.beginTransaction().commit();
		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deleteSubjectOnly() {
		Session session = sf.openSession();
		System.out.println("Enter Student id: ");
		Student stu = session.get(Student.class, sc.nextInt());

		if (stu != null) {
			List<Subject> list = stu.getList();
			System.out.println("Enter Subject id: ");
			int subid = sc.nextInt();

			Subject subject = null;
			for (Subject sub : list) {
				if (subid == sub.getSubId()) {
					subject = sub;
				}
			}
			list.remove(subject);
			subject.setStudent(null);
			session.delete(subject);
			session.beginTransaction().commit();
		} else {
			System.out.println("Invalid Id!!!");
		}

	}

	@Override
	public void updateStudentOnly() {
		Session session = sf.openSession();
		System.out.println("Enter student id: ");
		Student stu = session.get(Student.class, sc.nextInt());
		if (stu != null) {
			System.out.println("Enter new name of student: ");
			stu.setStuName(sc.next());
			session.saveOrUpdate(stu);
			session.beginTransaction().commit();
			
			
		} else {
			System.out.println("Invalid id!!!");
		}


	}

	@Override
	public void updateSubjectOnly() {
		Session session = sf.openSession();
		System.out.println("Enter subject id: ");
		Subject sub = session.get(Subject.class, sc.nextInt());
		if (sub != null) {
			System.out.println("Enter new name of subject: ");
			sub.setSubName(sc.next());
			session.saveOrUpdate(sub);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid id!!!");
		}


	}

}
