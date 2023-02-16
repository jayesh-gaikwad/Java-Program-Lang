package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {
	
	public String addStudent(Student student);
	
	public Student searchStdudent(Integer sid);
	
	public String updateStudent(Student student);
	
	public String deleteStudent(Integer sid);

}
