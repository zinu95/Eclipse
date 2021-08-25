<%@page import="model.MessageDAO"%>
<%@page import="model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MessageDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>  
<% MemberDTO member = (MemberDTO)session.getAttribute("member"); 

	MessageDAO dao = new MessageDAO();
	ArrayList<MessageDTO> list = new ArrayList<MessageDTO>();
	
	if(member != null) {
		list = dao.showMessage(member.getEmail());
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="EUC-KR" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header" class="alt">
						<a href="index.html" class="logo"><strong>Forty</strong> <span>by HTML5 UP</span></a>
						<nav>
							<!-- �α��� �� Logout.jsp�� �̵��� �� �ִ�'�α׾ƿ�'��ũ�� '������������'��ũ�� ����Ͻÿ�. -->
							<!-- �̸��� : admin -->
							<!-- admin(������ ����) : ȸ������, �α׾ƿ� -->
							<!-- �Ϲ� ���� : ������������, �α׾ƿ� -->
							<% if(member != null) {
								if(member.getEmail().equals("admin")) {
							%>
								<a href='select.jsp'>ȸ������</a>
								<%}else{ %>								
								<a href='update.jsp'>������������</a>
								<%} %>
								<a href='logout.jsp'>�α׾ƿ�</a>
							<%} else{ %>
								<a href='#menu'>�α���</a>							
							<% } %>
						<!-- �α��� �� Logout.jsp�� �̵��� �� �ִ� '�α׾ƿ�'��ũ�� '������������'��ũ�� ����Ͻÿ�. -->	
						</nav>
					</header>

				<!-- Menu -->
					<nav id="menu">	
						<ul class="links">
							<li><h5>�α���</h5></li>
								<form action="LoginServiceCon.do" method="post">
									<li><input type="text" name="email" placeholder="Email�� �Է��ϼ���"></li>
									<li><input type="password" name="pw" placeholder="PW�� �Է��ϼ���"></li>
									<li><input type="submit" value="LogIn" class="button fit"></li>
								</form>
						</ul>
						<ul class="actions vertical">
							<li><h5>ȸ������</h5></li>
								<form action = "JoinServiceCon.do" method = "post">
									<li><input type="text" name="email" placeholder="Email�� �Է��ϼ���"
               								id="input_id"> <input type="button" value="ID�ߺ�üũ"
               								onclick="idCheck()"> <span id="sp"></span></li>
									
									<li><input type="password" name="pw" placeholder="PW�� �Է��ϼ���"></li>
									<li><input type="text" name="tel" placeholder="��ȭ��ȣ�� �Է��ϼ���"></li>
									<li><input type="text" name="address" placeholder="���ּҸ� �Է��ϼ���"></li>
									<li><input type="submit" value="JoinUs" class="button fit"></li>
								</form>
						</ul>
					</nav>
				<!-- Banner -->
					<section id="banner" class="major">
						<div class="inner">
							<header class="major">
								
								<% if(member != null) { %>
									<h1><%=member.getEmail() %>�� ȯ���մϴ�!</h1>
								<% }else { %>
									<h1>�α��� �� ���Ǿ��̵� ������ּ���</h1>
								<% } %>
								<!-- �α��� �� �α��� �� ������� ���Ǿ��̵�� �ٲٽÿ�.
									 ex)smart�� ȯ���մϴ� -->
							</header>
							<div class="content">
								<p>�Ʒ��� ���ݱ��� ��� �� ������Դϴ�.<br></p>
								<ul class="actions">
									<li><a href="#one" class="button next scrolly">Ȯ���ϱ�</a></li>
								</ul>
							</div>
						</div>
					</section>

				<!-- Main -->
					<div id="main">

						<!-- One -->
							<section id="one" class="tiles">
								<article>
									<span class="image">
										<img src="images/pic01.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">HTML</a></h3>
										<p>Ȩ�������� ����� ���� ���</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic02.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">CSS</a></h3>
										<p>HTML�� ���������ִ� ���</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic03.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">Servlet/JSP</a></h3>
										<p>Java�� �⺻���� �� �� ���α׷��� ���/��ũ��Ʈ ���</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic04.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">JavaScript</a></h3>
										<p>HTML�� �⺻���� ������ ������ �� �ִ� ���</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic05.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">MVC</a></h3>
										<p>�� ������Ʈ �� ���� ���� ����ϴ� ����������</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic06.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">Web Project</a></h3>
										<p>�������� ����������Ʈ�� �� ����� Ȱ���ϼ���!</p>
									</header>
								</article>
							</section>
					<!-- Two -->
							<section id="two">
								<div class="inner">
									<header class="major">
										<h2>������ �� �޼��� Ȯ���ϱ�</h2>
									</header>
									<p></p>
									<ul class="actions">
										<%
											if(member != null) {	
										%>
										<li><%=member.getEmail() %>�Կ��� �� �޽����Դϴ�.</li>
										<%	}else { %>
										<!-- �α����� �Ǿ� �ִ� ��� : email�Կ��� �� �޽����Դϴ�. -->
										<li>�α����� �ϼ���.</li><!-- �α����� ���� ���� ��� -->
										<% 	} %>
										<li><a href="#" class="button next scrolly">��ü�����ϱ�</a></li>
									</ul>
									
									<table>
               							<tr>
                 						<th>��ȣ</th>
                  						<th>������ ���</th>
                  						<th>����</th>
                  						<th>�ð�</th>
                  						<th>����</th>
               							</tr>
               							
               							<%
               								for(int i=0; i<list.size(); i++) {
               							%>
               							<tr>
               								<td><%=i+1 %></td>
               								<td><%=list.get(i).getSendName() %></td>
               								<td><%=list.get(i).getMessage() %></td>
               								<td><%=list.get(i).getM_date() %></td>
               								<td><a href="MessageDeleteCon?messageNum=<%=list.get(i).getNum()%>">����</a></td>
               							</tr>
               							<% } %>		
  						          	</table>	
								</div>
							</section>

					</div>

				<!-- Contact -->
					<section id="contact">
						<div class="inner">
							<section>
								<form action = "MessageCon.do" method = "post" id = "MForm">
								<div class="field half first">
										<label for="name">Name</label>
										<input type="text"  id="name" placeholder="������ ��� �̸�" name="sendName" />
									</div>
									<div class="field half">
										<label for="email">Email</label>
										<input type="text"  id="receiveEmail" placeholder="���� ��� �̸���" name="receiveEmail" />
									</div>

									<div class="field">
										<label for="message">Message</label>
										<textarea  id="message" rows="6" name="message"></textarea>
									</div>
									<ul class="actions">
										<li><input type="submit" value="Send Message" class="special" />
										<span id="sp1"></span> </li>
										<li><input type="reset" value="Clear" /></li>
									</ul>
								</form>
							</section>
							
							<section class="split">
								<section>
									<div class="contact-method">
										<span class="icon alt fa-envelope"></span>
										<h3>Email</h3>
										<!-- �α��� �� ������� �̸����� ����Ͻÿ� -->
										<% 
											if(member != null) {
												out.print("<a href='#'>"+member.getEmail()+"</a>");
											}else {
												out.print("<a href='#'>�α��� �� ����� �̸����� ���</a>");
											}
										
										%>
										
									</div>
								</section>
								<section>
									<div class="contact-method">
										<span class="icon alt fa-phone"></span>
										<h3>Phone</h3>
										<!-- �α��� �� ������� ��ȭ��ȣ�� ����Ͻÿ� -->
										<% 
											if(member != null) {
												out.print("<span>"+member.getTel()+"</span>");
											}else {
												out.print("<span>�α��� �� ����� ��ȭ��ȣ�� ���</span>");
											}
										%>										
									</div>
								</section>
								<section>
									<div class="contact-method">
										<span class="icon alt fa-home"></span>
										<h3>Address</h3>
										<!-- �α��� �� ������� ���ּҸ� ����Ͻÿ� -->
										<% 
											if(member != null) {
												out.print("<span>"+member.getAddress()+"</span>");
											}else {
												out.print("<span>�α��� �� ����� ���ּҸ� ���</span>");
											}
										%>											
									</div>
								</section>
							</section>					
						</div>
					</section>

				<!-- Footer -->
					<footer id="footer">
						<div class="inner">
							<ul class="icons">
								<li><a href="#" class="icon alt fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon alt fa-facebook"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon alt fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a href="#" class="icon alt fa-github"><span class="label">GitHub</span></a></li>
								<li><a href="#" class="icon alt fa-linkedin"><span class="label">LinkedIn</span></a></li>
							</ul>
							<ul class="copyright">
								<li>&copy; Untitled</li><li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
							</ul>
						</div>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
			
			<script>
				function idCheck() {
				var input = document.getElementById("input_id");
				// alert(input.value);
				
				$.ajax({
					type : "post", // ������ ���۹��
					data : {'email' : input.value}, // ������ ���� ������
					url : "IdCheckCon", // �����͸� ���� ���� ������
					dataType : "text", // ���䵥������ Ÿ�� ����
					// ��û�� ���� �� ������ �Լ� ���� ex) ��� ������ ���̵��� ��� True / �ƴ� ��� False 
					success : function(data) {
						// alert(data);
						var sp = document.getElementById("sp");
						if(data=="true") {
							sp.innerHTML="�Ұ����� ID�Դϴ�.";
						}else {
							sp.innerHTML="������ ID�Դϴ�.";
						}
					},
					// ��û�� ���� �� ������ �Լ� ����
					error : function() {
						alert("��û ����!");
					}		
				});
				
				}
				var isSubmit = false;
				// event ��ü : DOM�� ���õ� �̺�Ʈ �߻��ϸ� ���� ������ ������ �ִ� ��ü
				$('#MForm').submit(function(event) {
					// submit ó�� �Ǵ� ���� ���ƾ� ��
					event.preventDefault();
					
					// html(), text()
					var rEmail = $('#receiveEmail').val();
					
					$.ajax({
						type : "post", // ������ ���۹��
						data : {'email' : rEmail}, // ������ ���� ������
						url : "EmailCheckCon", // �����͸� ���� ���� ������
						dataType : "text", // ���䵥������ Ÿ�� ����
						// ��û�� ���� �� ������ �Լ� ���� ex) ��� ������ ���̵��� ��� True / �ƴ� ��� False 
						success : function(data) {
							// alert(data);
							if(data=='true') {
								isSubmit = true;
							}else {
								isSubmit = false;
								$('#sp1').html("�̸����� Ȯ���ϼ���");
							}
						},
						// ��û�� ���� �� ������ �Լ� ����
						error : function() {
							alert("��û ����!");
						}		
					});
					// isSubmit�� true�� ��쿡�� submit�� �� �ֵ���
					if(isSubmit) {
						alert(isSumbit);
						this.submit();
					}
				
				});
				
				
			</script>
	</body>
</html>

