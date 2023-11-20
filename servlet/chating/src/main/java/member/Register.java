package member;

import java.util.*;

import util.JdbcUtil;

import java.sql.*;

public class Register {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	JdbcUtil jdbc=new JdbcUtil();
	ArrayList<Member> arr=new ArrayList<>();
	
	public boolean register(Member mem) {
		con=jdbc.getConnection();
		String sql="INSERT INTO MEMBER5 VALUES(?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,mem.getEmail());
			pstmt.setString(2,mem.getId().toUpperCase());
			pstmt.setString(3,mem.getPw());
			pstmt.setString(4,mem.getNick());
			int result=pstmt.executeUpdate();
			if(result==0) return false;
			else return true;
		}catch(SQLException e) {
			System.out.println("AccountInsert error"+e);
			}finally {
				JdbcUtil.dbClose(rs, pstmt, con);
			}
		return false;
	}
}
