<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 20/04/2024
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đổi Mật Khẩu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h2 class="text-danger">${param.message}</h2>
        <form action="changePassword" method="post">
            <div class="mb-3">
                <input type="hidden" value="${userDetail.username}" class="form-control" id="username" name="username">
            </div>
            <div class="mb-3">
                <label for="oldPassword" class="form-label">Mật Khẩu Cũ</label>
                <input type="password" placeholder="Nhập mật khẩu cũ" class="form-control" id="oldPassword" name="oldPassword">
            </div>
            <div class="mb-3">
                <label for="newPassword" class="form-label">Mật Khẩu Mới</label>
                <input type="password" placeholder="Nhập mật khẩu mới" class="form-control" id="newPassword" name="newPassword">
            </div>
            <p class="text-danger">${message}</p>
            <div class="mb-3">
                <label for="newPasswordRepeat" class="form-label">Nhập Lại Mật Khẩu</label>
                <input type="password" placeholder="Nhập lại mật khẩu mới" class="form-control" id="newPasswordRepeat" name="newPasswordRepeat">
            </div>
            <p class="text-danger">${message2}</p>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="on" id="remember-me" name="remember-me" checked>
                <label class="form-check-label" for="remember-me">
                    Ghi nhớ
                </label>
            </div>
            <button type="submit" class="btn btn-primary">Đổi Mật Khẩu</button>
        </form>
    </div>
</body>
</html>
