package edu.kh.student.model.dao;

import static edu.kh.student.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.student.model.dto.Student;

public class StudentDAOImpl implements StudentDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public StudentDAOImpl() {
		try {		
			prop = new Properties();			
			String path = StudentDAOImpl.class.getResource("/edu/kh/student/sql/sql.xml").getPath();
			prop.loadFromXML( new FileInputStream(path));
		} catch(Exception e) {
			e.printStackTrace();			
		}
	
	}
	
	@Override
	public List<Student> selectAll(Connection conn) throws SQLException {
		
		List<Student> studentList = new ArrayList<Student>();

		try {
			String sql = prop.getProperty("selectAll");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studentDept = rs.getString("STUDENT_DEPT");
				String stustudentSsn = rs.getString("STUDENT_SSN");
				String address = rs.getString("ADDRESS");
				double point = rs.getDouble("POINT");
				String entranceDate = rs.getString("ENTRANCE_DATE");
				String absenceYn = rs.getString("ABSENCE_YN");
				String absenceDate = rs.getString("ABSENCE_DATE");
				String graduationYn = rs.getString("GRADUATION_YN");
				String graduationDate = rs.getString("GRADUATION_DATE");
				
			Student studnet = new Student(studentNo, studentName, studentDept, stustudentSsn, address, point, entranceDate, absenceYn, absenceDate, graduationYn, graduationDate);

				
				studentList.add(studnet);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return studentList;
	}
	
	
	@Override
	public int update(Connection conn, Student student) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("update");
			
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			
			pstmt.setString(1, student.getStudentDept());
			pstmt.setString(2, student.getAddress());
			pstmt.setDouble(3, student.getPoint());
			pstmt.setString(4, student.getAbsenceYn());
			pstmt.setString(5, student.getAbsenceDate());
			pstmt.setString(6, student.getGraduationYn());
			pstmt.setString(7, student.getGraduationDate());
			pstmt.setString(8, student.getStudentNo());
			
			
		} finally {
			close(pstmt);
			
		}
		
		return result;
	}
	
	
	@Override
	public Student selectStudent(Connection conn, String studentNo) throws SQLException {
		
		Student student = null;
		
		try {
			String sql = prop.getProperty("selectStudent");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "studentNo");
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				student = new Student();
				
				student.setStudentNo(rs.getString("STUDENT_NO"));
				student.setStudentName(rs.getString("STUDENT_NAME"));
				student.setStudentDept(rs.getString("STUDENT_DEPT"));
				student.setStudentSsn(rs.getString("STUDENT_SSN"));
				student.setAddress(rs.getString("ADDRESS"));
				student.setPoint(rs.getDouble("POINT"));
				student.setEntranceDate(rs.getString("ENTRANCE_DATE"));
				student.setAbsenceYn(rs.getString("ABSENCE_YN"));
				student.setAbsenceDate(rs.getString("ABSENCE_DATE"));
				student.setGraduationYn(rs.getString("GRADUATION_YN"));
				student.setGraduationDate(rs.getString("GRADUATION_DATE"));
				
			}
			
		} finally {
			close(rs);
			close(pstmt);		
		}
		return student;
	}

}
