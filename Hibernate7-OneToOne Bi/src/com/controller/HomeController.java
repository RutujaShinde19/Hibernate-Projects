package com.controller;

import com.service.ServiceImpl;
import com.service.ServiceInterface;

public class HomeController {
	
	public static void main(String[] args) {
		
		ServiceInterface si=new ServiceImpl();
		
//		si.addPersonWithAdharCard();
		
//		si.getPersonWithAdharCard();
		
//		si.getAdharCardWithPerson();
		
//		si.deletePersonWithAdharCard();
		
//		si.deleteAdharCardOnly();
		
		si.deletePersonOnly();
		
		
	}

}
