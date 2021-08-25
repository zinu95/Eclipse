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
		 public int insertMessage(MessageDTO message) {
			 
			 int cnt = 0;
			 
			 try { 
			 	
				 // DB연결
				 connection();
				
				 
				// 쿼리 실행
				String sql = "insert into web_message values(num_message.nextval,?,?,?,sysdate)";
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, message.getSendName());
				psmt.setString(2, message.getReceiveEmail());
				psmt.setString(3, message.getMessage());						
				
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
		 
		 public ArrayList<MessageDTO> showMessage(String email) {
				 
			 ArrayList<MessageDTO> list = new ArrayList<MessageDTO>();
			 MessageDTO message = null;
				 
			 try {	
				 	// DB연결기능
				 	connection();
				 	
					// 쿼리 실행
					String sql = "select * from web_message where receiverEmail = ?";
					
					psmt = conn.prepareStatement(sql);	
					psmt.setString(1, email);
					
					// ★★★★★
					// insert, update, delete : executeUpdate() --> DB의 내용을 변경할 때
					// select : executeQuery() --> DB의 내용을 검색할 때
					rs = psmt.executeQuery();
					
					while(rs.next()) {
						// 컬럼인덱스는 1부터 시작
						int getNum = rs.getInt(1);
						String sendName = rs.getString(2);
						String receiveEmail = rs.getString(3);
						String getMessage = rs.getString(4);
						String date = rs.getString(5);
							
						message = new MessageDTO(getNum, sendName, receiveEmail, getMessage, date);
						list.add(message);
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
		 
	}


