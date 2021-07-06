<%-- 
    Document   : admin-account
    Created on : Mar 17, 2021, 2:05:58 AM
    Author     : Tran Quang Khai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <div class="row title" style="margin-top: 4px;">
                            <div class="col-md-12">
                                <h5>Quản lý tài khoản</h5>
                                <hr>
                            </div>
                            <div class="row mt-1">
                                <form action="search-account" method="post">
                                    <ul class="pagination justify-content-end">
                                        <select onchange="this.form.submit()" style="margin-right: 30px;" name="search">
                                            <option ${cbo == 0?"selected":""} value="0">Tất cả</option>
                                            <option ${cbo == 1?"selected":""} value="1">Admin</option>
                                            <option ${cbo == 2?"selected":""} value="2">Khách hàng</option>
                                        </select>
                                    </ul>
                                </form>
                            </div>
                            <table c class="table table-striped">
                                <tr>
                                    <th scope="col">STT</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Loại</th>
                                    <th scope="col">Trạng thái</th>
                                    <th scope="col" style="text-align: center;">Chi tiết</th>
                                <div class="container" >
                                    <c:forEach items="${requestScope.listAccount}" var="account" varStatus="s">
                                        <tr>
                                            <td>${s.index+1}</td>
                                            <td>${account.email}</td>
                                            <td>${account.roleId == 1 ? "Admin" : "Khách hàng"}</td>
                                            <td>
                                                <c:if test="${account.status == 2}">
                                                    <span class="active">Đang hoạt động</span>
                                                </c:if>
                                                <c:if test="${account.status == 1}">
                                                    <span class="deactive">Chưa kích hoạt</span>
                                                </c:if>
                                                <c:if test="${account.status == 3}">
                                                    <span class="deactive">Ngừng hoạt động</span>
                                                </c:if>
                                            </td>
                                            <td style="text-align: center;">
                                                <c:if test="${account.roleId == 2}">
                                                    <c:if test="${account.status == 2}">
                                                        <a class="btn btn-success" href="block-account?type=1&id=${account.id}">Chặn tài khoản</a>
                                                    </c:if>
                                                    <c:if test="${account.status == 3}">
                                                        <a class="btn btn-danger" href="block-account?type=3&id=${account.id}">Bỏ chặn tài khoản</a>
                                                    </c:if> 
                                                </c:if>
                                                <a  class="btn btn-warning" href="block-account?type=2&id=${account.accountDetailId}">Xóa tài khoản</a>
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
                            <a class="page-link" href="manager-account?page=${page}">${page}</a>
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