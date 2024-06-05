<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body class="loginBody">
<main>
	<img src="./img/logo.png" width="750px" alt="�ΰ�">
    <form action="login" method="post">
        <div>
            <label for="userId">���̵�</label>
            <input type="text" id="userId" name="userId" required>
        </div>
        <div>
            <label for="password">��й�ȣ</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <button type="submit">�α���</button>
        </div>
        <c:if test="${param.error != null}">
            <div style="color: red;">Invalid userId or password</div>
        </c:if>
        </main>
    </form>
</body>
</html>