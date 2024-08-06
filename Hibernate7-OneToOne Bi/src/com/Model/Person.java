package com.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	
	private String pname;
	
	@OneToOne(cascade=CascadeType.ALL)
	private AdharCard adhar;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public AdharCard getAdhar() {
		return adhar;
	}

	public void setAdhar(AdharCard adhar) {
		this.adhar = adhar;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", adhar=" + adhar + "]";
	}

	
	
	
	

}

