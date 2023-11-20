package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Sign;
import controller.Writing;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static int loginIndex = -1;
	public static void main(String[] args) {
		int menuNum;
		Connection con; // db 접속을 위해서 필요
		PreparedStatement pstmt; // sql문장을 db에 전달하기위해서 필요
		ResultSet rs; // Select 결과 저장하기 위해서 필요
		Sign sign = new Sign();
		Writing writing = new Writing();
		boolean run = true;
		sign.on();
		writing.writeOn();
		while (run) {
			
			try {
				if (loginIndex == -1) {
					showMenu(loginIndex);
					menuNum = sc.nextInt();
					if (menuNum < 1 || menuNum > 3) {
						throw new MenuWrongException(menuNum);
					}
					switch (menuNum) {
					case 1:
						sign.sign();
						break;
					case 2:
						sign.login();
						break;
					case 3: 
						writing.showWrite();
						break;
					}

				} else {
					showMenu(loginIndex);
					menuNum = sc.nextInt();
					if (menuNum < 1 || menuNum > 12) {
						throw new MenuWrongException(menuNum);
					}
					switch (menuNum) {
					case 1:
						logout();
						break;
					case 2:
						writing.write();
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						sign.friendAdd(loginIndex);
						break;
					case 6:
						sign.showMember(loginIndex);
						break;
					case 7:
						break;
					case 8:
						sign.friendDelete(loginIndex);
						break;
					case 9 :
						writing.deleteWrite();
						break;
					case 10:
						writing.showWrite();
						break;
					case 11:
						writing.writeUpdate();
						break;
					case 12:
						sign.friendShowAll(loginIndex);
						break;
						
					default:
						sign.off();
						break;
					}
				}
			} catch (MenuWrongException e) {
				System.out.println(e.getMessage());
				e.showWrongNumInfo();
			} catch (InputMismatchException e) {
				// System.out.println(e.getMessage());
				System.out.println("메뉴는 정수만 가능합니다.");
				sc.nextLine(); // 입력버퍼 삭제
			}

		}

	}
	
	public static void logout() {
		loginIndex = -1;
		System.out.println("로그아웃 되었습니다");
	}
	private static void showMenu(int loginIndex) {
		System.out.println("-------메뉴선택-------");
		if (loginIndex == -1) {
			System.out.println("1.회원가입 2.로그인 3.글 보기");
		} else {
			System.out.println("1.로그아웃 2.글쓰기 3.댓글달기 4.좋아요 표시 5.친구추가 6.내정보 7.정보삭제 8.친구삭제 9.글삭제 10.글 보기"
					+ "11.글 수정 12.친구정보");
		}
	}
}
