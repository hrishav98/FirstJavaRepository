package com.hrishav.service;

import com.hrishav.dao.IStudentDao;
import com.hrishav.dto.Student;
import com.hrishav.factory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao;
	@Override
	public String save(Student student) {
		
		//DEPENDENCY INJECTION(BACKWARD)
		studentDao=StudentDaoFactory.getStudentDao();
		//System.out.println("Implementation class is::"+studentDao.getClass().getName());
		return studentDao.save(student);
		
	}

	@Override
	public Student findById(Integer sid) {
		studentDao=StudentDaoFactory.getStudentDao();

		return studentDao.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.deleteById(sid);
	}

}
