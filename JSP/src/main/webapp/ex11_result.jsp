<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		1.ex11write.jsp���� �Է��� ������� ���ڿ��迭 itemArray������ �����Ͻÿ�. 
		2.Random��ü�� �̿��Ͽ� ���ڿ��迭�� ����� ������ �� �������� �����Ͽ� �� �������� ����Ͻÿ�.
	-->
	
	<%
		String title = request.getParameter("title");
		
		// item�� ���� ���� �Ѿ�� ���
		String[] itemArray = request.getParameterValues("item");
		
		Random rd = new Random();
		
		// item�� ������ �޶��� �� �ֱ� ������ item�� �����ϴ� itemArray�� ���̸� ������ ���
		int index = rd.nextInt(itemArray.length);	
	%>
	
	<h1><%=title %></h1>
	<%=itemArray[index] %>
	
	
</body>
</html>