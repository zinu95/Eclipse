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
		
		// 세션에 저장되어 있는 MemberDTO객체에 접근 -> 이메일 정보 가져오기
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		
		// update.jsp에서 입력한 패스워드, 번호, 주소를 가져오시오.	
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDTO member2 = new MemberDTO(member.getEmail(), pw, tel, address);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.update(member2);
		
		if(cnt > 0) {
			// 세션에도 수정된 정보를 저장
			session.setAttribute("member", member2);
			response.sendRedirect("main.jsp");
		}else {
			response.sendRedirect("update.jsp");
		}
		

		
	}

}
