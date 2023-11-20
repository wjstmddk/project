package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// jdbc 공통 메소드
public class JdbcUtil {
	static { // 클래스당 1번 초기화
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}// static
	// java and db 연결
	public static Connection getConnection() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "jung", "1234");
			con.setAutoCommit(true); // 기본값
//			con.setAutoCommit(false); // 수동 커밋
//			System.out.println("db 접속 성공");
			return con;
		} catch (SQLException e) {
			System.out.println("db 접속 실패");
			e.printStackTrace();
		}
		return null;
	}
	// java and db 연결 종료
	public static void dbClose(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
			System.out.println("db연결 종료 성공");
		} catch (SQLException e) {
			System.out.println("db연결 종료 실패");
			e.printStackTrace();
		}
	}//
	public static void dbCommit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			System.out.println("commit fail");
			e.printStackTrace();
		}
	}//dbCommit end
	public static void dbRollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			System.out.println("rollback fail");
			e.printStackTrace();
		}
	}//dbRollback end
}//JdbcUtil end
