<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	/*	Cookie cookie = new Cookie("data","1234");
		cookie.setMaxAge(0);
		response.addCookie(cookie); */
		
		session.invalidate();

		// �α׾ƿ��� ����� �� ex14_Login.html�� �̵�
		response.sendRedirect("ex14_Login.html");
	%>
</body>
</html>