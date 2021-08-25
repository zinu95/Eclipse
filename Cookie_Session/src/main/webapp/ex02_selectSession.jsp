<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>세션 정보 조회</h1>
	<%
		// 세션 정보 조회
		// 다운캐스팅 : 부모클래스 --> 자식클래스 타입으로 변환
		// ★★★why? 세션영역에 저장된 정보의 타입이 Object이기 때문에
		// Object -> (String)
		String nick = (String)session.getAttribute("nick");
		out.print(nick);
		
		// 세션 유효기간 설정(초단위)
		// 세션은 유효기간의 기본값이 30분
		session.setMaxInactiveInterval(10);
	%>
</body>
</html>