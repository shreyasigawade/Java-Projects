package com.mini.pojo;
//alt+shift+s
public class Customer {
	int id;
	String Customer_name;
	String Contact_no;
	String Email_id;
	 String Password;
	public Customer(int id, String customer_name, String contact_no, String email_id, String password) {
		super();
		this.id = id;
		this.Customer_name = customer_name;
		this.Contact_no = contact_no;
		this.Email_id = email_id;
		this.Password = password;
		
		
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", Customer_name=" + Customer_name + ", Contact_no=" + Contact_no + ", Email_id="
				+ Email_id + ", Password=" + Password + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	public String getContact_no() {
		return Contact_no;
	}
	public void setContact_no(String contact_no) {
		Contact_no = contact_no;
	}
	public String getEmail_id() {
		return Email_id;
	}
	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	

	
}
