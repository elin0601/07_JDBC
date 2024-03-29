package edu.kh.jdbc.model.dao;

// JDBCTemplate 클래스 내부의 static이 붙은 메서드를 모두 가져옴
// -> 가져온 메서드는 메서드 호출 시 클래스명을 작성하지 않아도 된다!!
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.model.dto.Department;

// DAO(Data access Object) : 데이터(DB, 파일) 접근하는 객체
// -> SQL 수행, 결과 반환
public class DepartmentDAO {
	
	/* JDBC 객체 참조 변수 선언 */
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;
	private Connection conn = null;

	
	/** 부서 추가(삽입) 메서드
	 * @param dept (부서코드, 부서명, 지역코드)
	 * @return result (삽입된 결과 행의 개수)
	 * @throws SQLException 
	 */
	public int insertDepartment(Department dept) throws SQLException {

		int result = 0; // 결과 저장용 변수

		try {
			// 1. Connection 얻어오기
			conn = getConnection();

			// 2. SQL 작성
			String sql = "INSERT INTO DEPARTMENT4 VALUES (?, ? ,?)";

			// 3. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 4. ?에 알맞은 값을 세팅
			pstmt.setString(1, dept.getDeptId());
			pstmt.setString(2, dept.getDeptTitle());
			pstmt.setString(3, dept.getLocationId());

			// 5. SQL 수행 후 결과 반환 받기
			result = pstmt.executeUpdate(); // DML 수행

			// 6. 트랜잭션 제어 처리
			if (result > 0)
				commit(conn);
			else
				rollback(conn);

		} finally {

			// 7. 사용한 JDBC 객체 자원 반환
			close(pstmt);
			close(conn);
		}

		return result;
	}
	
	
	/** 부서 전체 조회
	 * @return deptList (전체 부서)
	 * @throws SQLException 
	 */
	public List<Department> selectAll() throws SQLException {

		// 결과 저장용 변수 선언
		List<Department> deptList = null;

		try {
			// 1. Connection 얻어오기
			conn = getConnection();

			// 2. SQL 작성
			String sql = "SELECT * FROM DEPARTMENT4";

			// 3. Prepared 객체 생성
			pstmt = conn.prepareStatement(sql);

			// ?가 없으므로 값 세팅 패스

			// 4. SQL 실행 후 결과 반환 받기
			rs = pstmt.executeQuery();
			// executeQuery() : SELECT 수행 - ResultSet 반환
			// executeUpdate() : DML 수행 - 결과 행의 수 반환

			// 5. 결과를 저장할 List를 생성한 후
			// 한 행 씩 접근해 컬럼 값을 얻어와 List에 추가
			deptList = new ArrayList<Department>();

			while (rs.next()) {
				String deptId = rs.getString("DEPT_ID");
				String deptTitle = rs.getString("DEPT_TITLE");
				String locationId = rs.getString("LOCATION_ID");

				// Department 객체 생성
				Department dept = new Department(deptId, deptTitle, locationId);

				// deptList에 추가
				deptList.add(dept);
			}

		} finally {
			close(rs);
			close(pstmt);
			close(conn);

		}

		return deptList;
	}

	/** 부서 검색
	 * @param title
	 * @return
	 * @throws SQLException
	 */
	public List<Department> selectDepartmentTitle(String title) throws SQLException {

		// 결과 저장명 변수 선언 또는 객체 생성
		List<Department> deptList = new ArrayList<Department>();

		try {
			// 1. 커넥션 얻어오기
			conn = getConnection();

			// 2. SQL 작성
			String sql = "SELECT * FROM DEPARTMENT4 " + "WHERE DEPT_TITLE LIKE '%' || ? || '%'";

			// 3. PreparedStatement 객체 생성 + SQL 객체
			pstmt = conn.prepareStatement(sql);

			// 4. ?에 알맞은 값 대입
			pstmt.setString(1, title);

			// 5. SQL(SELECT) 수행 후 결과(ResultSet) 반환 받기
			rs = pstmt.executeQuery();

			// 6. 한 행씩 접근하며 컬럼 값 얻어오기
			// -> 얻어온 컬럼 값을 이용해 Department 객체를 생성한 후
			// -> deptList에 추가하기
			while (rs.next()) {
				String deptId = rs.getString("DEPT_ID");
				String deptTitle = rs.getString("DEPT_TITLE");
				String locationId = rs.getString("LOCATION_ID");

				Department dept = new Department(deptId, deptTitle, locationId);

				deptList.add(dept);

			}

		} finally {
			// 7. 사용한 JDBC 객체 자원 반환
			close(rs);
			close(pstmt);
			close(conn);
		}

		return deptList;
	}
	
	
	/** 부서 코드가 존재하는지 확인
	 * @param deptId
	 * @return
	 * @throws SQLException
	 */
	public int checkDepartment(String deptId) throws SQLException {
		
		int result = 0; // 결과 저장용 변수 선언
		
		try {
			
			conn = getConnection();
			
			String sql = "SELECT COUNT(*)  FROM DEPARTMENT4 "
					+ "WHERE DEPT_ID = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, deptId);
			
			rs = pstmt.executeQuery();
			
			
			// while문 보다 if 문 사용이 좀 더 효율적이다
			// (언제?? 조회 결과가 1행만 있을 경우)
			if (rs.next()) {
				
				// result = rs.getInt("COUNT(*)"); // 조회된 컬럼명
				result = rs.getInt(1); // 조회된 컬럼 순서

			}
			
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return result;
	}
	

	
	public int deleteDepartment(String deptID) throws SQLException {

		int result = 0;

		try {
			conn = getConnection();

			String sql = "DELETE FROM DEPARTMENT4 WHERE DEPT_ID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptID);

			result = pstmt.executeUpdate();
			
			if(result > 0)	commit(conn);
			else						rollback(conn);
			

		} finally {
			// 7. 사용한 JDBC 객체 자원 반환
			close(pstmt);
			close(conn);
		}

		return result;
	}

	
	/** 부서 수정
	 * @param deptTitle
	 * @param deptId
	 * @return
	 * @throws SQLException
	 */
	public int updateDepartment(String deptTitle, String deptId) throws SQLException {

		int result = 0; // 결과 저장용 변수

		try {
			conn = getConnection();

			String sql = "UPDATE DEPARTMENT4 SET DEPT_TITLE = ?  WHERE DEPT_ID = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, deptTitle);
			pstmt.setString(2, deptId);

			result = pstmt.executeUpdate();
			
			if( result > 0 ) commit(conn);
			else rollback(conn);

		} finally {
			close(pstmt);
			close(conn);

		}

		return result; // 결과 반환
	}


}
	
	

