<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String url = request.getParameter("url");
	
		if(url.equals("네이버")) {
			response.sendRedirect("http://www.naver.com");
		}else if(url.equals("다음")) {
			response.sendRedirect("http://www.daum.net");
		}else if(url.equals("구글")) {
			response.sendRedirect("http://www.google.com");
		}
	
	%>
</body>
</html>