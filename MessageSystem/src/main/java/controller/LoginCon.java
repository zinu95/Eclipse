package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberDTO;

@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// �̸���, �н����带 �������ÿ�.
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO member = dao.loginCheck(email, pw);
				
		// member��ü�� �� �Ǵ�
		if(member != null) { // member������ DB�� �ִٸ�
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			
			System.out.println("�α��� ����!");
			response.sendRedirect("main.jsp");
		}else {
			System.out.println("�α��� ����..");
			response.sendRedirect("main.jsp");
		}
			
	}
}

