<%-- 
    Document   : updateProduct
    Created on : Mar 24, 2021, 10:21:53 PM
    Author     : Tran Quang Khai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
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
                                    <a id="hai" class="nav-link" href="admin-index.jsp">Dashboard</a>
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
                        <div class="row title" style="margin-top: 5px;">
                            <div class="col-md-12">
                                <h5>Quản lý sản phẩm</h5>
                                <hr>
                            </div>
                            <form action="updateProduct" method="get">
                                <table  class="table table-striped">
                                    <tr>
                                        <th scope="col">Mã sản phẩm</th>
                                        <th scope="col">Tên sản phẩm</th>
                                        <th scope="col">Số lượng</th>
                                        <th scope="col">Giá</th>
                                        <th scope="col">Trạng thái</th>
                                        <th scope="col">Chức năng</th>
                                    <div class="container" >
                                        <tr>
                                            <td><input style="width: 50px;" type="text" name="id" value="${product.id}" readonly/></td>
                                            <td>${product.name}</td>
                                            <td><input style="width: 50px;" type="text" name="quantity" value="${product.quantity}" /></td>
                                            <td><input style="width: 100px;" type="text" name="price" value="${product.price}" /></td>
                                            <td>
                                                <select name="cbo">
                                                    <option ${product.status == 1?"selected":""} value="1">Còn hàng</option>
                                                    <option ${product.status == 2?"selected":""} value="2">Giảm giá</option>
                                                    <option ${product.status == 3?"selected":""} value="3">Hết hàng</option>
                                                    <option ${product.status == 4?"selected":""} value="4">Ngừng kinh doanh</option>
                                                </select>
                                            </td>
                                            <td>
                                                <button type="submit"  class="btn btn-outline-danger">Update</button>
                                            </td>
                                        </tr>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>