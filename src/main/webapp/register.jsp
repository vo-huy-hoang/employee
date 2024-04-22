<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 19/04/2024
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

</head>
<body>
    <div class="container">
        <h2 class="text-danger">${param.message}</h2>
        <form action="register" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Tên Đăng Nhập</label>
                <input type="text" value="${username}" placeholder="Tên Tài Khoản" class="form-control" id="username" name="username">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Mật Khẩu</label>
                <input type="password" placeholder="Mật Khẩu" class="form-control" id="password" name="password">
            </div>
            <p class="text-danger">${message}</p>
            <div class="mb-3">
                <label for="passwordRepeat" class="form-label">Nhập Lại Mật Khẩu</label>
                <input type="password" placeholder="Nhập Lại Mật Khẩu" class="form-control" id="passwordRepeat" name="passwordRepeat">
            </div>
            <p class="text-danger">${message2}</p>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="on" id="remember-me" name="remember-me" checked>
                <label class="form-check-label" for="remember-me">
                    Ghi nhớ
                </label>
            </div>
            <button type="submit" class="btn btn-primary">Đăng Ký</button>
        </form>
    </div>
</body>
</html>
