<%-- 
    Document   : admin-index
    Created on : Mar 17, 2021, 1:48:47 AM
    Author     : Tran Quang Khai
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/user.css">
        <link rel="stylesheet" href="css/table.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

        <title>Admin</title>
    </head>
    <body>
        <%@include file="component/admin-navbar.jsp" %>
        <div class="container">
            <div class="row" style="padding-top: 100px;">
                <div class="col-md-3">
                    <div class="left-side">
                        <div class="row title">
                            <div class="col-md-12">
                                <h4>Danh mục quản lý</h4><hr>
                                <div>
                                    <a id="hai" class="nav-link" href="dash-board">Dashboard</a>
                                </div>
                                <div>
                                    <a id="hai" class="nav-link" href="manager-account">Quản lý tài khoản</a>
                                </div>
                                <div>
                                    <a id="hai" class="nav-link" href="manager-product">Quản lý sản phẩm</a>
                                </div>
                                <div>
                                    <a id="hai" class="nav-link" href="manager-order">Quản lý đơn hàng</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="right-side">
                        <div class="row title">
                            <div class="col-md-12" style="margin-top: 5px;">
                                <h5>Dashboard</h5>
                                <hr>
                            </div>
                            <div class="row mt-1">
                                <table border="0">
                                        <tr>
                                            <td><a style="font-size: 25px; width: 300px;" href="manager-product" class="btn btn-primary">Tổng số sản phẩm: ${product}</a></td>
                                            <td><a style="font-size: 25px; width: 300px;" href="manager-account" class="btn btn-primary">Tổng số tài khoản: ${ac}</a></td>
                                        </tr>
                                         <tr>
                                            <td><a style="font-size: 25px; width: 300px;" href="manager-order" class="btn btn-info">Tổng số hóa đơn: ${orderdao}</a></td>
                                            <td><button type="button" style="font-size: 25px; width: 300px;" class="btn btn-success">Tổng số đơn hàng thành công: ${success}</button></td>
                                        </tr>
                                         <tr>
                                            <td><a style="font-size: 25px; width: 300px;" href="wating-order" class="btn btn-warning">Đang chờ xử lý: ${wait}</a></td>
                                            <td><button style="font-size: 25px; width: 300px;" type="button" class="btn btn-danger">Số hóa đơn hủy hàng: ${cancel}</button></td>
                                        </tr>
                                         <tr>
                                            <td><button style="font-size: 25px; width: 300px;" type="button" class="btn btn-success">Số lượng sản phẩm còn hàng: ${productEnough}</button></td>
                                            <td><button style="font-size: 25px; width: 300px;" type="button" class="btn btn-danger">Số lượng sản phẩm hết hàng: ${productOver}</button></td>
                                        </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>
