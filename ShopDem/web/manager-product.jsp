<%-- 
    Document   : manager-product
    Created on : Mar 20, 2021, 11:55:56 PM
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
                        <div class="row title" style="margin-top: 4px;">
                            <div class="col-md-12">
                                <h5>Quản lý sản phẩm</h5>
                                <hr>
                            </div>
                            <div class="row mt-1">
                                <form action="search-product" method="post">
                                    <ul class="pagination justify-content-end">
                                        <select onchange="this.form.submit()" style="margin-right: 30px;" name="search">
                                            <option ${cbo == 0?"selected":""} value="0">Tất cả</option>
                                            <option ${cbo == 1?"selected":""} value="1">Còn hàng</option>
                                            <option ${cbo == 2?"selected":""} value="2">Giảm giá</option>
                                            <option ${cbo == 3?"selected":""} value="3">Hết Hàng</option>
                                            <option ${cbo == 4?"selected":""} value="4">Ngừng kinh doanh</option>
                                        </select>
                                    </ul>
                                </form>
                            </div>
                            <table c class="table table-striped">
                                <tr>
                                    <th scope="col">STT</th>
                                    <th scope="col">Mã sản phẩm</th>
                                    <th scope="col">Tên sản phẩm</th>
                                    <th scope="col">Số lượng</th>
                                    <th scope="col">Giá</th>
                                    <th scope="col">Trạng thái</th>
                                    <th scope="col">Chức năng</th>
                                <div class="container" >
                                    <c:forEach items="${requestScope.lsProduct}" var="product" varStatus="s">
                                        <tr>
                                            <td>${s.index+1}</td>
                                            <td>${product.id}</td>
                                            <td>${product.name}</td>
                                            <td>${product.quantity}</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${product.price}"/><sup>đ</sup></td>
                                            <td>
                                                <c:if test="${product.status == 1}">Còn hàng</c:if>
                                                <c:if test="${product.status == 2}">Giảm giá</c:if>
                                                <c:if test="${product.status == 3}">Hết hàng</c:if>
                                                <c:if test="${product.status == 4}">Ngừng kinh doanh</c:if>
                                                </td>
                                                <td>
                                                    <a href="details?id=${product.id}" style="text-decoration: none;" class="g-bule">Chi tiết</a>
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
                            <a class="page-link" href="manager-product?page=${page}">${page}</a>
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