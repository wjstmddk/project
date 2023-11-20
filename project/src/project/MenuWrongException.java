package project;

public class MenuWrongException extends Exception{
	//필드, 메소드, 생성자
	private int wrongMenuNum;
	public MenuWrongException(int menuNum) {
		super("잘못된 메뉴선택입니다.");
		this.wrongMenuNum=menuNum;
	}
	public void showWrongNumInfo() {
		System.out.println(wrongMenuNum+"에 해당하는 선택은 존재하지 않습니다.");		
	}
	
}
