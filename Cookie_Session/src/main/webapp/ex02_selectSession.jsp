<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>���� ���� ��ȸ</h1>
	<%
		// ���� ���� ��ȸ
		// �ٿ�ĳ���� : �θ�Ŭ���� --> �ڽ�Ŭ���� Ÿ������ ��ȯ
		// �ڡڡ�why? ���ǿ����� ����� ������ Ÿ���� Object�̱� ������
		// Object -> (String)
		String nick = (String)session.getAttribute("nick");
		out.print(nick);
		
		// ���� ��ȿ�Ⱓ ����(�ʴ���)
		// ������ ��ȿ�Ⱓ�� �⺻���� 30��
		session.setMaxInactiveInterval(10);
	%>
</body>
</html>