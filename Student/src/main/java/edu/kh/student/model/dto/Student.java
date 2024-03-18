package edu.kh.student.model.dto;

public class Student {
	
	private String studentNo;
	private String studentName;
	private String studentDept;
	private String studentSsn;
	private String address;	
	private double point;	
	private String entranceDate;
	private String absenceYn;
	private String absenceDate;
	private String graduationYn;
	private String graduationDate;
	
	
	public Student() {}


	public Student(String studentNo, String studentName, String studentDept, String studentSsn, String address,
			double point, String entranceDate, String absenceYn, String absenceDate, String graduationYn, String graduationDate) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.studentSsn = studentSsn;
		this.address = address;
		this.point = point;
		this.entranceDate = entranceDate;
		this.absenceYn = absenceYn;
		this.absenceDate = absenceDate;
		this.graduationYn = graduationYn;
		this.graduationDate = graduationDate;
	}


	public String getStudentNo() {
		return studentNo;
	}


	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStudentDept() {
		return studentDept;
	}


	public void setStudentDept(String studentDept) {
		this.studentDept = studentDept;
	}


	public String getStudentSsn() {
		return studentSsn;
	}


	public void setStudentSsn(String studentSsn) {
		this.studentSsn = studentSsn;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getPoint() {
		return point;
	}


	public void setPoint(double point) {
		this.point = point;
	}

	public String getEntranceDate() {
		return entranceDate;
	}
	
	
	public void setEntranceDate(String entranceDate) {
		this.entranceDate = entranceDate;
	}
	

	public String getAbsenceYn() {
		return absenceYn;
	}


	public void setAbsenceYn(String absenceYn) {
		this.absenceYn = absenceYn;
	}


	public String getAbsenceDate() {
		return absenceDate;
	}


	public void setAbsenceDate(String absenceDate) {
		this.absenceDate = absenceDate;
	}


	public String getGraduationYn() {
		return graduationYn;
	}


	public void setGraduationYn(String graduationYn) {
		this.graduationYn = graduationYn;
	}


	public String getGraduationDate() {
		return graduationDate;
	}


	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}


	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", studentDept=" + studentDept
				+ ", studentSsn=" + studentSsn + ", address=" + address + ", point=" + point + ", entranceDate=" + entranceDate
				+ ", absenceYn=" + absenceYn + ", absenceDate=" + absenceDate + ", graduationYn=" + graduationYn
				+ ", graduationDate=" + graduationDate + "]";
	}



	
	
}
