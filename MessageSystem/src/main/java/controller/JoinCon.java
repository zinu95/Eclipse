package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;

@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// post����� �� ���ڵ� ����!
		request.setCharacterEncoding("EUC-KR");
		
		// �̸���, �н�����, ��ȣ, �ּҸ� �������ÿ�.
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO member = new MemberDTO(email, pw, tel, address);
		int cnt = dao.join(member);
		if(cnt > 0) {
			// request������ email������ ����
			request.setAttribute("email", "email");
					
			// forward���
			RequestDispatcher dispatcher = request.getRequestDispatcher("join_success.jsp");
			dispatcher.forward(request, response);
		}else {
			 response.sendRedirect("main.jsp"); 
		}
				
	}
}



