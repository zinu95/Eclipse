<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Cookie 정보 조회</h1>
	<%
		// request객체로부터 Cookie정보 가져오기
		Cookie[] cookies = request.getCookies();
		
		// getName() : 쿠키 이름
		// getValue() : 쿠키 값
		for(int i=0; i<cookies.length; i++) {
			out.print(cookies[i].getName());
			out.print(":");
			out.print(cookies[i].getValue()+"<br>");
		}
	
	%>

</body>
</html>