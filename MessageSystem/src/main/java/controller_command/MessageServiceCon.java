package controller_command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import model.MessageDAO;
import model.MessageDTO;

public class MessageServiceCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String moveURL = null;
		
		String sendName = request.getParameter("sendName");
		String receiveEmail = request.getParameter("receiveEmail");
		String message = request.getParameter("message");
		
		System.out.println(sendName);
		System.out.println(receiveEmail);
		System.out.println(message);
		
		MessageDTO dto = new MessageDTO(sendName, receiveEmail, message);
		
		MessageDAO dao = new MessageDAO();
		int cnt = dao.insertMessage(dto);
		
		if(cnt>0) {
			System.out.println("메시지 전송 성공");
			moveURL = "main.jsp";
		}else {
			System.out.println("메시지 전송 실패..");
			moveURL = "main.jsp";
		}
		return null;
	}
}
