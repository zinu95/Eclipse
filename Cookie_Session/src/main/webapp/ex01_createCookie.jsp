<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>Cookie ����</h1>
	<%
		// Cookie ����
		Cookie cookie = new Cookie("data","smart");
		
		
		//  Cookie�� ����� PC�� ����
		response.addCookie(cookie);
	
	
	%>
	
</body>
</html>