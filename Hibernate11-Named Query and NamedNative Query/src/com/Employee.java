package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	
	@NamedQuery(query="from Employee",name="getAllEmployee"),
	@NamedQuery(query = "from Employee where eid=:id1", name = "getSingleEmployee"),
	@NamedQuery(query="select ename from Employee where ename like 'r%'",name="getEmployeeNameStartingWithR"),
	@NamedQuery(query="select count(esalary) from Employee",name="getCountOfEmployee")
	
})

@NamedNativeQueries({
	@NamedNativeQuery(query="select * from employee",name="getAllEmployeeUsingSQL",resultClass = Employee.class),
	@NamedNativeQuery(query="select Max(esalary) from Employee where esalary not in(select Max(esalary) from Employee)", name = "getSecondLargestSalary"),
	@NamedNativeQuery(query="select sum(esalary) from Employee",name="getSumOfSalary")
	
})
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eid;
	
	private String ename;
	
	private double esalary;
	
	private String email;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getEsalary() {
		return esalary;
	}

	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + ", email=" + email + "]";
	}
	
	

}
