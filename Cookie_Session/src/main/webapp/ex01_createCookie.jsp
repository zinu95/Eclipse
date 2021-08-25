<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>Cookie 생성</h1>
	<%
		// Cookie 생성
		Cookie cookie = new Cookie("data","smart");
		
		
		//  Cookie를 사용자 PC에 저장
		response.addCookie(cookie);
	
	
	%>
	
</body>
</html>