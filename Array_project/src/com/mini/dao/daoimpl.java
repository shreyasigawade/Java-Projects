package com.mini.dao;

import com.mini.pojo.Customer;


public class daoimpl implements Customer_dao{

	
		// TODO Auto-generated method stub
		Customer[] C1=new Customer[10];
        Customer C2;
        int index=0;
		 String Contact_no;
       
       
        	
        	
        

	@Override
	public boolean addcustomer(Customer C) {
	
		if(index<10) {
			C.setId(index);
			C1[index]=C;
			index++;
			return true;
			
	   }else {
		   return false;
	   }
		
		
	}

	@Override
	public boolean updatecustomer(Customer C) {
		// TODO Auto-generated method stub
		if(C!=null) {
			int id=C.getId();
			C1[id]=C;
			return true;
			
		}
		
		
		
		return false;
	}

	@Override
	public boolean deletecustomer(String Emailid) {
		// TODO Auto-generated method stub
		for(int i=0;i<C1.length;i++) {
			C2=C1[i];
			if(C2!=null) {
				String Email_id1=C2.getEmail_id();
				if(Email_id1.equals(Email_id1));
				C1[i]=null;
				
				return true;
				}
			
		}
		
		
				return false;
	}

	@Override
	public Customer showpprofile(String Emailid) {
		for(int i=0;i<C1.length;i++) {
		C2=C1[i];
		if(C2!=null) {
			String cust_email1=C2.getEmail_id();
			if(cust_email1.equals(Emailid)) {
				return C2;
			}
			
		}
			
		}
			

		
		return null;
	}

	@Override
	public Customer[] showallcustomer() {
		// TODO Auto-generated method stub
boolean haveMember=false;
		
		for(int i=0; i<C1.length; i++)
		{
			
			if(C1[i]!=null) 
			{
				
				haveMember=true;
				break;
			}
		}
		
		if(haveMember==true)
			return C1;
		else
			return null;
	}
	public Customer showprofilebycontact(String Contact_no) {
		for(int i=0;i<C1.length;i++) {
			C2=C1[i];
			if(C2.getContact_no() ==Contact_no) {
				return C2;
				
			}
		}
		return null;
	}
	
	public Customer showcaptchacode() {
		
		return null;
		
	}
}

	
				
	
	
	


	


