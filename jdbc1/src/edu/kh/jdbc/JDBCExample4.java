package edu.kh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample4 {

	public static void main(String[] args) {
		
		// 부서명을 입력 받아 
		// 해당 부서에 근무하는 모든 사원의 
		// 사번, 이름, 부서명, 직급명을
		// 직급코드 오름차순으로 조회
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@"; // 드라이버 종류
		  String host = "localhost"; // DB 서버 컴퓨터의 IP 주소
			String port = ":1521"; // DB 서버 컴퓨터에 DB 프로그램 연결 번호
			String dbName = ":xe"; // DB 이름
			String userName = "KH_LJS"; // 사용자 계정
			String pw = "KH1234"; // 계정 비밀번호
			
			conn = DriverManager.getConnection(type + host + port + dbName, userName, pw);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("부서명 입력 : ");
			String  deptTitle = sc.next();
			System.out.println("------------------------------------------");
			
			
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE , JOB_NAME "
					+ "FROM EMPLOYEE "
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) "
					+ "NATURAL JOIN JOB "
					+ "WHERE DEPT_TITLE =  '"+ deptTitle + "' "
					+ " ORDER BY JOB_CODE";
			
			// SQL에서 문자열 값을 인식하기 위해서는
			// 리터럴 기호인 '' (홑따옴표)가 반드시 있어야 한다!!
			
			// -> '' 미작성한 경우 컬럼명으로 인식해서
			//  "부적합한 식별자" 라는 오류 발생 
			
			stmt = conn.createStatement();
			rs = stmt .executeQuery(sql);
			
			
			while(rs.next()) {
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String title = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				
				System.out.printf("%s / %s / %s / %s \n", empId, empName, title, jobName);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {

	  		if(rs != null) rs.close();
	  		if(stmt != null) stmt.close();
	  		if(conn != null) conn.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		}
	}
}
