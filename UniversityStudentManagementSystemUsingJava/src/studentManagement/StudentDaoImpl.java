package studentManagement;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
       Student arr[]=new Student[10];
       int index=0;
       
	@Override
	public boolean addStudent(Student student) {
		if(index<arr.length) {
			arr[index++]=student;
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStudent(Student student) {
		for(int i=0;i<index;i++) {
			if(arr[i]!=null && arr[i].getStudentName().equals(student.getStudentName())) {
				arr[index]=student;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteStudent(String name) {
		
		for(int i=0;i<index;i++) {
			if(arr[i]!=null && arr[i].getStudentName().equals(name)) {
				arr[i]=null;
				return true;
			}
			}
		return false;
	}

	@Override
	public Student[] viewAllStudents() {
		
		
		return arr;
		
	}

	@Override
	public Student getstudentbyname(String name) {
		Student students=null;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=null && arr[i].getStudentName().equals(name)) {
				return arr[i];
			}
		}
		return null;
	}

	

}
