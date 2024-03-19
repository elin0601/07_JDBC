package edu.kh.student.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.student.model.dto.Student;
import edu.kh.student.model.service.StudentService;
import edu.kh.student.model.service.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/search")
public class SearchServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String studentNo = req.getParameter("studentNo");
		StudentService service = new StudentServiceImpl();
		try {
		
			List<Student> studentList = service.search(studentNo);
			
			if(studentList.isEmpty()) {
				req.getSession().setAttribute("message", "조회된 학생이 없습니다.");
				resp.sendRedirect("/student/selectAll");
			} else {
				req.setAttribute("studentList", studentList);
				
				String path = "/WEB-INF/views/search.jsp";
				
				req.getRequestDispatcher(path).forward(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
