package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

public class MemberDAO {
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
	 
	 public MemberDTO loginCheck(String email, String pw) {
		 
		 MemberDTO member = null;
		 
		 try {	
			 	// DB������
			 	connection();
			 	
				// ���� ����
				String sql = "select * from web_member where email=? and pw=?";
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, email);
				psmt.setString(2, pw);		
				
				// �ڡڡڡڡ�
				// insert, update, delete : executeUpdate() --> DB�� ������ ������ ��
				// select : executeQuery() --> DB�� ������ �˻��� ��
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					// �÷��ε����� 1���� ����
					String getEmail = rs.getString(1);
					String getTel = rs.getString(3);
					String getAddress = rs.getString(4);
					
					member = new MemberDTO(getEmail, null, getTel, getAddress);					
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
		 
		 return member;
	 }
	 
	 public int join(MemberDTO member) {
		 
		 int cnt = 0;
		 
		 try { 
		 	
			 // DB����
			 connection();
			
			 
			// ���� ����
			String sql = "insert into web_member values(?,?,?,?)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getEmail());
			psmt.setString(2, member.getPw());
			psmt.setString(3, member.getTel());				
			psmt.setString(4, member.getAddress());				
			
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

	public int update(MemberDTO member) {
		 int cnt = 0;
		 
		 try { 
		 	// DB����
			connection();
			// ���� ����
			String sql = "update web_member set pw=?, tel=?, address=? where email=?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getPw());
			psmt.setString(2, member.getTel());
			psmt.setString(3, member.getAddress());
			psmt.setString(4, member.getEmail());
			
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
	public ArrayList<MemberDTO> select() {
		 
		 ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		 MemberDTO member = null;
		 
		 try {	
			 	// DB������
			 	connection();
			 	
				// ���� ����
				String sql = "select * from web_member";
				
				psmt = conn.prepareStatement(sql);	
				
				// �ڡڡڡڡ�
				// insert, update, delete : executeUpdate() --> DB�� ������ ������ ��
				// select : executeQuery() --> DB�� ������ �˻��� ��
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					// �÷��ε����� 1���� ����
					String getEmail = rs.getString(1);
					String getTel = rs.getString(3);
					String getAddress = rs.getString(4);
					
					member = new MemberDTO(getEmail, null, getTel, getAddress);
					list.add(member);
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
	
	public int delete(String email) {
		 int cnt = 0;
		 
		 try { 
		 	// DB����
			connection();
			// ���� ����
			String sql = "delete from web_member where email = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);

			
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
	
	 public boolean idCheck(String email) {		 
		 boolean check = false;
		 
		 try {	
			 	// DB������
			 	connection();
			 	
				// ���� ����
				String sql = "select * from web_member where email=?";
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, email);	
				
				// �ڡڡڡڡ�
				// insert, update, delete : executeUpdate() --> DB�� ������ ������ ��
				// select : executeQuery() --> DB�� ������ �˻��� ��
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					check = true;
				}else {
					check = false;
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
		 
		 return check;
	 }
}
