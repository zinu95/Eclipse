<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<% GregorianCalendar cal = new GregorianCalendar(); %>

	<%=cal.get(Calendar.YEAR) %>��
	<%=cal.get(Calendar.MONTH)+1 %>��
	<%=cal.get(Calendar.DATE) %>��

	<!-- ��, ��, �ʸ� ����Ͻÿ�. -->
	<%=cal.get(Calendar.HOUR) %>��
	<%=cal.get(Calendar.MINUTE) %>��
	<%=cal.get(Calendar.SECOND) %>��
	
</body>
</html>