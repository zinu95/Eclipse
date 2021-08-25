package controller_command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import model.MemberDAO;
import model.MemberDTO;

public class JoinServiceCon implements Command{//����� �߻�Ŭ������ �����Ҳ��� abstract ���� �ȵ˴ϴ� 
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String moveURL = null;
		
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
			
			moveURL = "main.jsp";
			// forward���
			RequestDispatcher dispatcher = request.getRequestDispatcher("join_success.jsp");
			// dispatcher.forward(request, response);
			
		}else {
			 //response.sendRedirect("main.jsp");
			moveURL = "main.jsp";
		}
		
		return moveURL; //���� �� ����
				
	}
	
}
