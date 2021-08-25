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
		1. ����ڰ� �Է��� id, pw�� ������ ����
		2. ����� id, pw�� ���� "smart","1234"���� �Ǻ�
		   ��ġ�� ��� : ex14_LoginS.jsp
		   ����ġ�� ��� : ex14_LoginF.jsp
		 */
		 String id = request.getParameter("id");
		 String pw = request.getParameter("pw");
		 
		 // �����ͺ��̽� ����
		 // �����ͺ��̽��� �����ϱ� ���� Ŭ���������� ���� �ε�
		 // ���� �ε� : ������ �� �ε��ϴ� ���
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
			String sql = "select * from member where id=? and pw=?";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			// �ڡڡڡڡ�
			// insert, update, delete : executeUpdate() --> DB�� ������ ������ ��
			// select : executeQuery() --> DB�� ������ �˻��� ��
			ResultSet rs = psmt.executeQuery();
			
			// next() : ���� ������ �Ѿ�� ������ ���� ���� �Ǵ� (true/false)
			if(rs.next()) { // select�� �����Ͱ� �ִٸ�
				String getId = rs.getString(1);
				String getPw = rs.getString(2);
				String getNick = rs.getString(3);
				
			// �ڡ�������Ʈ�� ������� LoginS.jsp �������� �г��� ����
			// ���� : ?�̸�=��&�̸�=��&...
			// response.sendRedirect("ex14_LoginS.jsp?nick="+getNick);
			//	Cookie cookie = new Cookie("nick", getNick);
			//	response.addCookie(cookie);
				
			// ������ Ȱ���� �α��� ��� ����(�ڡڡ�)
			// 1. ���ǰ�ü ����(��Servlet���� ��������)
			// 2. ���ǿ� �г����� ����
			HttpSession session = request.getSession();
			session.setAttribute("nick", getNick);
			
				response.sendRedirect("ex14_LoginS.jsp");
			}else {
				 response.sendRedirect("ex14_LoginF.jsp"); 
			}
			
		} catch (ClassNotFoundException e) {
			// Ŭ������ ã�� ������ ��� �߻��ϴ� ����ó��
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
