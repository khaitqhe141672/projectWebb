<%-- 
    Document   : details-order
    Created on : Mar 30, 2021, 12:12:34 AM
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
                            <div class="row title">
                                <div class="col-md-12">
                                    <h5>Thông tin cá nhân</h5>
                                    <hr>
                                </div>
                            </div> 
                            <div class="row mt-1">
                                <div class="col-md-12">
                                    <div class="m-info">
                                        <table class="table table-borderless">
                                            <tr>
                                                <td>Họ và tên:</td>
                                                <td><b>${accountDetails.name}</b></td>
                                            </tr>
                                            <tr>
                                                <td>Số điện thoại:</td>
                                                <td>${accountDetails.mobile}</td>
                                            </tr>
                                            <tr>
                                                <td>Giới tính:</td>
                                                <td>${accountDetails.gender == 1 ? "Nam" : "Nữ"}</td>
                                            </tr>
                                            <tr>
                                                <td>Địa chỉ:</td>
                                                <td>${accountDetails.address}</td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12" style="margin-top: 30px;">
                                <h5>Chi tiết đơn hàng</h5>
                                <hr>
                            </div>
                            <table c class="table table-striped">
                                <tr>
                                    <th scope="col">Mã hóa đơn</th>
                                    <th scope="col">Tên sản phẩm</th>
                                    <th scope="col">Số lượng</th>
                                    <th scope="col">Tổng tiền</th>
                                    <th scope="col">Trạng thái</th>
                                    <th scope="col">Ngày mua hàng</th>
                                </tr>
                                <div class="container" >
                                    <c:forEach items="${requestScope.orderDetail}" var="od">
                                        <tr>
                                            <td style="text-align: center;">${od.orderId}</td>
                                            <td style="text-align: center;">${od.productName}</td>
                                            <td style="text-align: center;">${od.quantity}</td>
                                            <td style="text-align: center;"><fmt:formatNumber type="number" maxFractionDigits="3" value="${od.productPrice}"/><sup>đ</sup></td>
                                            <td style="text-align: center;">
                                                <c:if test="${order.status == 1}">Đang xử lý</c:if>
                                                <c:if test="${order.status == 2}">Đang giao hàng</c:if>
                                                <c:if test="${order.status == 3}">Giao hàng thành công</c:if>
                                                <c:if test="${order.status == 4}">Đã hủy đơn</c:if>
                                                </td>
                                                <td>${order.fmDate}</td> 
                                        </tr>
                                    </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>