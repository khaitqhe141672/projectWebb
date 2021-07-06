<%-- 
    Document   : login
    Created on : Mar 14, 2021, 2:04:51 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/Login.css">
        <link rel="stylesheet" href="css/style.css">
        <title>Login</title>
    </head>

    <body>
        <div id="particles-js">
            <div id="intro">
                <div class="middle signin">
                    <div class="login-panel">
                        <div class="logo text-center">
                            <a href="products">Shop Dem</a>
                        </div>
                        <p class="notification">${mess} &nbsp; </p>
                        <form action="login" method="post">
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="Nhập Email" name="email">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Nhập mật khẩu" name="password">
                            </div>
                            <div class="form-group">
                                <div class="col">
                                    <button type="submit" class="btn btn-sm">
                                        <i class="fas fa-sign-in-alt mr-1"></i> Đăng nhập
                                    </button>
                                </div>
                            </div>
                            <div class="form-group" style="margin-top: 10px;">
                                <div class="col">
                                    <a class="link-effect mt-1 mr-1" href="forgetpassword.jsp">
                                        Quên mật khẩu?
                                    </a>
                                    <a style="margin-left: 115px;" class="link-effect mt-1 float-right" href="Register.jsp">
                                        Đăng ký
                                    </a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div style="height: 500px; background-color: #fff;"></div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/particles.js/2.0.0/particles.min.js"></script>
        <script src="js/j.js"></script>

    </body>
</html>