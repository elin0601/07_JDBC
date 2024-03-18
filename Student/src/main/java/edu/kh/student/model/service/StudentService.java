package edu.kh.student.model.service;

import java.sql.SQLException;
import java.util.List;

import edu.kh.student.model.dto.Student;

public interface StudentService {

	List<Student> selectAll() throws SQLException;

	int update(Student student) throws SQLException;

	Student selectStudent(String studentNo) throws SQLException;
	

}
