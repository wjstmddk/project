<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>웹스타그램</title>
<link rel="stylesheet" href="./게시판.css">
</head>
<body>
	<!-- 사이드 메뉴 -->
	<table>
		<div id="wrapper">
			<div class="topbar" style="position: absolute; top: 0;">
				<!-- 왼쪽 메뉴 -->
				<div class="left side-menu">
					<div class="sidebar-inner">
						<div id="sidebar-menu">
							<ul>
								<li class="has_sub"><a href="javascript:void(0);"
									class="waves-effect"> <i class="fas fa-bars"></i>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- 왼쪽 서브 메뉴 -->
				<div class="left_sub_menu">
					<div class="sub_menu">
						<ul class="image">
							<a href="./게시판.html"><img src="" alt=""></a>
							<!--프로필 이미지 사진넣으면 이동-->
						</ul>
						<ul class="big_menu">
							<li><a href="#">MYPAGE</a></li>
						</ul>
						<input type="search" name="SEARCH" placeholder="SEARCH">

						<h2>MENU</h2>
						<ul class="big_menu">
							<li>정보공유 <i class="arrow fas fa-angle-right"></i></li>
							<ul class="small_menu">
								<li><a href="#">맛집</a></li>
								<li><a href="#">여행장소 추천</a></li>
								<li><a href="#">또 무슨</a></li>
								<li><a href="#">메뉴가 있을까요</a></li>
							</ul>
						</ul>
						<ul class="big_menu">
							<li>소곤소곤 <i class="arrow fas fa-angle-right"></i></li>
							<ul class="small_menu">
								<li><a href="#">자유게시판</a></li>
								<li><a href="#">공지</a></li>
							</ul>
						</ul>

					</div>
				</div>
				<div class="overlay"></div>
			</div>
	</table>


	<table>
		<div class="board_wrap">
			<div class="board_title">
				<h3>
					<strong>웹스타그램 게시글</strong>
				</h3>
				<h6>
					<p>글뒤에 사람이 있습니다. 신중히 써주세요.</p>
				</h6>
			</div>
			<div class="board_list_wrap">
				<div class="board_list">
					<div class="top">
						<div class="num">번호</div>
						<div class="title">제목</div>
						<div class="writer">작성자</div>
						<div class="date">작성일</div>
						<div class="count">조회</div>
					</div>
					<div>
						<div class="num">5</div>
						<div class="title">
							<a href="#">글 제목</a>
						</div>
						<div class="writer">aa</div>
						<div class="date">2023.11.15</div>
						<div class="count">00</div>
					</div>
					<div>
						<div class="num">4</div>
						<div class="title">
							<a href="#">글 제목</a>
						</div>
						<div class="writer">bb</div>
						<div class="date">2023.11.14</div>
						<div class="count">00</div>
					</div>
					<div>
						<div class="num">3</div>
						<div class="title">
							<a href="#">글 제목</a>
						</div>
						<div class="writer">cc</div>
						<div class="date">2023.11.13</div>
						<div class="count">00</div>
					</div>
					<div>
						<div class="num">2</div>
						<div class="title">
							<a href="#">글 제목</a>
						</div>
						<div class="writer">dd</div>
						<div class="date">2023.11.12</div>
						<div class="count">00</div>
					</div>
					<div>
						<div class="num">1</div>
						<div class="title">
							<a href="#">글 제목</a>
						</div>
						<div class="writer">ee</div>
						<div class="date">2023.11.11</div>
						<div class="count">00</div>
					</div>
				</div>
				<div class="board_page">
					<a href="#" class="bt first"><<</a> <a href="#" class="bt prey"><</a>
					<a href="#" class="bt num on">1</a> <a href="#" class="bt num">2</a>
					<a href="#" class="bt num">3</a> <a href="#" class="bt num">4</a> <a
						href="#" class="bt num">5</a> <a href="#" class="bt next">></a> <a
						href="#" class="bt last">>></a>
				</div>
				<div class="bt_wrap">
					<a href="./write.jsp">글쓰기</a> <a href="#" class="on">목록</a> <a
						href="#">수정</a>
				</div>
			</div>
		</div>
	</table>
</body>
</html>