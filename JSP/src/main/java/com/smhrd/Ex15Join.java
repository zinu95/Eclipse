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

@WebServlet("/Join")
public class Ex15Join extends HttpServlet {

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 1. id, pw, nick 3개의 정보를 변수에 저장
		// 2. 데이터베이스에 정보를 저장
		// 3. 저장완료 후 Ex15JoinS.jsp로 이동
		 String id = request.getParameter("id");
		 String pw = request.getParameter("pw");
		 String nick = request.getParameter("nick");
		 
		 // 데이터베이스 연동
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
				String sql = "insert into member values(?,?,?)";
				
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, pw);
				psmt.setString(3, nick);				
				
				// ★★★★★
				// insert, update, delete : executeUpdate() --> DB의 내용을 변경할 때
				// select : executeQuery() --> DB의 내용을 검색할 때
				int cnt = psmt.executeUpdate();
				
				if(cnt > 0) {
					
					 response.sendRedirect("ex15JoinS.jsp");				
				}else {
					 response.sendRedirect("ex15JoinF.jsp"); 
				}
				
			} catch (ClassNotFoundException e) {
				// 클래스를 찾지 못했을 경우 발생하는 예외처리
				e.printStackTrace();
			} catch (SQLException e) {
				// DB관련 오류 발생시 실행되는 catch문
				response.sendRedirect("ex15JoinF.jsp"); 
				
				e.printStackTrace();
			}
	}

}
