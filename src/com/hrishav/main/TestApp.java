package com.hrishav.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.hrishav.controller.IStudentController;
import com.hrishav.dto.Student;
import com.hrishav.factory.StudentControllerFactory;

public class TestApp {

	public static void main(String[] args) {
		IStudentController studentController=null;
		String status=null,name=null,city=null,country=null,email=null;
		Integer id=null;
	    Student studentRecord=null;
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		//Creating a menu
		try {
			while(true) {
				System.out.println("1. CREATE");
				System.out.println("2. READ");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.println("YOUR OPTION :: [1,2,3,4,5] ");
				Integer option=Integer.parseInt(br.readLine()) ;
				
				//DEPENDENCY INJECTION(BACKWARD)
				//Creating the class of the studentControllerImpl using the factory design pattern 
				studentController=StudentControllerFactory.getStudentController();
				
				switch(option) {
				case 1:
					System.out.println("Enter the name:: ");
					name=br.readLine();
					System.out.println("Enter the city:: ");
					city=br.readLine();
					System.out.println("Enter the email:: ");
					email=br.readLine();
					System.out.println("Enter the country:: ");
					 country=br.readLine();
					
					
					
					//Creating	 the class for the Student Class for Data Transfer Object
					Student student=new Student();
					student.setName(name);
					student.setCity(city);
					student.setEmail(email);
					student.getCountry();
					
					//Sending Dependency Injection(Object) Forward
					status=studentController.save(student);
					if(status.equalsIgnoreCase("success")) {
						System.out.println("Record inserted successfully...");
					}else if(status.equalsIgnoreCase("faliure")) {
						System.out.println("Record insertion failed");
						
					}else
						System.out.println("Some problem occured...");
					
					break;
					
				case 2:
					System.out.println("Enter the id:: ");
					id=Integer.parseInt(br.readLine());
					
					//Sending Dependency Injection(Object) Forward
					studentRecord=studentController.findById(id);
					if(studentRecord!=null) {
					     System.out.println(studentRecord);
					}
					else
						System.out.println("Record not available for the given id ::"+id);
					
					
					break;
                case 3:
                	System.out.println("Enter the id of the record to be updated::");
                	id=Integer.parseInt(br.readLine());
                	studentRecord=studentController.findById(id);
                	if(studentRecord!=null) {
                		Student newStudent=new Student();
                		newStudent.setSid(id);
                		
                		System.out.println("StudentName ::[Old name is ::"+ studentRecord.getName()+"]:  ");
                		String newName=br.readLine();
                		if(newName==null|| newName.equals("")) {
                			newStudent.setName(studentRecord.getName());
                		}else {
                			newStudent.setName(newName);
                		}
                		System.out.println("StudentEmail ::[Old name is ::"+ studentRecord.getEmail()+"]:  ");
                		String newEmail=br.readLine();
                		if(newEmail==null|| newEmail.equals("")) {
                			newStudent.setEmail(studentRecord.getEmail());
                		}else {
                			newStudent.setEmail(newEmail);
                		}
                		System.out.print("StudentCity ::[Old City is :: " + studentRecord.getCity() + "]:  ");
						String newCity = br.readLine();
						if (newCity == null || newCity.equals("")) {
							newStudent.setCity(studentRecord.getCity());
						} else {
							newStudent.setCity(newCity);
						}
						System.out.print("StudentCountry ::[Old Country is :: " + studentRecord.getCountry() + "]:  ");
						String newCountry = br.readLine();
						if (newCountry == null || newCountry.equals("")) {
							newStudent.setCountry(studentRecord.getCountry());
						} else {
							newStudent.setCountry(newCountry);
						}
						
						status=studentController.updateById(newStudent);
						if(status.equalsIgnoreCase("success")) {
							System.out.println("Record updated successfuly....");
						}else if(status.equalsIgnoreCase("faliure")){
							System.out.println("Record updation failed.....");
						}else {
							System.out.println("Some problem occured");
						}
							
                		
                	}else
                		System.out.println("Record not available for the given id::"+id);
					break;	

                case 4:
					System.out.println("Enter the id:: ");
					id=Integer.parseInt(br.readLine());
					status=studentController.deleteById(id);
					if(status.equalsIgnoreCase("success")) {
						System.out.println("Record deleted successfully...");
					}else if(status.equalsIgnoreCase("faliure")) {
						System.out.println("Record deletion failed");
						
					}else
						System.out.println("Some problem occured...");
                	
					break;	

                case 5:
                	System.out.println("Thanks for using the application");
                	System.exit(0);
					
					break;	
				default:
					System.out.println("Please enter the options like 1,2,3,4,5 for operation");
					break;
				}
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
