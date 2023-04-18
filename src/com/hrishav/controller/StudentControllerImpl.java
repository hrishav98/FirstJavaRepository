package com.hrishav.controller;

import com.hrishav.dto.Student;
import com.hrishav.factory.StudentServiceFactory;
import com.hrishav.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	IStudentService stdService;
	@Override
	public String save(Student student) {
		
		//DEPENDENCY INJECTION(BACKWARD)
		stdService=StudentServiceFactory.getStudentService();
		//System.out.println("Implementation class is::"+ stdService.getClass().getName());
		 return stdService.save(student);
		
	}

	@Override
	public Student findById(Integer sid) {
		stdService=StudentServiceFactory.getStudentService();

		return stdService.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		stdService=StudentServiceFactory.getStudentService();
		return stdService.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		stdService=StudentServiceFactory.getStudentService();
		return stdService.deleteById(sid);
	}

}
