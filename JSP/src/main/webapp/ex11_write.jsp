<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	body{text-align: center;}
	#random_area{
		width: 500px;
		text-align: center;
		margin: 0 auto;
	}
</style>
</head>
<body>
	<!-- ex11_number.html���� �Է��� ���ڸ� ������ number������ �����Ͻÿ�. -->
	<% int number = Integer.parseInt(request.getParameter("num")); %>
	<h1>������ ������ �ۼ����ּ���!</h1>
	<form action="ex11_result.jsp">
		<fieldset id="random_area">
			<legend>���� �ۼ�</legend>
			<!-- �Է¹��� ���ڸ�ŭ input�±׸� �����Ͻÿ�. -->
			���� : <input type='text' name='title'><br>
			<%
				for(int i=0; i<number; i++) {
					out.print("������"+(i+1));
					out.print(" <input type='text' name='item'><br>");
				}
			%>
			
			<div>
				<input type="submit" value="����">
			</div>
		</fieldset>
	</form>
</body>
</html>