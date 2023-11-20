<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 페이지</h2>
	<from action="main" accept-charset="utf-8">
	<fieldset style="width: 150">
		<input type="hidden" name="action" value="regist" method="post" />
		<lengend>로그인</lengend>
		<div>
			<label for="logid">아이디</label><input type="text" name="logid"
				id="logid" />
		</div>
		<div>
			<label for="logpw">비밀번호</label><input type="password" name="logpw"
				id="logpw" />
		</div>
		<div>
			<button id="register">회원가입</button>
			<button id="login">로그인</button>
		</div>
	</fieldset>
	</from>
</body>
</html>