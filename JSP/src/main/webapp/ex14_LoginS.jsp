<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%--  <h1><%=request.getParameter("nick") %>�� ȯ���մϴ�.</h1> --%>
	<%
	/*	Cookie[] cookies = request.getCookies();
		
		for(int i=0; i<cookies.length; i++) {
			if(cookies[i].getName().equals("nick")) {
				out.print("<h1>"+cookies[i].getValue()+"�� ȯ���մϴ�.</h1>");
			}
		} */
		
		String nick = (String)session.getAttribute("nick");
		out.print("<h1>"+nick+"�� ȯ���մϴ�.</h1>");
	
	%>
	<a href="ex14_main.jsp">���� ȭ������</a>
</body>
</html>