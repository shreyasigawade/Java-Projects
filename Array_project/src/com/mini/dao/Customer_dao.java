package com.mini.dao;

import com.mini.pojo.Customer;

public interface Customer_dao {
          public boolean addcustomer(Customer C);
          public boolean updatecustomer(Customer C);
          public boolean deletecustomer(String Email_id);
          public Customer showpprofile(String Email_id);
          public Customer showprofilebycontact(String Contact_no);
          public  Customer showcaptchacode();
          
          public Customer[] showallcustomer();
		
          
          
      
          
       
}
