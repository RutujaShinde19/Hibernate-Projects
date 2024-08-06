package com;



import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Application {
	
	public static void getAllEmployees(SessionFactory sf) {
		Session session=sf.openSession();
		//select * from employee
		Query<Employee> query=session.createQuery("from Employee");
		List<Employee> listOfEmployee=query.getResultList();
		System.out.println(listOfEmployee);
	}
	
	private static void getSingleEmployee(SessionFactory sf) {
		Session s = sf.openSession();
		Query<Employee> query = s.createQuery("from Employee where eid=:id1");
		query.setParameter("id1", 2);
		Employee emp = query.getSingleResult();
		System.out.println(emp);
	}
	
	private static void getMaxSalary(SessionFactory sf) {
		Session session=sf.openSession();
		Query<Double> query=session.createQuery("select Max(esalary) from Employee");
		Double maxSalary=query.getSingleResult();
		System.out.println("Maximum Salary: "+maxSalary);
	}
	
	private static void getMinimumSalary(SessionFactory sf) {
		Session session=sf.openSession();
		Query<Double> query=session.createQuery("select Min(esalary) from Employee");
		Double minSalary=query.getSingleResult();
		System.out.println("Minimum Salary: "+minSalary);
	}
	
	private static void getSecondLargestSalary(SessionFactory sf) {
		Session session=sf.openSession();
		Query<Double> query=session.createQuery("select Max(esalary) from Employee where esalary not in(Select Max(esalary) from Employee)");
		Double secondLargestSalary=query.getSingleResult();
		System.out.println(secondLargestSalary);
	}
	
	private static void getEmployeeNameAndSalary(SessionFactory sf) {
		Session session=sf.openSession();
		Query<Object[]> query=session.createQuery("select ename,esalary from Employee where eid=:id1");
		query.setParameter("id1", 3);
		Object[] emp=query.getSingleResult();
		System.out.println(Arrays.toString(emp));
		
	}
	
	private static void getEmployeeName(SessionFactory sf) {
		Session session=sf.openSession();
		Query<String> query=session.createQuery("select ename from Employee where eid=:id1");
		query.setParameter("id1", 5);
		String Ename=query.getSingleResult();
		System.out.println(Ename);
		
	}
	
	private static void getAllEmployeeName(SessionFactory sf) {
		Session session=sf.openSession();
		Query<List<String>> query=session.createQuery("select ename from Employee");
		List<List<String>> listOfNames=query.getResultList();
		System.out.println(listOfNames);
		
	}
	
	private static void getAllEmployeeSalary(SessionFactory sf) {
		Session session=sf.openSession();
		Query<List<Double>> query=session.createQuery("select esalary from Employee");
		List<List<Double>> listOfSalary=query.getResultList();
		System.out.println(listOfSalary);
		
	}

	private static void getCountOfSalary(SessionFactory sf) {
		Session session=sf.openSession();
		Query<Long> query=session.createQuery("select count(esalary) from Employee");
		Long count=query.getSingleResult();
		System.out.println(count);
	}
	
	private static void getSumOfSalary(SessionFactory sf) {
		Session session=sf.openSession();
		Query<Double> query=session.createQuery("select sum(esalary) from Employee");
		Double sum=query.getSingleResult();
		System.out.println(sum);
	}
	
	private static void getAvgOfSalary(SessionFactory sf) {
		Session session=sf.openSession();
		Query<Double> query=session.createQuery("select Avg(esalary) from Employee");
		Double avgSalary=query.getSingleResult();
		System.out.println(avgSalary);
	}
	
	
	private static void getEmployeeNameStartingWithS(SessionFactory sf) {
		Session session=sf.openSession();
		Query<String> query=session.createQuery("select ename from Employee where ename like 'S%'");
		List<String> Ename=query.getResultList();
		System.out.println(Ename);
		
	}
	
	private static void UpdateEmployeeName(SessionFactory sf) {
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("Update Employee set ename=:id1 where eid=:id2");
		query.setParameter("id1", "Rani");
		query.setParameter("id2", 2);
		query.executeUpdate();
	}
	
	private static void DeleteEmployee(SessionFactory sf) {
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("delete from Employee where eid=:id1");
		query.setParameter("id1",5);
		query.executeUpdate();
	}
	

	
	public static void main(String[] args) {
		
		   SessionFactory sf=HibernateUtil.getConnection();
//		   Session session=sf.openSession();
//		   
//		   Employee emp=new Employee();
//		   emp.setEname("Tanmay");
//		   emp.setEsalary(5000);
//		   
//		   session.save(emp);
//		   session.beginTransaction().commit();
		   
		   
		   
//		   getAllEmployees(sf);
//		   getSingleEmployee(sf);
//		   getMaxSalary(sf);
//		   getMinimumSalary(sf);
		
//		   getSecondLargestSalary(sf);
//		   getEmployeeNameAndSalary(sf);
//		   getEmployeeName(sf);
//		   getAllEmployeeName(sf);
//		   getAllEmployeeSalary(sf);
//		   getCountOfSalary(sf);
//		   getEmployeeNameStartingWithS(sf);
//		   UpdateEmployeeName(sf);
//		   DeleteEmployee(sf);
//		   getSumOfSalary(sf);
//		   getAvgOfSalary(sf);
		   
		   
		   
	}

}
