<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1><%=session.getAttribute("id") %></h1>
	환영합니다!<br>
	<a href = "ex03_main.jsp">메인페이지로</a>
</body>
</html>