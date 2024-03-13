package edu.kh.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.model.dto.Review;
import edu.kh.model.service.ReviewService;
import edu.kh.model.service.ReviewServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/department/selectAll")
public class SelectAllServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			ReviewService service = new ReviewServiceImpl();
			
			List<Review> rvList = service.selectAll();
			
			req.setAttribute("rvList", rvList);
			
			String path = "/WEB-INF/views/selectAll.jsp";
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
