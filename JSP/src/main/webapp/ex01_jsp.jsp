<!-- 지시자 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<!-- 선언문 : 함수 또는 메소드를 작성할 수 있는 공간으로 % 뒤에 !를 붙여줘야 한다.
			 -> Servlet으로 변한될 때 service()안에 작성 -->
<%!
	public String show() {
	return "Hello JSP!";
	}
%>


<!-- 스크립틀릿 : Java코드를 작성할 수 있는 공간 -->
<%
	String data = "Hello JSP!";
%>

<!-- 표현식 : 결과값을 웹 페이지에 출력하는 문법 -->
<h1><%=data %></h1>
<h1><%=data+5 %></h1>
<h1><%=show() %></h1> <!-- 반환값을 가지고 있는 메소드 호출! -->


</body>
</html>