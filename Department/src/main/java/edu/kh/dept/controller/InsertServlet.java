package edu.kh.dept.controller;

import java.io.IOException;

import edu.kh.dept.model.service.DepartmentService;
import edu.kh.dept.model.service.DepartmentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/department/insert")
public class InsertServlet extends HttpServlet {

	// a태그, JS(loacation.href), 주소창 직접 작성 <form method = "GET">
	// -> GET 방식 요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// JSP 요청 위임해서 부서 추가 화면 보여주기
		
		/* JSP 파일 경로는 / (webapp폴더)를 기준으로 작성 */
		String path = "/WEB-INF/views/insert.jsp";
		
		// 요청 발송자 (RequestDispatcher)를 이용해서
		// 요청 위임(forward)하기		
		req.getRequestDispatcher(path).forward(req, resp);
	
	}
	
	
	// <form method="POST">, ajax(비동기 통신 요청 POST 방식)
	// -> POST 방식 요청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			// Service 객체 생성
			DepartmentService service = new DepartmentServiceImpl();
			
			// 요청 시 전달 받은 데이터 (==Parameter) 얻어오기
			String deptId = req.getParameter("deptId"); // ("name 속성값")
			String deptTitle = req.getParameter("deptTitle"); 
			String locationId = req.getParameter("locationId"); 
			
			
			// Dynamic Web Project 기본 요청/응답 흐름
			/* 클라이언트 요청
			 * -> Controller(Servlet, 요청에 따른 응답 화면 제어) 
			 * <-> Service(비지니스 로직 처리)
			 * <-> DAO(DB 연결 객체
			 * <-> DB
			 */
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
