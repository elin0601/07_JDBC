package edu.kh.student.controller;

import java.io.IOException;

import edu.kh.student.model.service.StudentService;
import edu.kh.student.model.service.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/change")
public class ChangeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			StudentService service = new StudentServiceImpl();
			
			String studentNo = req.getParameter("studentNo");
			String change = req.getParameter("change");
			
			int result = service.change(studentNo, change);
			
			String message;
			
			HttpSession session = req.getSession();
			
			if(result>0) message="변경성공";
			else message="실패";
			
			session.setAttribute("message", message);
			
			resp.sendRedirect("/student/update?studentNo=" + studentNo);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
