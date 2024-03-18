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

@WebServlet("/student/delete")
public class DeleteServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			StudentService service = new StudentServiceImpl();
			
			String studentNo = req.getParameter("studentNo");
			
			int result = service.delete(studentNo);
			
			String message;
			HttpSession session = req.getSession();
			
			if(result>0) message = "해당 학생 정보가 삭제되었습니다";
			else message = "삭제 실패";
			
			session.setAttribute("message", message);
			resp.sendRedirect("/student/selectAll");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
