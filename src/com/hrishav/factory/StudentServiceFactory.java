package com.hrishav.factory;

import com.hrishav.service.IStudentService;
import com.hrishav.service.StudentServiceImpl;

public class StudentServiceFactory {

	private static IStudentService studentServiceImpl;
	private StudentServiceFactory() {
		
	}
	public static IStudentService getStudentService() {
		if(studentServiceImpl==null)
		studentServiceImpl=new StudentServiceImpl();
		
		return studentServiceImpl;
		
	}
}
