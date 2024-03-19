package edu.kh.student.model.exception;

public class StudentInsertException extends RuntimeException{
	
	public StudentInsertException() {
		
		super("학생 추가(INSERT)중 예외 발생(제약 조건 위배)");
	}
	
	
	public StudentInsertException(String message) {
		super(message);
	}
	

}
