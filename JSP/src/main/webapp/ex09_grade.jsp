<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	tr{
		height: 40px;
		text-align: center;
	}
	table{
		margin: 0 auto;
	}
</style>
</head>
<body>
	<%
		//이름, java, web, jot, android 점수를 변수에 저장
		String name = request.getParameter("name");
		int java = Integer.parseInt(request.getParameter("java"));
		int web = Integer.parseInt(request.getParameter("web"));
		int iot = Integer.parseInt(request.getParameter("iot"));
		int android = Integer.parseInt(request.getParameter("android"));
		
		// 총점, 평균, 학점을 구하시오.
		int total = java+web+iot+android;
		double avg = total/4.0;
		String grade = "F";
		
		if(avg>=95 || avg<=100){
			grade = "A+";
		}else if(avg>=90 || avg<95){
			grade = "A";
		}else if(avg>=85 || avg<90){
			grade = "B+";
		}else if(avg>=80 || avg<85){
			grade = "B";
		}
		
	%>
	<fieldset>
			<legend>성적확인프로그램</legend>
			<table width="500">	
				<tr>
					<td>이름</td>
					<td><%=name %></td>
				</tr>
				<tr>
					<td>JAVA점수</td>
					<td><% out.print(java); %></td>
				</tr>
				<tr>
					<td>WEB점수</td>
					<td><%=web %></td>
				</tr>
					<tr>
					<td>IOT점수</td>
					<td><%=iot %></td>
				</tr>		
				<tr>
					<td>ANDROID점수</td>
					<td><%=android %></td>
				</tr>		
				<tr>
					<td>평균</td>
					<td><%=avg %></td>
				</tr>
				<tr>
					<td>학점</td>
					<td><h3><%=grade %></h3></td>
				</tr>																																						
			</table>
		</fieldset>
	
</body>
</html>