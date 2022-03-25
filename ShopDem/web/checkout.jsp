<%-- 
    Document   : checkout.jsp
    Created on : Sep 26, 2019, 8:06:05 PM
    Author     : Shado
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<fmt:setLocale value="vi_VN"/>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/common.css">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/c386bc4f78.js" crossorigin="anonymous"></script>
        <title>Cart</title>
        <style>
            .display{display:block;}
            .hide{display:none;}
            /*            .mt{margin-top:10px;}*/
        </style>
    </head>
    <body>
        <%@include file="component/navbar.jsp" %>
        <div class="container" style="padding-top: 50px;">
            <c:choose>
                <c:when test="${sessionScope.lsCart eq null}">
                    <h3>Giỏ hàng trống.</h3>
                </c:when>
                <c:otherwise>
                    <h3>Giỏ hàng</h3>
                    <table class="w-100">
                        <tr>
                            <th style="border: 1px solid #000;">No</th>
                            <th style="border: 1px solid #000;">Image</th>
                            <th style="border: 1px solid #000;">Name</th>
                            <th style="border: 1px solid #000;">Price</th>
                            <th style="border: 1px solid #000;">Quantity</th>
                            <th style="border: 1px solid #000;">Total Price</th>
                        </tr>
                        <c:forEach items="${sessionScope.lsCart}" var="cart" varStatus="track">
                            <tr >
                                <td style="border: 1px solid #000;">${track.count}</td>
                                <td style="border: 1px solid #000;"><img src="asset/product/${cart.imgName}"></td>
                                <td style="border: 1px solid #000;">${cart.name}</td>
                                <td style="border: 1px solid #000;"><fmt:formatNumber type="number" maxFractionDigits="3" value="${cart.price}"/><sup>đ</sup></td>
                                <td style="border: 1px solid #000; text-align: center;">${cart.quantily}</td >
                                <td style="border: 1px solid #000;"><fmt:formatNumber type="number" maxFractionDigits="3" value="${cart.quantily * cart.price}"/><sup>đ</sup></td>
                            </tr> 
                        </c:forEach>
                        <tr>
                            <td colspan="8" style="text-align: right; font-size: 18px; font-weight: bold; padding-bottom: 15px; padding-top: 15px;">
                                <span>Tổng tiền: <fmt:formatNumber type="number" maxFractionDigits="3" value="${totalMoney}"/><sup>đ</sup></span>
                            </td>
                        </tr>
                    </table>
                    <h3 style="margin-top: 40px;">Thông tin khách hàng</h3>
                    <form action="check-out" method="post" class="checkout-info">
                        <table>
                            <tr>
                                <td>Họ và tên</td>
                                <td>
                                    <input value="${accountDetailInfo.name}" class="input" type="text" name="name" />
                                </td>
                                <td>Số điện thoại</td>
                                <td>
                                    <input value="${accountDetailInfo.mobile}" class="input" type="text" name="mobile" />
                                </td>
                            </tr>
                            <tr>
                                <td>Địa chỉ</td>
                                <td colspan="6">
                                    <input value="${accountDetailInfo.address}" class="input" name="address" rows="3"></input>
                                </td>
                            </tr>
                            <tr>
                                <td>Hình thức thanh toán</td>
                                <td colspan="6">
                                    <input style="color: black;" type="radio" onclick="ShowAndHideDiv('payment', 'show')" name="payment" value="0" /> <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Visa_Inc._logo.svg/2560px-Visa_Inc._logo.svg.png">
                                    <input type="radio" name="payment" value="1" onclick="ShowAndHideDiv('payment', 'hide')" /> <img src="https://i0.wp.com/www.merchantfraudjournal.com/wp-content/uploads/2019/07/paypal_1562009340.png?fit=1280%2C640&ssl=1">
                                </td>
                            </tr>
                            <tr id="payment" class="hide">
                                <td>Số thẻ</td>
                                <td>
                                    <input value="" class="input" type="text" name="" />
                                </td>
                                <td>Ngày phát hành</td>
                                <td>
                                    <input value="" class="input" type="text" name="" />
                                </td>
                            </tr>
                            <tr>
                                <td>Mã giảm giá (nếu có)</td>
                                <td colspan="6">
                                   <input value="" class="input" name="" rows="3"></input>
                                </td>
                            </tr>
                            <tr>
                                <td>Ghi chú</td>
                                <td colspan="6">
                                    <textarea class="input-area" name="note" rows="3"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td colspan="6" style="text-align: center;">
                                    <button class="btn btn-success w-25 h-50 mt-2" btn-lg>Xác nhận</button>
                                </td>
                            </tr>
                        </table>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
        <script type="text/javascript">
                                        function ShowAndHideDiv(obj, s) {
                                            var element = document.getElementById(obj);
                                            if (element.className == "display") {
                                                if (s == "hide") {
                                                    element.className = "hide";
                                                } else {
                                                    element.className = "display";
                                                }
                                            } else {
                                                if (s == "show") {
                                                    element.className = "display";
                                                } else {
                                                    element.className = "hide";
                                                }
                                            }
                                        }
        </script>
    </body>
</html>
