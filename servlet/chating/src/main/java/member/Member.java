package member;

public class Member {
	private String id;
	private String pw;
	private String email;
	private String nick;
	
	
	public Member(String email, String pw, String id, String nick) {
		this.id=id;
		this.pw=pw;
		this.email=email;
		this.nick=nick;
	}
	
	public Member() {
		
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		String str="";
		str+="id: "+id;
		str+="pw: "+pw;
		return str;
	}
}
