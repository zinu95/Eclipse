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

@WebServlet("/UpdateCon")
public class UpdateCon extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		// ���ǿ� ����Ǿ� �ִ� MemberDTO��ü�� ���� -> �̸��� ���� ��������
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		
		// update.jsp���� �Է��� �н�����, ��ȣ, �ּҸ� �������ÿ�.	
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDTO member2 = new MemberDTO(member.getEmail(), pw, tel, address);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.update(member2);
		
		if(cnt > 0) {
			// ���ǿ��� ������ ������ ����
			session.setAttribute("member", member2);
			response.sendRedirect("main.jsp");
		}else {
			response.sendRedirect("update.jsp");
		}
		

		
	}

}
