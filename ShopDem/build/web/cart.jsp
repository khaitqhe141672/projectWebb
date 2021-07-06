<%-- 
    Document   : cart
    Created on : Mar 12, 2021, 10:06:41 AM
    Author     : Admin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/common.css">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <title>Cart</title>
    </head>
    <body>
        <%@include file="component/navbar.jsp" %>
        <c:if test="${sessionScope.lsCart eq null}">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center mt-5">
                        <h4>Không có sản phẩm nào trong giỏ hàng</h4>
                        <a class="btn btn-info mt-3" href="products">Tiếp tục mua hàng</a>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${sessionScope.lsCart != null}">
            <div class="container" style="padding-top: 50px;">
                <div class="row">
                    <h3 >Giỏ hàng</h3>
                    <table class="w-100">
                        <tr>
                            <th style="border: 1px solid #000;">No</th>
                            <th style="border: 1px solid #000;">Image</th>
                            <th style="border: 1px solid #000;">Name</th>
                            <th style="border: 1px solid #000;">Price</th>
                            <th style="border: 1px solid #000;">Quantity</th>
                            <th style="border: 1px solid #000;">Total Price</th>
                            <th style="border: 1px solid #000;">Action</th>
                        </tr>
                        <c:forEach items="${sessionScope.lsCart}" var="cart" varStatus="track">
                            <tr >
                                <td style="border: 1px solid #000;">${track.count}</td>
                                <td style="border: 1px solid #000;"><img src="asset/product/${cart.imgName}"></td>
                                <td style="border: 1px solid #000;">${cart.name}</td>
                                <td style="border: 1px solid #000;"><fmt:formatNumber type="number" maxFractionDigits="3" value="${cart.price}"/><sup>đ</sup></td>
                                <td style="border: 1px solid #000; text-align: center;"> <a style="text-decoration: none;" href="update?flag=1&id=${cart.id}">-</a>
                                    ${cart.quantily}
                                    <a style="text-decoration: none;" href="update?flag=2&id=${cart.id}">+</a>
                                </td >
                                <td style="border: 1px solid #000;"><fmt:formatNumber type="number" maxFractionDigits="3" value="${cart.quantily * cart.price}"/><sup>đ</sup></td>
                                <td style="border: 1px solid #000;"><a style=" text-decoration: none;" href="remove-cart?id=${cart.id}">Xoá</a></td>
                            </tr> 
                        </c:forEach>
                        <tr>
                            <td colspan="8" style="text-align: right; font-size: 18px; font-weight: bold; padding-bottom: 15px; padding-top: 15px;">
                                <span>Tổng tiền: <fmt:formatNumber type="number" maxFractionDigits="3" value="${sessionScope.totalMoney}"/><sup>đ</sup></span>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <a style="width: 200px; height: 40px;" class="btn btn-warning mt-4" href="products"> Tiếp tục mua hàng</a>
                    </div>
                    <div class="col-md-6 text-end">
                        <a style="width: 150px; height: 40px;" class="btn btn-danger me-5 mt-4" href="remove-cart?id=0">Xóa tất cả</a>
                        <a style="width: 200px; height: 40px;" class="btn btn-warning mt-4" href="checkout.jsp">Tiếp tục thanh toán</a>
                    </div>
                </div>
            </c:if>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>