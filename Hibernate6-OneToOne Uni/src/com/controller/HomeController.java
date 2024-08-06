package com.controller;

import com.service.Services;
import com.service.serviceImpl;

public class HomeController {

	public static void main(String[] args) {
		Services s=new serviceImpl();
		
//		s.addPersonWithMobile();
		
//		s.getPersonDataWithMobile();
		
//		s.updatePersonAndMobileData();
		
//		s.deletePersonWithMobile();
		
//		s.deleteMobileOnly();
		
//		s.deletePersonOnly();
		
		s.addExistingMobileToExistingPerson();
	}
}
