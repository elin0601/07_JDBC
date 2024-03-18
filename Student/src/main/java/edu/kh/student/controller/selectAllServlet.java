package edu.kh.student.controller;

import java.io.IOException;
import java.util.List;

import static edu.kh.student.common.JDBCTemplate.*;
import edu.kh.student.model.dto.Student;
import edu.kh.student.model.service.StudentService;
import edu.kh.student.model.service.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/selectAll")
public class selectAllServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {			
			StudentService service = new StudentServiceImpl();		
			List<Student> studentList = service.selectAll();		
			req.setAttribute("studentList", studentList);		
			String path = "/WEB-INF/views/selectAll.jsp";
			req.getRequestDispatcher(path).forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
