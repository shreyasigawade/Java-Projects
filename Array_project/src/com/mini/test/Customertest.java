package com.mini.test;
import java.util.Scanner;
import java.util.Random;


import com.mini.dao.daoimpl;
import com.mini.pojo.Customer;


public class Customertest{
	public static void main(String args[]) {

		Scanner sc=new Scanner(System.in);
		boolean exit=false;
		daoimpl custimpl=new daoimpl();
		int id;
		boolean flag;
		String Customer_name;
		String Contact_no;
		String Email_id ;
	    String Password;
		Customer  c;
		int option;
		int length=6;
		
		String characters="abcdefghijklmnopqrstuvwxyz";
		System.out.println("Welcome to website");
	    do {
	    	
			System.out.println("How do you want to proceed? Please input number according to below given options");
			System.out.println("\n1. Register");
			System.out.println("2. Update the profile");
			System.out.println("3. Delete profile");
			System.out.println("4. Show all profile");
			
			System.out.println("5. Exit");
			System.out.println("6.Show profile by contact");
			
			
			option = sc.nextInt();
			sc.nextLine();
			switch (option) {
			case 1: System.out.println("Enter name: ...");
			Customer_name=sc.nextLine();
			sc.nextLine();
			
			System.out.println("Enter contact no...");
			Contact_no=sc.nextLine();
			
			
			
			System.out.println("Enter emailid...");
			Email_id=sc.nextLine();
			
			System.out.println("Enter password:....");
			Password=sc.nextLine();			
			
			c=new Customer();
			c.setCustomer_name(Customer_name);
			c.setContact_no(Contact_no);
			c.setEmail_id(Email_id);
			c.setPassword(Password);
			
			flag= custimpl.addcustomer(c);
			if(flag==true) 
				System.out.println("Customer registered successfully");
				else 
					System.out.println("Error in adding Customer");
			
			break;
			case 2:
				System.out.println("Enter emailid  which you wants to update:");
				Email_id=sc.nextLine();
				
				c=custimpl.showpprofile(Email_id);
				if(c==null) 
					System.out.println("No profile found");
				
				else {
					
					System.out.println("Your profile");
					System.out.println("\n "+c);
					System.out.println("Are you sure you want to update profile?Input y for yes and n for no");
					char choice=sc.next().charAt(0);
					sc.nextLine();
					if(choice=='y') {
						System.out.println("enter customer name");
						Customer_name=sc.nextLine();
						System.out.println("enter contact no");
						Contact_no=sc.nextLine();
						System.out.println("enter email id");
						Email_id=sc.nextLine();
						System.out.println("Enter password");
						Password=sc.nextLine();
						sc.nextLine();
						c.setContact_no(Contact_no);
						c.setCustomer_name(Customer_name);
						c.setEmail_id(Email_id);
						c.setPassword(Password);
						
						flag= custimpl.updatecustomer(c);
						if(flag) 
							System.out.println("Customer updated successfully");
						else
							System.out.println("ERROR while updating your profile!! please try again later");
					}
					else if(choice=='n'){
						System.out.println("Thank you for being an esteemed member of you website");
						
						
					}
					else
						System.out.println("input y for yes and n for no in small letters");
						
				}
			
					break;
			case 3:
				System.out.println("Please Enter the emailid which needs to be deleted");
				Email_id=sc.nextLine();
				c=custimpl.showpprofile(Email_id);
				if(c==null) 
					System.out.println("Sorry no such prfile with this email present in our database");
					else {
						System.out.println("your profile....");
						System.out.println("\n"+c);
						System.out.println("Are you sure you want to delete this profile? input y for yes and n for no" );
						char choice=sc.next().charAt(0);
						sc.nextLine();
						if(choice=='y') {
							System.out.println("enter customer name");
							Customer_name=sc.nextLine();
							System.out.println("enter contact no");
							Contact_no=sc.nextLine();
							System.out.println("enter email id");
							Email_id=sc.nextLine();
							System.out.println("Enter password");
							Password=sc.nextLine();
							c.setContact_no(Contact_no);
							c.setCustomer_name(Customer_name);
							c.setEmail_id(Email_id);
							c.setPassword(Password);
							
							flag= custimpl.deletecustomer(Email_id);
							if(flag) 
								System.out.println("Customer deleted successfully");
							else
								System.out.println("ERROR while deleting your profile!! please try again later");
						}
						else if(choice=='n') {
							System.out.println("Thank you for being an esteemed member of our website");
							
						}else
							System.out.println("input y for yes and n for no");
						
						
						
						}
				break;
			case 4:
            Customer[] clist=custimpl.showallcustomer();
				
				if(clist==null) {
					
					System.out.println("Sorry our database is empty!! Customers need to register first!!");
				}
					
				else {
					
					
					for(int i=0; i<clist.length; i++) {
						
						if(clist[i]!=null)
						System.out.println(clist[i]);
						
					}
				}
			
			break;
			
			
				
				
			
			case 5:
				System.out.println("Do you want to exit? input y for yes and n for no");
				char choice=sc.next().charAt(0);
				sc.nextLine();
				if(choice=='y') {
					System.out.println("Thank you! visit us again soon");
					exit=true;
				
				}else
					System.out.println("Thank you for staying with us");
				break;
				default:System.out.println("please give input in numbers between 1 to 6 as given in the menu");
				
				
				
				case 6:
					System.out.println("Do you want to show a profile by contact? (y/n)");
				    char choice1 = sc.next().charAt(0);
				    if (choice1 == 'y') {
				        System.out.println("Enter the contact number:");
				        String Contact_no1= sc.nextLine();
				      c = custimpl.showprofilebycontact(Contact_no1);
				        if (c != null) {
				            System.out.println("Profile found:");
				            System.out.println("Customer Name: " + c.getCustomer_name());
				            System.out.println("Contact Number: " + c.getContact_no());
				            System.out.println("Email ID: " + c.getEmail_id());
				            System.out.println("Password: " + c.getPassword());
				        } else {
				            System.out.println("No profile found with the provided contact number.");
				        }
				    }
				    break;
				







					
				
				
			/*case 7:
					System.out.println("captcha code :");
					Random random=new Random();
					captcha1 = custimpl.captchacode();
					
					
					char[] captcha1=new char[length];
					for(int i=0;i<length;i++) {
						int index=random.nextInt(characters.length());
						captcha1[i]=characters.charAt(index);
						
						
					}
					
					System.out.println( captcha1.toString());
					System.out.println("enter a given captcha code");
					String x=sc.nextLine();
					if(captcha1.toString()!=x) {
						System.out.println("error captcha code ...please try again");
						
					}else {
						System.out.println("successfull.");
					}
			*/
				
				
				}
						
				
			
			}
			
	    	
	    while(exit==false);{
	    	
	    }
		
	}
	
}


