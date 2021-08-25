package controller_command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Command;
import model.MemberDAO;
import model.MemberDTO;

public class LoginServiceCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String moveURL = null;
		
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
			moveURL = "main.jsp";
		}else {
			System.out.println("�α��� ����..");
			moveURL = "main.jsp";
		}
		return moveURL;
	}

}
