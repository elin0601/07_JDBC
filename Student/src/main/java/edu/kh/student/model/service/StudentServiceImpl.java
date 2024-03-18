package edu.kh.student.model.service;

import edu.kh.student.model.dao.StudentDAO;
import edu.kh.student.model.dao.StudentDAOImpl;
import edu.kh.student.model.dto.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static edu.kh.student.common.JDBCTemplate.*;

public class StudentServiceImpl implements StudentService {

	private StudentDAO dao = new StudentDAOImpl();
	
	@Override
	public List<Student> selectAll() throws SQLException {
		Connection conn = getConnection();
		List<Student> studentList = dao.selectAll(conn);
		close(conn);
		return studentList;
	}
	
	@Override
	public int update(Student student) throws SQLException {
		
		Connection conn = getConnection();
					
		int result = 0;
		result = dao.update(conn, student);
		
		if (result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}
	
	@Override
	public Student selectStudent(String studentNo) throws SQLException {
		
		Connection conn = getConnection();
		
		Student student = dao.selectStudent(conn, studentNo);
		
		close(conn);
		
		return student;
	}
}
