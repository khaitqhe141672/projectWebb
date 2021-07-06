<%-- 
    Document   : user-index
    Created on : Mar 23, 2021, 4:51:38 PM
    Author     : Tran Quang Khai
--%>

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
        <title>Trang cá nhân</title>
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
                                <h5>Thông tin tài khoản</h5>
                                <hr>
                            </div>
                        </div>
                        <div class="row mt-1">
                            <div class="col-md-12">
                                <div class="m-info">
                                    <table class="table table-borderless">
                                        <tr>
                                            <td>Email:</td>
                                            <td><b>${account.email}</b></td>
                                        </tr>

                                        <tr>
                                            <td>Loại tài khoản:</td>
                                            <td>${account.roleId == 1 ? "Admin" : "Khách hàng"}</td>
                                        </tr>
                                        <tr>
                                            <td>Trạng thái:</td>
                                            <td>
                                                <c:if test="${account.status == 1}">
                                                    <span class="active">Đang hoạt động</span>
                                                </c:if>
                                                <c:if test="${account.status != 1}">
                                                    <span class="deactive">Ngừng hoạt động</span>
                                                </c:if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Ngày tạo:</td>
                                            <td>${loginAccount.fmDate}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="row title">
                            <div class="col-md-12" style="margin-top: 20px;">
                                <h5>Thông tin cá nhân</h5>
                            </div>
                        </div> 
                        <div class="row mt-1">
                            <div class="col-md-12">
                                <div class="m-info">
                                    <table class="table table-borderless">
                                        <tr>
                                            <td>Họ và tên:</td>
                                            <td><b>${accountDetailInfo.name}</b></td>
                                        </tr>
                                        <tr>
                                            <td>Số điện thoại:</td>
                                            <td>${accountDetailInfo.mobile}</td>
                                        </tr>
                                        <tr>
                                            <td>Giới tính:</td>
                                            <td>${accountDetailInfo.gender == 1 ? "Nam" : "Nữ"}</td>
                                        </tr>
                                        <tr>
                                            <td>Địa chỉ:</td>
                                            <td>${accountDetailInfo.address}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>
