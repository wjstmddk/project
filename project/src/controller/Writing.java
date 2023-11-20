package controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import member.Member;
import project.Main;

public class Writing extends Sign {
//	LocalDate now = LocalDate.now();
	ArrayList<Writing> write = new ArrayList<Writing>();
	DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private String id;
	private int num = 1; // 글번호
	private int lookNum = 0; // 조회수
	String dateTime;
	String headName;
	String writing;
	String writingDate;

	public Writing() {

	}

	public Writing(String id, int num, String headName, String writing, String dateTime, int lookNum) {
		this.id = id;
		this.num = num;
		this.headName = headName;
		this.writing = writing;
		this.dateTime = dateTime;
		this.lookNum = lookNum;

	}

	public void setId(String id) {
		this.id = id;
	}

	public void write() {
		String sql = "insert into writing values(?,num,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			id = Sign.getLoginId();
			System.out.print("제목: ");
			String headName = Main.sc.next();
			System.out.print("글(5000자 이내): ");
			String writing = Main.sc.next();
//			String writingDate = LocalDate.now().format(date);// 글쓴 시간
			String writingDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

			pstmt.setString(1, id);
			pstmt.setString(2, headName);
			pstmt.setString(3, writing);
			pstmt.setString(4, writingDate);
			pstmt.setInt(5, lookNum);

			int result = pstmt.executeUpdate();
			if (result != 0) {
				System.out.println("작성 성공");
			} else { // result = 0
				System.out.println("작성 실패");
			}

		} catch (SQLException e) {
			System.out.println("오류");
			e.printStackTrace();
		}
	}

	public void deleteWrite() {
		String sql = "delete from writing where id = ? and head_name = ?";
		try {
			pstmt = con.prepareStatement(sql);
			System.out.print("삭제할 글제목: ");
			String headName = Main.sc.next();

			pstmt.setString(1, Sign.getLoginId());
			pstmt.setString(2, headName);

			int result = pstmt.executeUpdate();
			if (result != 0) {
				System.out.println("삭제 성공");
			} else { // result = 0
				System.out.println("삭제 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void writeUpdate() {
		String sql = "update writing set head_name = ?, writing = ? where id = ? and head_name = ?";
		try {
			pstmt = con.prepareStatement(sql);
			System.out.print("수정할 글제목:");
			String head_name = Main.sc.next();
			System.out.print("제목:");
			String headName = Main.sc.next();
			System.out.print("글내용:");
			String writing = Main.sc.next();
			
			pstmt.setString(1, headName);
			pstmt.setString(2, headName);
			pstmt.setString(3, Sign.getLoginId());
			pstmt.setString(4, head_name);
			int result = pstmt.executeUpdate();
			if(result != 0)
			System.out.println("수정 성공");		
			else
				System.out.println("수정 실패");
		}catch(SQLException e) {
			e.printStackTrace();
			
		
		}
	}
	public void showWrite() {
//		for(Writing wrt : write) {
//			wrt.showInfo();
//		}
		for(int i = 0; i < write.size(); i++) {
			write.get(i).showInfo();
		}
	}
	public void writeOn() {
		String sql = "select * from writing";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // db에서 select문 실행
			while (rs.next()) {
				String id = rs.getString("id");
				int num = rs.getInt("num");
				String headName = rs.getString("head_name");
				String writing = rs.getString("writing");
				String dateTime = rs.getString("date");
				int lookNum = rs.getInt("looknum");
				Writing wrt = new Writing(id,num,headName,writing,dateTime,lookNum);
				write.add(wrt);
			}
		} catch (SQLException e) {
			System.out.println("불러오기 실패");
			e.printStackTrace();
		}
	}
	public void showInfo() {
		System.out.println("아이디\t글번호\t제목\t글내용\t글쓴시간\t조회수");
		System.out.println("====================================================================================");
		System.out.printf("%s\t%d\t%s\t%s\t%s\t%d\n",id,num,headName,writing,dateTime,lookNum);
		System.out.println();
	}
}
