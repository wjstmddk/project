<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN-MAIN</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="./loginStyle.css" />
</head>
<body>
<form action="login" accept-charset="utf-8">
	<div class="main-container">
		<div>
			<h1>Webstagram</h1>
		</div>

		<div class="login-container">
			<input type="text" class="check" placeholder="전화번호 또는 사용자 이름" name="nameck" /> <input
				type="password" class="check" placeholder="비밀번호" name="pwd"/>
		</div>
		<div>
			<button class="loginbtn">로그인</button>
		</div>
		<div>
			<div>
				<span class="join" id="joinLink" href="" disabled>Webstagram이
					처음이신가요?</span>
			</div>
		</div>
		<footer>
			<span id="findinfo" href="" disabled>아이디 또는 비밀번호를 잊으셨나요 ?</span>
		</footer>
	</div>
	<script>
      // Webstagram이 처음이신가요? 링크 누르면 회원가입페이지로
      $("#joinLink").click(() => {
        location.href = "register.jsp";
      });
      $("#findinfo").click(() => {
        location.href = "findinfo.html";
      });
    </script>
    </form>
</body>
</html>