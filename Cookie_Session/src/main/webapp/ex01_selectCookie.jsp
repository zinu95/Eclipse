<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Cookie ���� ��ȸ</h1>
	<%
		// request��ü�κ��� Cookie���� ��������
		Cookie[] cookies = request.getCookies();
		
		// getName() : ��Ű �̸�
		// getValue() : ��Ű ��
		for(int i=0; i<cookies.length; i++) {
			out.print(cookies[i].getName());
			out.print(":");
			out.print(cookies[i].getValue()+"<br>");
		}
	
	%>

</body>
</html>