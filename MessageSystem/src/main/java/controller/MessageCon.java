package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MessageDAO;
import model.MessageDTO;

@WebServlet("/MessageCon")
public class MessageCon extends HttpServlet {

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// post방식으로 보낸 데이터 인코딩(한글데이터)
		request.setCharacterEncoding("euc-kr");
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
			response.sendRedirect("main.jsp");
		}else {
			System.out.println("메시지 전송 실패..");
			response.sendRedirect("main.jsp");
		}
		
	}

}
