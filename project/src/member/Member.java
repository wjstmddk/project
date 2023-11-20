package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Member {
	Connection con; // db 접속을 위해서 필요
	PreparedStatement pstmt; // sql문장을 db에 전달하기위해서 필요
	ResultSet rs; // Select 결과 저장하기 위해서 필요
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String birth;
	private ArrayList<Member> member = new ArrayList<Member>();
	
	public Member() {

	}

	public Member(String id, String pw, String name, String email, String birth) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.birth = birth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void showInfo() {
		System.out.println("이름\t이메일\t생일");
		System.out.println("============================");
		System.out.printf("%s\t%s\t%s\n",name, email, birth);
	}

}
