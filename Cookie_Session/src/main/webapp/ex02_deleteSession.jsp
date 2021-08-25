<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>세션 정보 삭제</h1>
	<%
	// 특정 세션정보를 삭제할 때
	// session.removeAttribute("nick");
	
	// 세션정보를 모두 삭제 -> 로그아웃기능을 구현할 때 활용!
	 session.invalidate();
	%>
	
</body>
</html>