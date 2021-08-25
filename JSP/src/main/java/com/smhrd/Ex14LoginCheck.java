package com.smhrd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginCheck")
public class Ex14LoginCheck extends HttpServlet {

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		/*
		1. 사용자가 입력한 id, pw를 변수에 저장
		2. 저장된 id, pw가 각각 "smart","1234"인지 판별
		   일치할 경우 : ex14_LoginS.jsp
		   불일치할 경우 : ex14_LoginF.jsp
		 */
		 String id = request.getParameter("id");
		 String pw = request.getParameter("pw");
		 
		 // 데이터베이스 연동
		 // 데이터베이스를 연결하기 위한 클래스파일을 동적 로딩
		 // 동적 로딩 : 실행할 때 로드하는 방법
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// localhost : Oracle DB가 설치된 PC의 ip주소 설정
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pass = "hr";
			
			// 데이터베이스 연결
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			if(conn != null) {
				System.out.println("DB연결성공!");
			}else {
				System.out.println("DB연결실패..");
			}
			
			// 쿼리 실행
			String sql = "select * from member where id=? and pw=?";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			// ★★★★★
			// insert, update, delete : executeUpdate() --> DB의 내용을 변경할 때
			// select : executeQuery() --> DB의 내용을 검색할 때
			ResultSet rs = psmt.executeQuery();
			
			// next() : 다음 행으로 넘어가서 데이터 존재 여부 판단 (true/false)
			if(rs.next()) { // select한 데이터가 있다면
				String getId = rs.getString(1);
				String getPw = rs.getString(2);
				String getNick = rs.getString(3);
				
			// ★★쿼링스트링 방식으로 LoginS.jsp 페이지에 닉네임 전송
			// 형식 : ?이름=값&이름=값&...
			// response.sendRedirect("ex14_LoginS.jsp?nick="+getNick);
			//	Cookie cookie = new Cookie("nick", getNick);
			//	response.addCookie(cookie);
				
			// 세션을 활용한 로그인 기능 구현(★★★)
			// 1. 세션객체 생성(★Servlet파일 내에세만)
			// 2. 세션에 닉네임을 저장
			HttpSession session = request.getSession();
			session.setAttribute("nick", getNick);
			
				response.sendRedirect("ex14_LoginS.jsp");
			}else {
				 response.sendRedirect("ex14_LoginF.jsp"); 
			}
			
		} catch (ClassNotFoundException e) {
			// 클래스를 찾지 못했을 경우 발생하는 예외처리
			e.printStackTrace();
		} catch (SQLException e) {
			response.sendRedirect("ex14_LoginF.jsp");
			e.printStackTrace();
		}
		 
//		 if(id.equals("smart") && pw.equals("1234")) {
//			 response.sendRedirect("ex_14LoginS.jsp"); 
//		 }else{
//			 response.sendRedirect("ex_14LoginF.jsp"); 
//		 }

	}

}
