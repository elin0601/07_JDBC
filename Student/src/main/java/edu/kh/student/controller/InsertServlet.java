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
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/insert")
public class InsertServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/insert.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			StudentService service = new StudentServiceImpl();
			
			String studentNo = req.getParameter("studentNo");
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
			
			int result = service.insert(student);
			
			String message;
			
			HttpSession session = req.getSession();
			
			if(result > 0) message = "학생 정보가 추가되었습니다.";
			else message = "추가 실패..";
			
			session.setAttribute("message", message);
			
			resp.sendRedirect("/student/selectAll");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	

}
