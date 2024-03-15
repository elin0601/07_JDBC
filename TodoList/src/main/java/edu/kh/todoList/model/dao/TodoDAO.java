package edu.kh.todoList.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.todoList.model.dto.Todo;

public interface TodoDAO {

	/** 할 일 목록 조회
	 * @param conn
	 * @return todoList
	 * @throws SQLException
	 */
	List<Todo> selectAll(Connection conn) throws SQLException;

	
	/** 완료된 할 일 개수 조회
	 * @param conn
	 * @return completeCount
	 * @throws SQLException
	 */
	int getcompleteCount(Connection conn) throws SQLException;


	/** 할 일 추가
	 * @param conn
	 * @param todoTitle
	 * @param todoContent
	 * @return result
	 * @throws SQLException
	 */
	int addTodo(Connection conn, String todoTitle, String todoContent) throws SQLException;



}
