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
		1. ����ڰ� �Է��� id, pw�� ������ ����
		2. ����� id, pw�� ���� "smart","1234"���� �Ǻ�
		   ��ġ�� ��� : ex14_LoginS.jsp
		   ����ġ�� ��� : ex14_LoginF.jsp
	 -->
	 <%
	 String id = request.getParameter("id");
	 String pw = request.getParameter("pw");
	 
	 if(id.equals("smart") && pw.equals("1234")) {
		 response.sendRedirect("ex_14LoginS.jsp"); 
	 }else{
		 response.sendRedirect("ex_14LoginF.jsp"); 
	 }
	 
	
	 %>
</body>
</html>