<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- floor�� room�� ����� ���� ������ �� ������ ������ Ÿ������ ��ȯ�Ͽ� ���� -->
	<%
	int floor = Integer.parseInt(request.getParameter("floor"));
	int room = Integer.parseInt(request.getParameter("room"));
	
	out.print("<h1>"+floor+"��"+"</h1>");
	out.print("<h1>"+room+"��"+"</h1>");
	%>
	
	<table border='1'>
	<%
	for(int row=0; row<floor; row++) {
		out.print("<tr>");
			for(int col=0; col<room; col++) {
				out.print("<td>"+col+"</td>");
			}
		out.print("</tr>");
	}
 	%>
 	</table>
	

</body>
</html>