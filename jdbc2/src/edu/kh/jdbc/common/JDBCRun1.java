package edu.kh.jdbc.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCRun1 {
	
	public static void main(String[] args) {
		
		// 부서 코드를 입력 받아
		// 일치하는 부서의 부서명을 수정
		
		/* 1. JDBC 객체 참조 변수 선언 */
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			 /* 2. Connection 객체 얻어오기 */
			conn = JDBCTemplate.getConnection();
			
			/* 3. SQL 작성 */
			Scanner sc = new Scanner(System.in);
			
			System.out.print("수정 할 부서 코드 : ");
			String deptId = sc.next();
						
			System.out.print("수정 할 부서 명 : ");
			String deptTitle = sc.next();
			
			String sql = "UPDATE DEPARTMENT4 SET DEPT_TITLE = ? WHERE DEPT_ID = ?";
	
			
			/* 4. PreparedStatement 객체 생성 + SQL 적재 */
			pstmt = conn.prepareStatement(sql);
			
			/* 5. ?에 알맞은 값 세팅 */
			pstmt.setString(1, deptTitle);
			pstmt.setString(2, deptId);
			
			
			/* 6. SQL 수행 후 결과 반환 받기 */
			int result = pstmt.executeUpdate(); // 수정된 행의 개수 반환
			
			/* 7. SQL 수행 결과에 따른 트랜잭션 제어 */
			if(result > 0) {
				System.out.print("수정 성공");
				JDBCTemplate.commit(conn);
				
			} else {
				System.out.print("부서코드가 일치하는 부서가 없습니다");
				JDBCTemplate.rollback(conn);
			}
			
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			/* 8. 사용한 JDBC 객체 자원 반환 */
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
			
		}
		
	}

}
