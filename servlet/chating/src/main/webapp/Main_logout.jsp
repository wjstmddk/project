<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>MAIN2</title>
    <link rel="stylesheet" href="mainStyle.css" />
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <button id="loginbnt">로그인</button>
  </head>

  <body>
    <h1>Webstagram</h1>
    <div id="wrapper">
      <nav>
        <ul>
          <li><a href="#">Home</a></li>
          <!-- 각 링크의 href 속성에 실제 페이지 주소를 추가 -->
          <li><a href="./Join.html">회원가입</a></li>
          <li><a href="#">내정보</a></li>
        </ul>
      </nav>

      <section>
        <!-- 기타 섹션 내용은 필요에 따라 추가 또는 수정 -->
        <article>
          <h2>인기 게시글</h2>
          <div>
            <p>구현하기</p>
          </div>
        </article>

        <article>
          <h2>좋아요를 가장 많이 받은 회원</h2>
          <table>
            <tr>
              <th>번호</th>
              <th>아이디</th>
              <th>좋아요 수</th>
            </tr>
            <tr>
              <td>1</td>
              <td>전승아</td>
              <td>9999</td>
            </tr>
            <tr>
              <td>2</td>
              <td>유예슬</td>
              <td>2000</td>
            </tr>
            <tr>
              <td>3</td>
              <td>이인영</td>
              <td>1000</td>
            </tr>
            <tr>
              <td>4</td>
              <td>전명진</td>
              <td>500</td>
            </tr>
            <tr>
              <td>5</td>
              <td>이창현</td>
              <td>9</td>
            </tr>
          </table>
        </article>
      </section>
    </div>
    <footer>
      <h2>Copyright &copy; 승아TEAM 세미프로젝트</h2>
    </footer>
    <script>
      $("#loginbnt").click(() => {
        location.href = "login.jsp";
      });
    </script>
  </body>
</html>