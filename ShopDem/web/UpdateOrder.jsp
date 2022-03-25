<%-- 
    Document   : UpdateOrder
    Created on : Mar 25, 2021, 9:28:12 AM
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
                            <form action="update-order" method="get">
                                <table  class="table table-striped">
                                    <tr>
                                        <th scope="col">Mã hóa đơn</th>
                                        <th scope="col">Trạng thái</th>
                                        <th scope="col">Ngày đặt hàng</th>
                                        <th scope="col">Chức năng</th>
                                    <div class="container" >
                                        <tr>
                                            <td><input style="width: 50px;" type="text" name="id" value="${order.id}" readonly/></td>
                                            <td>
                                                <select name="cbo">
                                                    <option ${status == 1?"selected":""} value="1">Đang xử lý</option>
                                                    <option ${status == 2?"selected":""} value="2">Đang giao hàng</option>
                                                    <option ${status == 3?"selected":""} value="3">Giao hàng thành công</option>
                                                    <option ${status == 4?"selected":""} value="4">Đã hủy đơn</option>
                                                </select>
                                            </td>
                                            <td>${order.fmDate}</td>
                                            <td>
                                                <c:if test="${order.status == 3 || order.status == 4}">
                                                    <a  class="btn btn-warning" href="manager-order">Quay lại</a>
                                                </c:if>
                                                <c:if test="${order.status == 1 || order.status == 2}">
                                                    <button type="submit"  class="btn btn-outline-danger">Update</button>
                                                </c:if>
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
