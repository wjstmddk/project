
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.Register;
import member.Member;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Register reg = new Register();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("action");
		System.out.println(act);
		doRegist(request, response);
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Member member = new Member();
		member.setEmail(request.getParameter("email"));
		member.setId(request.getParameter("nameck"));
		member.setPw(request.getParameter("pwd"));
		member.setNick(request.getParameter("usernic"));
		boolean check = reg.register(member);
		System.out.println(check);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if (check) {
//			out.print(
//					"<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8' /><meta http-equiv='X-UA-Compatible' content='IE=edge' /><meta name='viewport' content='width=device-width, initial-scale=1.0' /><title>회원가입</title></head><body><h2>register</h2><div>");
//			out.print(member.toString());
//			out.print("</div></body></html>");
			response.sendRedirect("login.jsp");
		} else {
			out.print(
					"<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8' /><meta http-equiv='X-UA-Compatible' content='IE=edge' /><meta name='viewport' content='width=device-width, initial-scale=1.0' /><title>회원가입</title></head><body><h2>register</h2><div>");
			out.print("회원가입에 실패하였습니다");
			out.print("</div></body></html>");
		}
	}
//	private void dologin(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		Member member = new Member();
//		member.setId(request.getParameter("logid"));
//		member.setPw(request.getParameter("logpw"));
//		log.login(member);
//
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		System.out.println(out);
//		out.print(
//				"<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8' /><meta http-equiv='X-UA-Compatible' content='IE=edge' /><meta name='viewport' content='width=device-width, initial-scale=1.0' /><title>회원가입</title></head><body><h2>login</h2><div>");
//		out.print(member.toString());
//		out.print("</div></body></html>");
//	}
}