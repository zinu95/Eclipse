<!-- ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<!-- ���� : �Լ� �Ǵ� �޼ҵ带 �ۼ��� �� �ִ� �������� % �ڿ� !�� �ٿ���� �Ѵ�.
			 -> Servlet���� ���ѵ� �� service()�ȿ� �ۼ� -->
<%!
	public String show() {
	return "Hello JSP!";
	}
%>


<!-- ��ũ��Ʋ�� : Java�ڵ带 �ۼ��� �� �ִ� ���� -->
<%
	String data = "Hello JSP!";
%>

<!-- ǥ���� : ������� �� �������� ����ϴ� ���� -->
<h1><%=data %></h1>
<h1><%=data+5 %></h1>
<h1><%=show() %></h1> <!-- ��ȯ���� ������ �ִ� �޼ҵ� ȣ��! -->


</body>
</html>