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
		// 1. id, pw, nick 3���� ������ ������ ����
		// 2. �����ͺ��̽��� ������ ����
		// 3. ����Ϸ� �� Ex15JoinS.jsp�� �̵�
		 String id = request.getParameter("id");
		 String pw = request.getParameter("pw");
		 String nick = request.getParameter("nick");
		 
		 // �����ͺ��̽� ����
		 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				// localhost : Oracle DB�� ��ġ�� PC�� ip�ּ� ����
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "hr";
				String pass = "hr";
				
				// �����ͺ��̽� ����
				Connection conn = DriverManager.getConnection(url, user, pass);
				
				if(conn != null) {
					System.out.println("DB���Ἲ��!");
				}else {
					System.out.println("DB�������..");
				}
				
				// ���� ����
				String sql = "insert into member values(?,?,?)";
				
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, pw);
				psmt.setString(3, nick);				
				
				// �ڡڡڡڡ�
				// insert, update, delete : executeUpdate() --> DB�� ������ ������ ��
				// select : executeQuery() --> DB�� ������ �˻��� ��
				int cnt = psmt.executeUpdate();
				
				if(cnt > 0) {
					
					 response.sendRedirect("ex15JoinS.jsp");				
				}else {
					 response.sendRedirect("ex15JoinF.jsp"); 
				}
				
			} catch (ClassNotFoundException e) {
				// Ŭ������ ã�� ������ ��� �߻��ϴ� ����ó��
				e.printStackTrace();
			} catch (SQLException e) {
				// DB���� ���� �߻��� ����Ǵ� catch��
				response.sendRedirect("ex15JoinF.jsp"); 
				
				e.printStackTrace();
			}
	}

}
