<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>�α��� ������</h2>
	<from action="main" accept-charset="utf-8">
	<fieldset style="width: 150">
		<input type="hidden" name="action" value="regist" method="post" />
		<lengend>�α���</lengend>
		<div>
			<label for="logid">���̵�</label><input type="text" name="logid"
				id="logid" />
		</div>
		<div>
			<label for="logpw">��й�ȣ</label><input type="password" name="logpw"
				id="logpw" />
		</div>
		<div>
			<button id="register">ȸ������</button>
			<button id="login">�α���</button>
		</div>
	</fieldset>
	</from>
</body>
</html>