package pojo;

public class Guest {
      private String name;
      private double contactNo;
	public Guest(String name, double contactNo) {
		super();
		this.name = name;
		this.contactNo = contactNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getContactNo() {
		return contactNo;
	}
	public void setContactNo(double contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "Guest [name=" + name + ", contactNo=" + contactNo + "]";
	}
      
      
      
}
