package com.hrishav.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hrishav.dto.Student;
import com.hrishav.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {

	Connection connection=null;
	
	
	@Override
	public String save(Student student){
		PreparedStatement pstmt=null;
		String status=null;
		String sqlInsertQuery="insert into student(`name`,`city`,`email`,`country`) values(?,?,?,?)";
		try {
			
			//GETTING  THE CONNECTION METHOD FROM THE JdbcUtil Class in com.hrishav.util
			connection=JdbcUtil.getJdbcConnection();
			
			
			
			if(connection!=null)
				pstmt=connection.prepareStatement(sqlInsertQuery);
			if(pstmt!=null) {
				pstmt.setString(1, student.getName());
				pstmt.setString(2, student.getCity());
				pstmt.setString(3, student.getEmail());
				pstmt.setString(4, student.getCountry());
			}
			if(pstmt!=null) {
				int rowAffected=pstmt.executeUpdate();
				if(rowAffected==1) {
					status="success";
				}else
					status="failure";
			}
			//System.out.println("Implementation class object is::"+connection.getClass().getName());
		} catch (SQLException |IOException e) {
			e.printStackTrace();
			status="failure";
		}
		return status;
	}

	@Override
	public Student findById(Integer sid) {
		PreparedStatement pstmt=null;
		String status=null;
		Student student=null;
		String sqlSelectQuery="select sid,name,email,city,country from student where sid=?";
		try {
		     //GETTING  THE CONNECTION METHOD FROM THE JdbcUtil Class in com.hrishav.util
		     connection=JdbcUtil.getJdbcConnection();
		
		
		
		    if(connection!=null)
			pstmt=connection.prepareStatement(sqlSelectQuery);
		    if(pstmt!=null) {
			    pstmt.setInt(1, sid);
		    	
		    }
		    if(pstmt!=null) {

		    	ResultSet resultset=pstmt.executeQuery();
		    	if(resultset.next()) {
		    		//copy the resultset data  to DTO and transfer it to VIEW
		    		student=new Student();
		    		
		    		//Student Object is injectected with resultset data
		    		student.setSid(resultset.getInt(1));
		    		student.setName(resultset.getString(2));
		    		student.setEmail(resultset.getString(3));
		    		student.setCity(resultset.getString(4));
		    		student.setCountry(resultset.getString(5));
		    		
		    		
		    	}
			
		   }
	    } catch (SQLException |IOException e) {
		    e.printStackTrace();
		    status="failure";
	    }
	    return student;

		

	}

	@Override
	public String updateById(Student student) {
		String sqlUpdateQuery="update student set name=?,email=?,city=?,country=? where sid=?";
		PreparedStatement pstmt=null;
		String status=null;
		
		try {
			connection=JdbcUtil.getJdbcConnection();
			if(connection!=null)
				pstmt=connection.prepareStatement(sqlUpdateQuery);
			if(pstmt!=null) {
			    pstmt.setString(1, student.getName());
			    pstmt.setString(2, student.getEmail());
			    pstmt.setString(3, student.getCity());
			    pstmt.setString(4,student.getCountry());
			    pstmt.setInt(5, student.getSid());
			}
			
			if(pstmt!=null) {
				int rowAffected=pstmt.executeUpdate();
				if(rowAffected==1) {
					status="success";
				}else {
					status="failure";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			status="faliure";
		}
				
		return status;
	}

	@Override
	public String deleteById(Integer sid) {
		PreparedStatement pstmt=null;
		String status=null;
		String sqlDeleteQuery="delete from student where sid = ?";
		try {
			Student student=findById(sid);
			if(student!=null) {
			
			//GETTING  THE CONNECTION METHOD FROM THE JdbcUtil Class in com.hrishav.util
			connection=JdbcUtil.getJdbcConnection();
			
			
			
			if(connection!=null)
				pstmt=connection.prepareStatement(sqlDeleteQuery);
			if(pstmt!=null) {

				pstmt.setInt(1, sid);
			}
			if(pstmt!=null) {
				int rowAffected=pstmt.executeUpdate();
				if(rowAffected==1) {
					status="success";
				}else
					status="not available";
			}
			}
			//System.out.println("Implementation class object is::"+connection.getClass().getName());
		} catch (SQLException |IOException e) {
			e.printStackTrace();
			status="failure";
		}
		return status;
	}

}
