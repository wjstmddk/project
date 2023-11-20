package member;

public class Member {
	String id;
	String pw;
	
	public Member(String id, String pw) {
		this.id=id;
		this.pw=pw;
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
	
	@Override
	public String toString() {
		String str="";
		str+="id: "+id;
		str+="pw: "+pw;
		return str;
	}
}
