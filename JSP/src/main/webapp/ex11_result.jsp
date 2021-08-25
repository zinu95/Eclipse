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
		1.ex11write.jsp에서 입력한 내용들을 문자열배열 itemArray변수에 저장하시오. 
		2.Random객체를 이용하여 문자열배열에 저장된 데이터 중 랜덤으로 접근하여 웹 페이지에 출력하시오.
	-->
	
	<%
		String title = request.getParameter("title");
		
		// item이 여러 개로 넘어올 경우
		String[] itemArray = request.getParameterValues("item");
		
		Random rd = new Random();
		
		// item의 갯수가 달라질 수 있기 때문에 item을 저장하는 itemArray의 길이를 범위로 사용
		int index = rd.nextInt(itemArray.length);	
	%>
	
	<h1><%=title %></h1>
	<%=itemArray[index] %>
	
	
</body>
</html>