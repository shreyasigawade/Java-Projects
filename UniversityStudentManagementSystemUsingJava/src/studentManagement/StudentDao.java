package studentManagement;

import java.util.List;

public interface StudentDao {
      boolean addStudent(Student student);
boolean updateStudent(Student studen);
boolean deleteStudent(String name);
   Student[] viewAllStudents();
   Student getstudentbyname(String name);
}
