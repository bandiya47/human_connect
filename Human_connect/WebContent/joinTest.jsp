<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>

<form action="joinTest" method="post" enctype="utf-8">    
    <p>이름: <input type="text" name="uName"></p>
    <p>ID: <input type="text" name="uId"></p>
    <p>비밀번호: <input type="password" name="uPwd"></p>
    <p>이메일: <input type="text" name="uEmail"></p>
    <input type="submit" value="제출">
</form>

</body>
</html>