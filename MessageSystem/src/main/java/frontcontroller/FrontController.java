package frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import controller_command.JoinServiceCon;
import controller_command.LoginServiceCon;
import controller_command.MessageServiceCon;

@WebServlet("*.do") // ���⼭ COMMAND ������ �����Ҷ��� '/' ��ȣ�� �����ʾƿ�~��
public class FrontController extends HttpServlet {

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// �ѱ� ���ڵ�
		request.setCharacterEncoding("euc-kr");
		
		String reqURI = request.getRequestURI();
		System.out.println("��ûURI : "+reqURI);
		
		String path = request.getContextPath();
		System.out.println("������Ʈ �̸� : "+path);
		
		String resultURI = reqURI.substring(path.length()+1);
		System.out.println("��û : "+resultURI);
		
		Command command = null;
		
		if(resultURI.equals("LoginServiceCon.do")) {
			command = new LoginServiceCon(); // ��ĳ����(�ڵ�����ȯ)
		}else if(resultURI.equals("JoinServiceCon.do")){
			command = new JoinServiceCon();
		}else if(resultURI.equals("MessageCon.do")) {
			command = new MessageServiceCon();
		}
		
		
		
		String moveURL = command.execute(request, response);
		response.sendRedirect(moveURL);
	}

}
