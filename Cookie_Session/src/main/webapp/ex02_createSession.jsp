<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>세션 저장</h1>
	<%
		// 세션에 정보를 저장
		// 세션은 서버에 저장되기 때문에 쿠키처럼 사용자에게 정보를 보낼 필요가 없음
		// JSP에서는 내장객체로 사용
		// 정보를 저장할 때 Object타입으로 변환하여 저장

		session.setAttribute("nick","smart");
	%>
</body>
</html>