<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>회원가입 JOINFORM</title>
<link rel="stylesheet" href="./joinStyle.css" />
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<form action="main" accept-charset="utf-8">
		<div class="main-container">
			<div>
				<h1>Webstargram</h1>
			</div>
			<div class="login-container">
				<div>
					<div class="member-join">

						<label for="">이메일 :<input type="text" size="20" id="email"
							maxlength="20" class="id" placeholder="이메일을 입력해주세요" /></label> <span
							class="email"></span>
					</div>
					<div>
						<label for="">이름 : <input type="text" id="nameck"
							class="id" size="20" maxlength="10" placeholder="이름을 입력해 주세요" /></label>
						<span class="name"></span>
					</div>
					<div>
						<label for="">비밀번호: <input type="password" id="pwd"
							class="id" size="20" maxlength="10" placeholder="비밀번호를 입력해주세요" /></label>
						<span class="password"></span>
					</div>
					<label for=""> 비밀번호 확인: <input type="password"
						id="checkPwd" size="20" maxlength="10" class="id"
						placeholder="비밀번호를 한번 더 입력해주세요" /></label> <span class="password_confirm"></span>
					<div>
						<label for="">사용할 아이디:<input type="text" id="usernic"
							class="id" size="20" maxlength="10" placeholder="아이디를 입력해주세요" /></label>
						<span class="id"></span>
					</div>
					<div>
						<button class="loginbtn" id="joinBtn" value="register">회원가입</button>
						<footer>친구들과 함께 Webstargram으로 소통하려면 가입하세요!</footer>
					</div>
				</div>
				<script>
        $(function () {
          //로컬스토리지에 담을 배열필요함
        let user={}; //객체
        let userList=[];
          
          //정규화
          let email = /^([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,})$/;
          let nameck = /^[가-힣]|$]/;
          let checkPW = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[~!@#$%^&*()_+])[A-Za-z\d~!@#$%^&*()_+]{8,}$/;
          let usernic = /^[a-z0-9]{6,10}$/;
         
          // userEmail (이메일) 검증
          $("#email").blur(function () {
            if ($("#email").val() == "") {
              $(".email").text("이메일을 입력해주세요.");
              $("#email").focus();
              return false;
            } else if (!email.test($("#email").val())) {
              $(".email").text("이메일 형식에 맞춰 입력해주세요.").css("color", "red");
              return false;
            } else {
              $(".email").text("");
              return true;
            }
          });
          // userName (이름) 검증
/*          $("#nameck").blur(function () {
            if ($("#nameck").val() == "") {
              $(".name").text("이름을 입력해주세요.").css("color", "red");;
              return false;
            } else if (!nameck.test($("#nameck").val())) {
              $(".name").text("한글로 입력해주세요.").css("color", "red");;
              $("#nameck").focus();
              return false;
            } else {
              $(".name").text("사용가능한 이름입니다.").css("color", "#3f8ef7");
              return true;
            }
          });*/
          // userNic (아이디) 검증
          $("#usernic").blur(function () {
            if ($("#usernic").val() == "") {
              $(".id").text("아이디를 입력해주세요");
              $("#usernic").focus();
              return false;
            } else if (!usernic.test($("#usernic").val())) {
              $(".id").text("영문 혹은 영문,숫자를 조합해 6자리이상 10자리이하로 입력.").css("color", "red");;
              $("#usernic").focus();
              return false;
            } else {
              $(".id").text("사용가능한 아이디입니다.").css("color", "green");
              $("#pwd").focus();
              return true;
            }
          });
          // userPW (비밀번호) 검증
/*          $("#pwd").blur(function () {
            if ($("#pwd").val() == "") {
              $(".password").text("비밀번호를 입력해주세요").css("color", "red");;
              $("#pwd").focus();
              return false;
            } else if (!checkPW.test($("#pwd").val())) {
              $(".password").text("3개 이상을 조합하여 8자리 이상 입력해 주세요.").css("color", "red");
              return false;
            } else {
              $(".password").text("사용가능한 비밀번호 입니다.").css("color", "#3f8ef7");
              return true;
            }
          });
          // 비밀번호 확인 검증
          $("#checkPwd").blur(function () {
            if ($("#pwd").val() != $("#checkPwd").val()) {
              $(".password_confirm").text("비밀번호와 일치하게 입력해주세요.").css("color", "red");
              return false;
            } else {
              $(".password_confirm").text("").css("color", "red");;
              return true;
            }
          });
        });*/
        document.getElementById('joinBtn').addEventListener('click', function () {
     
          localStorage.setItem('currentUser', JSON.stringify(user));
          alert(username + '님, 회원가입 축하합니다!');
        });
//        $("#joinBtn").click(() => {
//      location.href = "main.html";
//    });
      </script>
			</div>
		</div>
	</form>
</body>
</html>