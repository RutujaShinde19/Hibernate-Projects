package com.controller;

import com.service.ServiceImpl;
import com.service.ServiceInterface;

public class HomeController {
	
	public static void main(String[] args) {
		ServiceInterface si=new ServiceImpl();
		
//		si.addStudentWithSubjects();
		
//		si.deleteSubjectOnly();
		
//		si.deleteStudentOnly();
		
//		si.getStudentWithSubjects();
		
//		si.updateStudentWithSubjects();
		
//		si.deleteStudentWithSubjects();
		
//		si.deleteSubjectWithStudent();
		
//		si.updateStudentOnly();
		
		si.updateSubjectOnly();
		
	}

}
