package studentManagement;

import java.util.List;
import java.util.Scanner;


public class StudentTest {

	public static void main(String[] args) {
		 String StudentName;
		 int age;
		 String gender;
		 double ContactNo;
		 String SchoolName;
		
		 System.out.println("Select operation: ");
		
		 int choice;
	
		 
		  try { 
			  Scanner sc =new Scanner(System.in);
				 Student student;
				 StudentDaoImpl sd=new StudentDaoImpl();
		  
		 do {
			 System.out.println("1)Add student \n2)Update Student \n3)delete");
			 System.out.println("Enter your choice: ");
 			  choice=Integer.parseInt(sc.nextLine());
			 switch(choice) {
			 case 1:
				 System.out.println("Do you wants to add student info? (yes/no)");
				 String response=sc.nextLine().toLowerCase();
				 if(response.equals("yes")) {
					 System.out.println("Enter Student name: ");
					 StudentName=sc.nextLine();
					 
					 System.out.println("Enter Student age: ");
					 age=Integer.parseInt(sc.nextLine());
					 
					 System.out.println("Enter Student gender: ");
					 gender=sc.nextLine();
					 
					 System.out.println("Enter Student ContactNo: ");
					 ContactNo=Double.parseDouble(sc.nextLine());
					 
					 System.out.println("Enter Student school name: ");
					 SchoolName=sc.nextLine();
					 
					 student=new Student(StudentName,age,gender,ContactNo);
					 
					 boolean addstudent=sd.addStudent(student);
					 if(addstudent) {
						 System.out.println("Student info added successfully");
					 }else {
						 System.out.println("error while adding..");
					 }
					 
				 }else if(response.equals("no")) {
					 System.out.println("No change");
					 
				 }else {
					 System.out.println("Incorect response ...");
				 }
				 break;
			 case 2:
				 System.out.println("Do you wants to update student info? (yes/no)");
				  response=sc.nextLine().toLowerCase();
				 if(response.equals("yes")) {
					 System.out.println("Enter Student name to update: ");
					 StudentName=sc.nextLine();
					 
				        // Get the updated information for the student
				        System.out.println("Enter updated Student name: ");
				        String updatedName = sc.nextLine();
				        System.out.println("Enter updated Student age: ");
				        int updatedAge = Integer.parseInt(sc.nextLine());
				        System.out.println("Enter updated Student gender: ");
				        String updatedGender = sc.nextLine();
				        System.out.println("Enter updated Student contact: ");
				        Double updatedContact = Double.parseDouble(sc.nextLine());
				        
				        // Create a new Student object with updated information
				        Student updatedStudent = new Student(updatedName, updatedAge, updatedGender,updatedContact);
				        boolean isUpdated = sd.updateStudent(updatedStudent);
				        if (isUpdated) {
				            System.out.println("Student information updated successfully!");
				        } else {
				            System.out.println("Failed to update student information.");
				        }
				    } else if (response.equals("no")) {
				        System.out.println("Update operation cancelled.");
				    } else {
				        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
				    
				 }
				 break;
			 case 3:
				  System.out.println("Enter name to delete: ");
                  StudentName = sc.nextLine();
                  boolean deleteStudent = sd.deleteStudent(StudentName);
                  if (deleteStudent) {
                      System.out.println("Student deleted successfully!");
                  } else {
                      System.out.println("Student not found or deletion failed.");
                  }
                  break;
			 case 4:
				 
				 Student[] slist=sd.viewAllStudents();
 				  if(slist!=null) {
 					  for(Student books1:slist) {
 						  if(books1!=null) {
 							  System.out.println(books1);
 							  
 						  }
 					  }
 				  }
 			   break;
			 case 5:
				  System.out.println("Enter name to delete: ");
                  StudentName = sc.nextLine();
                  student=sd.getstudentbyname(StudentName);
                  if(student!=null) {
                	  System.out.println(student.getAge());
                	  System.out.println(student.getContactNo());
                	  System.out.println(student.getGender());
                	
                  }
                  break;
			 default:
                 System.out.println("Invalid choice!");
                 break;
 				  
   			
				}
		        	
	    		     
			  }while(choice!=5);}
     	   catch (Exception e) {
     		    e.printStackTrace();
		 

	}
     	   }
       }
