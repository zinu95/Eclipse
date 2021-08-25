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
		 	// 데이터베이스를 연결하기 위한 클래스파일을 동적로딩
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				// localhost : Oracle DB가 설치된 PC의 ip주소 설정
				String url = "jdbc:oracle:thin:@localhost:1521:xe"; // localhost : 다른 pc의 ip주소로 입력
				String user = "hr";
				String pass = "hr";
				
				// 데이터베이스 연결
				conn = DriverManager.getConnection(url, user, pass);
			} catch (ClassNotFoundException e) {
				System.out.println("ojdbc6.jar 또는 driver경로 확인");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DB연결실패...");
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
			 	// DB연결기능
			 	connection();
			 	
				// 쿼리 실행
				String sql = "select * from web_member where email=? and pw=?";
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, email);
				psmt.setString(2, pw);		
				
				// ★★★★★
				// insert, update, delete : executeUpdate() --> DB의 내용을 변경할 때
				// select : executeQuery() --> DB의 내용을 검색할 때
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					// 컬럼인덱스는 1부터 시작
					String getEmail = rs.getString(1);
					String getTel = rs.getString(3);
					String getAddress = rs.getString(4);
					
					member = new MemberDTO(getEmail, null, getTel, getAddress);					
				}
				
			} catch (SQLException e) {
				// DB관련 오류 발생시 실행되는 catch문
				System.out.println("sql 문 오류다!");			
				e.printStackTrace();
			} finally {
				// 무조건 실행하는 구문
				// 데이터베이스 종료기능 구현				
				close();
		}// end
		 
		 return member;
	 }
	 
	 public int join(MemberDTO member) {
		 
		 int cnt = 0;
		 
		 try { 
		 	
			 // DB연결
			 connection();
			
			 
			// 쿼리 실행
			String sql = "insert into web_member values(?,?,?,?)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getEmail());
			psmt.setString(2, member.getPw());
			psmt.setString(3, member.getTel());				
			psmt.setString(4, member.getAddress());				
			
			// ★★★★★
			// insert, update, delete : executeUpdate() --> DB의 내용을 변경할 때
			// select : executeQuery() --> DB의 내용을 검색할 때
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// DB관련 오류 발생시 실행되는 catch문
			System.out.println("sql 문 오류다!");
			e.printStackTrace();
		} finally {
			// 무조건 실행하는 구문
			// 데이터베이스 종료기능 구현
			close();
		} // end
		 return cnt;
	 }

	public int update(MemberDTO member) {
		 int cnt = 0;
		 
		 try { 
		 	// DB연결
			connection();
			// 쿼리 실행
			String sql = "update web_member set pw=?, tel=?, address=? where email=?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getPw());
			psmt.setString(2, member.getTel());
			psmt.setString(3, member.getAddress());
			psmt.setString(4, member.getEmail());
			
			// ★★★★★
			// insert, update, delete : executeUpdate() --> DB의 내용을 변경할 때
			// select : executeQuery() --> DB의 내용을 검색할 때
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// DB관련 오류 발생시 실행되는 catch문
			System.out.println("sql 문 오류다!");
			e.printStackTrace();
		} finally {
			// 무조건 실행하는 구문
			// 데이터베이스 종료기능 구현
			close();
		} // end
		 return cnt;
		
	}
	public ArrayList<MemberDTO> select() {
		 
		 ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		 MemberDTO member = null;
		 
		 try {	
			 	// DB연결기능
			 	connection();
			 	
				// 쿼리 실행
				String sql = "select * from web_member";
				
				psmt = conn.prepareStatement(sql);	
				
				// ★★★★★
				// insert, update, delete : executeUpdate() --> DB의 내용을 변경할 때
				// select : executeQuery() --> DB의 내용을 검색할 때
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					// 컬럼인덱스는 1부터 시작
					String getEmail = rs.getString(1);
					String getTel = rs.getString(3);
					String getAddress = rs.getString(4);
					
					member = new MemberDTO(getEmail, null, getTel, getAddress);
					list.add(member);
				}
				
			} catch (SQLException e) {
				// DB관련 오류 발생시 실행되는 catch문
				System.out.println("sql 문 오류다!");			
				e.printStackTrace();
			} finally {
				// 무조건 실행하는 구문
				// 데이터베이스 종료기능 구현				
				close();
		}// end
		 
		 return list;
	 }
	
	public int delete(String email) {
		 int cnt = 0;
		 
		 try { 
		 	// DB연결
			connection();
			// 쿼리 실행
			String sql = "delete from web_member where email = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);

			
			// ★★★★★
			// insert, update, delete : executeUpdate() --> DB의 내용을 변경할 때
			// select : executeQuery() --> DB의 내용을 검색할 때
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// DB관련 오류 발생시 실행되는 catch문
			System.out.println("sql 문 오류다!");
			e.printStackTrace();
		} finally {
			// 무조건 실행하는 구문
			// 데이터베이스 종료기능 구현
			close();
		} // end
		 return cnt;
		
	}
	
	 public boolean idCheck(String email) {		 
		 boolean check = false;
		 
		 try {	
			 	// DB연결기능
			 	connection();
			 	
				// 쿼리 실행
				String sql = "select * from web_member where email=?";
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, email);	
				
				// ★★★★★
				// insert, update, delete : executeUpdate() --> DB의 내용을 변경할 때
				// select : executeQuery() --> DB의 내용을 검색할 때
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					check = true;
				}else {
					check = false;
				}
				
			} catch (SQLException e) {
				// DB관련 오류 발생시 실행되는 catch문
				System.out.println("sql 문 오류다!");			
				e.printStackTrace();
			} finally {
				// 무조건 실행하는 구문
				// 데이터베이스 종료기능 구현				
				close();
		}// end
		 
		 return check;
	 }
}
