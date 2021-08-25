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
	<!-- ex11_number.html에서 입력한 숫자를 정수형 number변수에 저장하시오. -->
	<% int number = Integer.parseInt(request.getParameter("num")); %>
	<h1>주제와 내용을 작성해주세요!</h1>
	<form action="ex11_result.jsp">
		<fieldset id="random_area">
			<legend>내용 작성</legend>
			<!-- 입력받은 숫자만큼 input태그를 생성하시오. -->
			주제 : <input type='text' name='title'><br>
			<%
				for(int i=0; i<number; i++) {
					out.print("아이템"+(i+1));
					out.print(" <input type='text' name='item'><br>");
				}
			%>
			
			<div>
				<input type="submit" value="시작">
			</div>
		</fieldset>
	</form>
</body>
</html>