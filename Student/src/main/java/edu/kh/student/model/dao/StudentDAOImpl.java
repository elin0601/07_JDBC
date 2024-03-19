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
			
			pstmt.setString(1, student.getStudentDept());
			pstmt.setString(2, student.getAddress());
			pstmt.setDouble(3, student.getPoint());
			pstmt.setString(4, student.getAbsenceDate());
			pstmt.setString(5, student.getGraduationDate());
			pstmt.setString(6, student.getStudentNo());
			
			result = pstmt.executeUpdate();
			
			
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
			pstmt.setString(1, studentNo);
			
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
		
	
	@Override
	public int delete(Connection conn, String studentNo) throws SQLException {
		int result = 0;
		
		try {
			String sql = prop.getProperty("delete");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentNo);
			
			result=pstmt.executeUpdate();
			
			
		} finally {
			
			close(pstmt);
			
		}
		return result;
	}
	
	
	@Override
	public int insert(Connection conn, Student student) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("insert");
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, student.getStudentNo());
			pstmt.setString(2, student.getStudentName());
			pstmt.setString(3, student.getStudentDept());
			pstmt.setString(4, student.getStudentSsn());
			pstmt.setString(5, student.getAddress());
			pstmt.setDouble(6, student.getPoint());
			pstmt.setString(7, student.getEntranceDate());
					
			result=pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
			
		}
		return result;
	}
	
	@Override
	public int change(Connection conn, String studentNo, String change) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("change");
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, change);
			pstmt.setString(2, studentNo);
			
			result=pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
			
		}
		return result;
	}

	
	@Override
	public int changeOther(Connection conn, String studentNo, String changeOther) throws SQLException {
		int result = 0;
		
		try {
			String sql = prop.getProperty("changeOther");
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, changeOther);
			pstmt.setString(2, studentNo);
			
			result=pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
			
		}
		return result;
	}
	
	@Override
	public List<Student> search(Connection conn, String studentNo) throws SQLException {
		
		List<Student> studentList = new ArrayList<Student>();
		
		try {
			String sql = prop.getProperty("search");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, studentNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String studentNo1= rs.getString("STUDENT_NO");
				String studentName1 = rs.getString("STUDENT_NAME");
				String studentDept = rs.getString("STUDENT_DEPT");
				String stustudentSsn = rs.getString("STUDENT_SSN");
				String address = rs.getString("ADDRESS");
				double point = rs.getDouble("POINT");
				String entranceDate = rs.getString("ENTRANCE_DATE");
				String absenceYn = rs.getString("ABSENCE_YN");
				String absenceDate = rs.getString("ABSENCE_DATE");
				String graduationYn = rs.getString("GRADUATION_YN");
				String graduationDate = rs.getString("GRADUATION_DATE");
				
				Student studnet = new Student(studentNo1, studentName1, studentDept, stustudentSsn, address, point, entranceDate, absenceYn, absenceDate, graduationYn, graduationDate);
				studentList.add(studnet);
				
			}	
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return studentList;
	}
	
	
	@Override
	public List<Student> searchName(Connection conn, String studentName) throws SQLException {

List<Student> studentList = new ArrayList<Student>();
		
		try {
			String sql = prop.getProperty("searchName");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, studentName);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String studentNo1= rs.getString("STUDENT_NO");
				String studentName1 = rs.getString("STUDENT_NAME");
				String studentDept = rs.getString("STUDENT_DEPT");
				String stustudentSsn = rs.getString("STUDENT_SSN");
				String address = rs.getString("ADDRESS");
				double point = rs.getDouble("POINT");
				String entranceDate = rs.getString("ENTRANCE_DATE");
				String absenceYn = rs.getString("ABSENCE_YN");
				String absenceDate = rs.getString("ABSENCE_DATE");
				String graduationYn = rs.getString("GRADUATION_YN");
				String graduationDate = rs.getString("GRADUATION_DATE");
				
				Student studnet = new Student(studentNo1, studentName1, studentDept, stustudentSsn, address, point, entranceDate, absenceYn, absenceDate, graduationYn, graduationDate);
				studentList.add(studnet);
				
			}	
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return studentList;
	}
}
	