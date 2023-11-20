package member;

import java.util.*;

import util.JdbcUtil;

import java.sql.*;

public class Login {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	JdbcUtil jdbc=new JdbcUtil();
	ArrayList<Member> arr=new ArrayList<>();
	
	public boolean login(Member mem) {
		conn=jdbc.getConnection();
		String sql="SELECT * FROM member WHERE ID=? AND PW=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,mem.getId());
			pstmt.setString(2, mem.getPw());
			rs=pstmt.executeQuery();
			arr.add(mem);
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbc.dbClose(rs, pstmt, conn);
		}
		
		
		return false;
	}
}
