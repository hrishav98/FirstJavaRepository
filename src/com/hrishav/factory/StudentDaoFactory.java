package com.hrishav.factory;

import com.hrishav.dao.IStudentDao;
import com.hrishav.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private static IStudentDao studentDao;
	private StudentDaoFactory() {
		
	}
	public static IStudentDao getStudentDao() {
		if(studentDao==null) 
		studentDao=new StudentDaoImpl();
		
		return studentDao;
		
	}
}
