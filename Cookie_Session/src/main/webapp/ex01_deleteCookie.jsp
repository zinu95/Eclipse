<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Cookie 정보 삭제</h1>
	<%
		// Cookie 삭제
		Cookie cookie = new Cookie("data","1234");
		
		// Cookie의 유효기간 설정
		// 초단위로 값 설정
		// 0으로 설정 시 쿠키 정보를 삭제
		cookie.setMaxAge(0);
		
		response.addCookie(cookie);
		
	%>
</body>
</html>