package com.hrishav.service;

import com.hrishav.dto.Student;

public interface IStudentService {

	String save(Student student);//Creating a Record
	
	Student findById(Integer sid);//Reading a Record
	
	String updateById(Student student);//Updating a Record
	
	String deleteById(Integer sid);//Deleting a Record
	
}
