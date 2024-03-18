package edu.kh.student.controller;

import java.io.IOException;

import edu.kh.student.model.dto.Student;
import edu.kh.student.model.service.StudentService;
import edu.kh.student.model.service.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/update")
public class UpdateServlet extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			StudentService service = new StudentServiceImpl();
			
			String studentNo = req.getParameter("todoNo");
			
			Student student = service.selectStudent(studentNo);
			
			if( student != null) {
				req.setAttribute("student", student);
				String path = "/WEB-INF/views/update.jsp";
				req.getRequestDispatcher(path).forward(req, resp);

			} else {
				
				req.getSession().setAttribute("message", "수정 불가");
				resp.sendRedirect("/");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			StudentService service = new StudentServiceImpl();
			
			String studentNo = req.getParameter("stdentNo");
			String studentName = req.getParameter("studentName");
			String studentDept = req.getParameter("studentDept");
			String studentSsn = req.getParameter("studentSsn");
			String address = req.getParameter("address");
			double point = Double.parseDouble(req.getParameter("point"));
			String entranceDate = req.getParameter("entranceDate");
			String absenceYn = req.getParameter("absenceYn");
			String absenceDate = req.getParameter("absenceDate");
			String graduationYn = req.getParameter("graduationYn");
			String graduationDate = req.getParameter("absenceDate");
			
			Student student = new Student(studentNo, studentName, studentDept, studentSsn, address, point, entranceDate, absenceYn, absenceDate, graduationYn, graduationDate);
			
			int result = service.update(student);
		
			String path;
			String message;
			
			if(result > 0) {
				path = "/student/success";
				message = "학생 정보가 수정되었습니다."; 
			} else {
				path="/student/fail";
				message="학생 정보가 수정되지 않았습니다";
			}
			
			req.getSession().setAttribute("message", message);
			resp.sendRedirect(path);
			
			
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
	}

}
