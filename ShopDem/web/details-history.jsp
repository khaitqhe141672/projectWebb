<%-- 
    Document   : details-history
    Created on : Mar 26, 2021, 2:39:13 AM
    Author     : Tran Quang Khai
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
        <title>Chi tiết hóa đơn</title>
    </head>
    <body>
        <%@include file="component/navbar.jsp" %>
        <div class="container">
            <div class="row" style="padding-top: 100px;">
                <div class="col-md-3">
                    <div class="left-side">
                        <div class="row title">
                            <div class="col-md-12">
                                <h4>Thông tin chung</h4><hr>
                                <div>
                                    <a id="hai" class="nav-link" href="user-index.jsp">Thông tin cá nhân</a>
                                </div>
                                <div>
                                    <a id="hai" class="nav-link" href="user-order">Đơn hàng</a>
                                </div>
                                <div>
                                    <a id="hai" class="nav-link" href="user-history">Lịch sử mua hàng</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="right-side">
                        <div class="row title">
                            <div style="margin-top: 5px;" class="col-md-12">
                                <h5>Lịch sử mua hàng</h5>
                                <hr>
                            </div>
                        </div>
                        <div class="row mt-1">
                            <div class="col-md-12">
                                <div class="m-info">
                                    <table c class="table table-striped">
                                        <tr>
                                            <th scope="col">STT</th>
                                            <th scope="col">Mã đơn</th>
                                            <th scope="col">Ngày mua</th>
                                            <th scope="col">Giá trị</th>
                                            <th scope="col">Số lượng</th>
                                        <div class="container" >
                                            <c:forEach items="${requestScope.lsOrder}" var="ls" varStatus="s">
                                                    <tr>
                                                        <td>${s.index+1}</td>
                                                        <td>${ls.orderId}</td>
                                                        <td>${ls.productName}</td>
                                                        <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${ls.productPrice}"/><sup>đ</sup></td>
                                                        <td>${ls.quantity}</td>
                                                    </tr>
                                            </c:forEach>
                                    </table>
                                    <a style="margin-top: 10px;"  href="user-history" class="btn btn-warning">Quay lại</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <nav aria-label="Page navigation example" class="mb-5">
                <ul class="pagination justify-content-end">
                    <c:forEach items="${requestScope.lsPage}" var="page">
                        <li class="page-item ${requestScope.page == page ? "active" : ""}">
                            <a class="page-link" href="user-history?page=${page}">${page}</a>
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
