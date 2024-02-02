package studentManagement;

public class Student {
	private String StudentName;
	private int age;
	private String gender;
	private double ContactNo;
	private static String SchoolName;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String studentName, int age, String gender, double contactNo) {
		
		StudentName = studentName;
		this.age = age;
		this.gender = gender;
		ContactNo = contactNo;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getContactNo() {
		return ContactNo;
	}
	public void setContactNo(double contactNo) {
		ContactNo = contactNo;
	}
	public static String getSchoolName() {
		return SchoolName;
	}
	public static void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}
	@Override
	public String toString() {
		return "Student [StudentName=" + StudentName + ", age=" + age + ", gender=" + gender + ", ContactNo="
				+ ContactNo + "]";
	}
	
	
}
		