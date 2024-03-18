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

@WebServlet("/student/changeOther")
public class ChangeOtherServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			StudentService service = new StudentServiceImpl();
			
			String studentNo = req.getParameter("studentNo");
			String changeOther = req.getParameter("changeOther");
			
			int result = service.changeOther(studentNo, changeOther);
			
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
