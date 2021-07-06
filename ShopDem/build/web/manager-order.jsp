<%-- 
    Document   : manager-order
    Created on : Mar 21, 2021, 12:15:12 AM
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
                        <div class="row title" style="margin-top: 5px;">
                            <div class="col-md-12">
                                <h5>Quản lý đơn hàng</h5>
                                <hr>
                            </div>
                            <div class="row mt-1">
                                <form action="search-order" method="post">
                                    <ul class="pagination justify-content-end">
                                        <select onchange="this.form.submit()" style="margin-right: 30px;" name="search">
                                            <option ${cbo == 0?"selected":""} value="0">Tất cả</option>
                                            <option ${cbo == 1?"selected":""} value="1">Đang xử lý</option>
                                            <option ${cbo == 2?"selected":""} value="2">Đang giao hàng</option>
                                            <option ${cbo == 3?"selected":""} value="3">Giao hàng thành công</option>
                                            <option ${cbo == 4?"selected":""} value="4">Đã hủy đơn hàng</option>
                                        </select>
                                    </ul>
                                </form>
                            </div>
                            <table c class="table table-striped">
                                <tr>
                                    <th scope="col">STT</th>
                                    <th scope="col">Mã hóa đơn</th>
                                    <th scope="col">Tên khách hàng</th>
                                    <th scope="col">Trạng thái</th>
                                    <th style="text-align: center;" scope="col">Chức năng</th>
                                <div class="container" >
                                    <c:forEach items="${requestScope.lsOrder}" var="order" varStatus="s">
                                        <tr>
                                            <td>${s.index+1}</td>
                                            <td>${order.id}</td>
                                            <td>${order.name}</td>
                                            <td>
                                                <c:if test="${order.status == 1}">Đang xử lý</c:if>
                                                <c:if test="${order.status == 2}">Đang giao hàng</c:if>
                                                <c:if test="${order.status == 3}">Giao hàng thành công</c:if>
                                                <c:if test="${order.status == 4}">Đã hủy đơn</c:if>
                                                </td>
                                                <td style="text-align: center;">
                                                    <c:if test="${order.status == 3 || order.status == 4}">
                                                    <button type="button" class="btn btn-danger" disabled>Update</button>
                                                </c:if>
                                                <c:if test="${order.status == 1 || order.status == 2}">
                                                    <a href="details-order?id=${order.id}" style="text-decoration: none;" class="btn btn-danger">Update</a>
                                                </c:if>
                                                <a href="detail-order?id=${order.id}" style="text-decoration: none;" class="btn btn-secondary">Chi tiết</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <nav aria-label="Page navigation example" class="mb-5">
                <ul class="pagination justify-content-end">
                    <c:forEach items="${requestScope.lsPage}" var="page">
                        <li class="page-item ${requestScope.page == page ? "active" : ""}">
                            <a class="page-link" href="manager-order?page=${page}">${page}</a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
                crossorigin="anonymous">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
                crossorigin="anonymous">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>