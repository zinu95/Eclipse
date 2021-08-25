package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

@WebServlet("/DeleteCon")
public class DeleteCon extends HttpServlet {

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.delete(email);
		
		if(cnt > 0) {
			System.out.println("회원 삭제 성공!");
			response.sendRedirect("select.jsp");
		}else {
			System.out.println("회원 삭제 실패!");
			response.sendRedirect("select.jsp");
		}
	}

}
