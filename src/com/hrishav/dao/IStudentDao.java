package com.hrishav.dao;

import com.hrishav.dto.Student;

public interface IStudentDao {

	String save(Student student);//Creating a Record
	
	Student findById(Integer sid);//Reading a Record
	
	String updateById(Student student);//Updating a Record
	
	String deleteById(Integer sid);//Deleting a Record
	
}
