package edu.kh.todoList.model.service;

import java.sql.SQLException;
import java.util.Map;

public interface TodoService {

	/** 할 일 목록 + 완료된 할 일 개수 조회
	 * @return map
	 * @throws SQLException
	 */
	Map<String, Object> selectAll() throws SQLException;

	/** 할 일 추가
	 * @param todoTitle
	 * @param todoContent
	 * @return
	 * @throws SQLException
	 */
	int addTodo(String todoTitle, String todoContent) throws SQLException;

}
