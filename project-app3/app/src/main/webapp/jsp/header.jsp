<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>MyList!</title>
  <link href="/css/common.css" rel="stylesheet">
</head>
<body>
<div class="container">
<div id="header">
<style>
#login-btn {
  position: absolute;
  right: 10px;
}
#logout-btn {
  position: absolute;
  right: 10px;
}
#app-title {
  font-size: 1.5em;
  font-weight: bold;
  font-style: none;
  color: white;
} 
#user-name {
  position: absolute;
  right: 90px;
}
</style>
<a href="/index.html"><span id="app-title">MyList</span></a> 
<button id="login-btn" type="button" class="not-login">로그인</button>
<span id="user-name" class="login"></span>
<button id="logout-btn" type="button" class="login">로그아웃</button>  
</div>
<div id="sidebar">
<style>
h1.sidebar {
  font-size: 1.2em;
}
</style>
<h1 class="sidebar">제목</h1>
<div class="sidebar">
<ul>
  <li>내용1</li>
  <li>내용2</li>
  <li>내용3</li>
</ul>
</div>  
</div>
<div id="content">
<h1>게시글</h1>
<a href="add">새 게시글</a>
<table id="x-board-table" border="1">
<thead>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>조회수</th>
    <th>등록일</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>2</td>
    <td><a href='detail?no=2'>좋아요</a></td>
    <td>user2</td>
    <td>1</td>
    <td>2022-04-14</td>
  </tr>
  <tr>
    <td>1</td>
    <td><a href='detail?no=1'>보드카페</a></td>
    <td>user2</td>
    <td>1</td>
    <td>2022-04-14</td>
  </tr>
</tbody>
</table>
</div>
<div id="footer">
<style>
#company-title {
  font-size: 1.2em;
  font-weight: bold;
}
#company-address {
  display: inline-block;
  width: calc(100% - 100px); 
  text-align: center; 
}
</style>
<span id="company-title">비트캠프</span> 
<address id="company-address">서울 강남구 강남대로94길 20, 삼오빌딩</address>  
</div>
</div>
</body>
</html>
