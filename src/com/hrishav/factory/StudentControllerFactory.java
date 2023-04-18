package com.hrishav.factory;

import com.hrishav.controller.IStudentController;
import com.hrishav.controller.StudentControllerImpl;
/*The main goal of this code is to provide factory system design where we create object of the StudentControllerImpl class using the IstudentController
 * Reference and also create it under a method called getStudentController so that we can get the object the class with using the method without knowing the class
 * name which imporves the Abstraction constrant of the code
 * @author rajhr
 *
 */
public class StudentControllerFactory {

		private static IStudentController studentController=null;
		private StudentControllerFactory() {
			
		}
		public static IStudentController getStudentController() {
			if(studentController==null) 
			   studentController = new StudentControllerImpl();
			
			return studentController;
		}
}

