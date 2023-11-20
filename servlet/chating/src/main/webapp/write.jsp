<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>웹스타그램 글쓰기</title>
    <link rel="stylesheet" href="./글쓰기(임시).css">
</head>
<body>
    <header>
        <div class="homebox">
            <div class="logo">
                <a href="./게시판.html" class="logo"><img src="" alt=""></a> <!--사진 넣으면 클릭후 이동-->
            </div>
        </div>
    </header>

    <main>
        <form class="write">
            <input type="text" placeholder="제목을 입력해주세요." required>
            <hr>
            <textarea name="content" id="ucontent" placeholder="내용을 입력해주세요." class="text" required></textarea>
            <div class="button">
                <p><a href="./board.jsp">글쓰기</a><a href="./board.jsp">취소</a></p>
            </div>
        </form>
    </main>

    <footer>
        <div class="down">
            <p>웹스타그램</p>
        </div>
    </footer>
</body>
</html>