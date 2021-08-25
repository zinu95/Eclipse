package controller_command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import model.MemberDAO;
import model.MemberDTO;

public class JoinServiceCon implements Command{//여기는 추상클래스로 사용안할꺼라서 abstract 쓰면 안됩니다 
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String moveURL = null;
		
		// 이메일, 패스워드, 번호, 주소를 가져오시오.
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO member = new MemberDTO(email, pw, tel, address);
		int cnt = dao.join(member);
		if(cnt > 0) {
			// request영역에 email정보를 저장
			request.setAttribute("email", "email");
			
			moveURL = "main.jsp";
			// forward방식
			RequestDispatcher dispatcher = request.getRequestDispatcher("join_success.jsp");
			// dispatcher.forward(request, response);
			
		}else {
			 //response.sendRedirect("main.jsp");
			moveURL = "main.jsp";
		}
		
		return moveURL; //리턴 값 수정
				
	}
	
}
