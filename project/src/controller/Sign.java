package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.JdbcConnection;

import jdbc.JdbcUtil;
import member.FriendAdd;
import member.Member;
import project.Main;

public class Sign {
	static Connection con; // db 접속을 위해서 필요
	static PreparedStatement pstmt; // sql문장을 db에 전달하기위해서 필요
	static ResultSet rs; // Select 결과 저장하기 위해서 필요
	private ArrayList<Member> member = new ArrayList<Member>();
	private ArrayList<FriendAdd> friendAdd = new ArrayList<FriendAdd>();
	private static String loginId;

	public void sign() { // 회원가입
		String sql = "insert into member() values(?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			System.out.println("회원가입을 시작합니다");
			System.out.print("아이디를 입력하세요");
			String id;
			while (true) {// 중복 아이디 거르기
				id = Main.sc.next();
				int a = -1;
				for (int i = 0; i < member.size(); i++) {
					if (member.get(i).getId().equals(id)) {
						System.out.print("이미 사용중인 아이디입니다 다시 입력해주세요:");
						a = 0;
					}
				}
				if (a == -1) {
					break;
				}
			}
			System.out.print("비밀번호를 입력하세요");
			String pw = Main.sc.next();
			System.out.print("이메일을 입력하세요:");
			String email;
			while (true) {// 중복 이메일 거르기
				email = Main.sc.next();
				int a = -1;
				for (int i = 0; i < member.size(); i++) {
					if (member.get(i).getEmail().equals(email)) {
						System.out.print("이미 사용중인 이메일입니다 다시 입력해주세요");
						a = 0;
					}
				}
				if (a == -1) {
					break;
				}
			}
			System.out.print("이름을 입력하세요: ");
			String name = Main.sc.next();
			System.out.print("생년월일을 입력하세요:");
			String birth = Main.sc.next();
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, email);
			pstmt.setString(4, name);
			pstmt.setString(5, birth);
			int result = pstmt.executeUpdate();
			if (result != 0) {
				System.out.println("회원가입 성공");
			} else { // result = 0
				System.out.println("회원가입 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void login() {
		boolean run = false;
		System.out.print("ID입력: ");
		String id = Main.sc.next();
		System.out.print("PW입력: ");
		String pw = Main.sc.next();
		for (int i = 0; i < member.size(); i++) {
			if (id.equals(member.get(i).getId()) && pw.equals(member.get(i).getPw())) {
				System.out.println("로그인 성공");
				run = true;
				Main.loginIndex = i;
				setLoginId(member.get(Main.loginIndex).getId());
				return;
			}
		}

		if (!run) {
			System.out.println("로그인 실패");
		}
	}

	public void friendAdd(int loginIndex) {
		String sql = "select * from friend_add where member_id = ?";
		int myId = loginIndex;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, myId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int index = rs.getInt("member_id");
				String id = rs.getString("friend_id");
				FriendAdd fA = new FriendAdd(index, id);
				friendAdd.add(fA);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql = "insert into friend_add values(?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			System.out.print("친구추가: ");
			String id = Main.sc.next();
			boolean run = false; // 친구 아이디 유무 확인
			boolean add = true; // 이미 추가한 친구인지 확인
			for (int i = 0; i < member.size(); i++) { // 입력한 id가 member에 추가된 아이디인지 확인
				if (id.equals(member.get(i).getId()))
					run = true;
			}
			if (id.equals(member.get(loginIndex).getId())) {
				System.out.println("본인 아이디 입니다");
				add = false;
			}
			if (run) {
				pstmt.setInt(1, myId);
				for (int i = 0; i < friendAdd.size(); i++) { // loginIndex = myId 가 본인 아이디 본인 아이디로 친구추가했는지 안했는지 확인
					if (friendAdd.get(i).getFriendId().equals(id) && friendAdd.get(i).getMyId() == myId) {
						System.out.println("이미 추가한 친구입니다");
						add = false;
						break;
					}
				}
				if (add) {
					pstmt.setString(2, id);
					int result = pstmt.executeUpdate();
					if (result != 0)
						System.out.println("친구추가 성공");
					else
						System.out.println("친구추가 실패");
				}
			} else {
				System.out.println("없는계정입니다");
			}
		} catch (SQLException e) {
			System.out.println("오류");
			e.printStackTrace();
		}
	}
	public void friendShowAll(int loginIndex) {
		String sql = "select friend_id from friend_add where member_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, loginIndex);
			
			rs = pstmt.executeQuery(); // db에서 select문 실행
			System.out.println("친구 목록");
			while(rs.next()) {
				System.out.println(rs.getString("friend_id"));
				System.out.println("-------------------");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void friendDelete(int loginIndex) {
		String sql = "delete from friend_add where member_id = ? and friend_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, loginIndex);
			System.out.print("삭제할 친구Id:");
			pstmt.setString(2, Main.sc.next());
			int result = pstmt.executeUpdate();
			if(result != 0)
				System.out.println("삭제 성공");
			else
				System.out.println("삭제 실패");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void on() {// db접속 및 ArrayList에 db에 저장된 멤버값 저장
		con = JdbcUtil.getConnection();
		String sql = "select * from member";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // db에서 select문 실행
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String birth = rs.getString("birth");
				Member sign = new Member(id, pw, name, email, birth);
				member.add(sign);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showMember(int loginIndex) {
		member.get(loginIndex).showInfo();
	}

	public void off() {
		JdbcUtil.dbClose(rs, pstmt, con);
	}

	public static String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}
