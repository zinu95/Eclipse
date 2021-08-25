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
		1. 사용자가 입력한 id, pw를 변수에 저장
		2. 저장된 id, pw가 각각 "smart","1234"인지 판별
		   일치할 경우 : ex14_LoginS.jsp
		   불일치할 경우 : ex14_LoginF.jsp
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