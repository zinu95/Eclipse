<%@page import="model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- 1.request������ ����� ������ �������ÿ�. -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="EUC-KR" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
		
	</head>
	<style>
	
	</style>
	<body style="text-align: center;">
	<%
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.select();
	%>
		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<table>
							<caption><h2>ȸ������������</h2></caption>
							<tr>
								<td>Email</td>
								<td>Tel</td>
								<td>Address</td>							
							</tr>
							<!-- 2.��� ȸ���� �̸���(email),��ȭ��ȣ(tel),�ּ�(address)�� ����Ͻÿ�. -->
							<%for(int i=0; i<list.size(); i++) {%>
							<tr>
								<td><%=list.get(i).getEmail() %></td>
								<td><%=list.get(i).getTel() %></td>
								<td><%=list.get(i).getAddress() %></td>
								<!-- query String : key=value ���� url �ڿ� �ٿ� �߰����� ������ ���� ���� �����ϴ� ��� -->
								<td><a href="DeleteCon?email=<%=list.get(i).getEmail() %>">����</a></td>
							</tr>
							<%} %>
						</table>
					</nav>		
					<a href="main.jsp" class="button next scrolly">�ǵ��ư���</a>	
			</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
	</body>
</html>

