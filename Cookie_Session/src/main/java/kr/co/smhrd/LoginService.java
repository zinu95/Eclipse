package kr.co.smhrd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			
		// 1. id, pw ������ ������ �� ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 2. id, pw ����
		if(id.equals("smart") && pw.equals("1234")) {
			
			// 2-1. ���ǰ�ü ����
			HttpSession session = request.getSession();
			
			// 2-2. ���ǿ� id�� ����
			session.setAttribute("id", id);
			
			// 3. ex03_loginS.jsp�� �̵�
			response.sendRedirect("ex03_loginS.jsp");
		}
		
	}

}
