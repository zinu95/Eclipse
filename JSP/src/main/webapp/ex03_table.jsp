<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<table border = '1'>
	
	<% for(int i=1; i < 11; i++) { %>
	<tr>
		<% for(int j=1; j < 11; j++) { %>
			<td><%=j%></td>
		<% } %>
	</tr>
	<% } %>
	
	</table>
</body>
</html>