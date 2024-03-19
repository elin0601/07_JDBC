package edu.kh.student.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.student.model.dto.Student;

public interface StudentDAO {

	List<Student> selectAll(Connection conn) throws SQLException;

	int update(Connection conn, Student student) throws SQLException;

	Student selectStudent(Connection conn, String studentNo) throws SQLException;

	int delete(Connection conn, String studentNo) throws SQLException;

	int insert(Connection conn, Student student) throws   SQLException;

	int change(Connection conn, String studentNo, String change) throws SQLException;

	int changeOther(Connection conn, String studentNo, String changeOther) throws SQLException;

	List<Student> search(Connection conn, String studentNo) throws SQLException;

}
