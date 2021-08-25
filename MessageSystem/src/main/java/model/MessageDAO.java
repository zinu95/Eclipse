package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageDAO {
	
	
		 private Connection conn = null;
		 private PreparedStatement psmt = null;
		 private ResultSet rs = null;

		 public void connection() {
			 	// �����ͺ��̽��� �����ϱ� ���� Ŭ���������� �����ε�
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					// localhost : Oracle DB�� ��ġ�� PC�� ip�ּ� ����
					String url = "jdbc:oracle:thin:@localhost:1521:xe"; // localhost : �ٸ� pc�� ip�ּҷ� �Է�
					String user = "hr";
					String pass = "hr";
					
					// �����ͺ��̽� ����
					conn = DriverManager.getConnection(url, user, pass);
				} catch (ClassNotFoundException e) {
					System.out.println("ojdbc6.jar �Ǵ� driver��� Ȯ��");
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("DB�������...");
					e.printStackTrace();
				}
				

		 }
		 
		 public void close() {
			 
				try {
					if(rs != null) { rs.close(); }
					if(psmt != null) { psmt.close(); }
					if(conn != null) { conn.close(); }
					
				} catch(SQLException e) {
					e.printStackTrace();			
			}
			 
		 }
		 public int insertMessage(MessageDTO message) {
			 
			 int cnt = 0;
			 
			 try { 
			 	
				 // DB����
				 connection();
				
				 
				// ���� ����
				String sql = "insert into web_message values(num_message.nextval,?,?,?,sysdate)";
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, message.getSendName());
				psmt.setString(2, message.getReceiveEmail());
				psmt.setString(3, message.getMessage());						
				
				// �ڡڡڡڡ�
				// insert, update, delete : executeUpdate() --> DB�� ������ ������ ��
				// select : executeQuery() --> DB�� ������ �˻��� ��
				cnt = psmt.executeUpdate();
				
			} catch (SQLException e) {
				// DB���� ���� �߻��� ����Ǵ� catch��
				System.out.println("sql �� ������!");
				e.printStackTrace();
			} finally {
				// ������ �����ϴ� ����
				// �����ͺ��̽� ������ ����
				close();
			} // end
			 return cnt;
		 }
		 
		 public ArrayList<MessageDTO> showMessage(String email) {
				 
			 ArrayList<MessageDTO> list = new ArrayList<MessageDTO>();
			 MessageDTO message = null;
				 
			 try {	
				 	// DB������
				 	connection();
				 	
					// ���� ����
					String sql = "select * from web_message where receiverEmail = ?";
					
					psmt = conn.prepareStatement(sql);	
					psmt.setString(1, email);
					
					// �ڡڡڡڡ�
					// insert, update, delete : executeUpdate() --> DB�� ������ ������ ��
					// select : executeQuery() --> DB�� ������ �˻��� ��
					rs = psmt.executeQuery();
					
					while(rs.next()) {
						// �÷��ε����� 1���� ����
						int getNum = rs.getInt(1);
						String sendName = rs.getString(2);
						String receiveEmail = rs.getString(3);
						String getMessage = rs.getString(4);
						String date = rs.getString(5);
							
						message = new MessageDTO(getNum, sendName, receiveEmail, getMessage, date);
						list.add(message);
					}
					
				} catch (SQLException e) {
					// DB���� ���� �߻��� ����Ǵ� catch��
					System.out.println("sql �� ������!");			
					e.printStackTrace();
				} finally {
					// ������ �����ϴ� ����
					// �����ͺ��̽� ������ ����				
					close();
			}// end
				 
			 return list;
		 }
		 
	}


