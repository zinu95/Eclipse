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
		// 이메일, 패스워드를 가져오시오.
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO member = dao.loginCheck(email, pw);
				
		// member객체에 값 판단
		if(member != null) { // member정보가 DB에 있다면
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			
			System.out.println("로그인 성공!");
			response.sendRedirect("main.jsp");
		}else {
			System.out.println("로그인 실패..");
			response.sendRedirect("main.jsp");
		}
			
	}
}

