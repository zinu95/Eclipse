<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% if(session.getAttribute("id") != null) { %>
	<%=session.getAttribute("id") %>�� �α��� �� <br>
	<!--
		1. �α׾ƿ� ��ũ ����
		2. Ŭ�� �� ex03_logout.jsp�� �̵�
		3. ex03_logout.jsp���� ������������
		4. ex03_main.jsp�� �̵�
			 -->
		<a href = "ex03_logout.jsp">�α׾ƿ�</a>
	<% }else{ %>
	<form action = "LoginService" method = "post">
		ID : <input type = "text" name = "id"><br>
		PW : <input type = "password" name = "pw"><br>
		<input type = "submit" value = "�α���">
	</form>
	<% } %>
</body>
</html>