<%-- 
    Document   : index
    Created on : Jan 11, 2021, 8:53:49 PM
    Author     : Tran Quang Khai
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/media.css">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/c386bc4f78.js" crossorigin="anonymous"></script>
        <title>Shop</title>
        <style>
            a:hover{
                color: #098 !important;
            }
            .card:hover{
                background: #ccc !important ;
            }
            a {
                display: block;
                text-decoration: none;
                color: #000;
            }

            .badge {
                position: absolute;
                left: 0;
                top: 20px;
                text-transform: uppercase;
                font-size: 13px;
                font-weight: 700;
                background: red;
                color: #fff;
                padding: 3px 10px;
            }
        </style>
    </head>
    <body>
        <%@include file="component/navbar.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <h4 class="mt-5" style="color: #098;">Thương hiệu</h4>
                    <c:forEach items="${requestScope.lsBrand}" var="brand">
                        <a class="mt-3" style="text-transform: uppercase; font-weight: 500; margin-left: 15px;" href="filter?id=${brand.id}&type=1">${brand.name}</a>
                    </c:forEach>
                    <h4 class="mt-5" style="color: #098;">Chất liệu</h4>
                    <c:forEach items="${requestScope.lsMaterial}" var="lsMarterial">
                        <a class="mt-3" style="text-transform: uppercase; font-weight: 500; margin-left: 15px;" href="filter?id=${lsMarterial.id}&type=4">${lsMarterial.material}</a>
                    </c:forEach>
                </div>
                <div class="col-md-10" style="margin-top: 35px; margin-bottom: 50px;">
                    <div class="row" >
                        <c:if test="${lsProduct == null}">
                            <div class="alert alert-danger mt-5 text-center" role="alert">
                                <h3>Không có sản phẩm nào</h3>
                            </div>
                        </c:if>
                        <c:if test="${lsProduct != null}">
                            <c:forEach items="${requestScope.lsProduct}" var="product">
                                <div class="col-md-3 mt-4 ">
                                    <div class="card" style="width: 252px; height: 350px;">
                                        <c:if test="${product.status == 2}">
                                            <div class="badge">Sale</div>
                                        </c:if>
                                        <c:if test="${product.status == 4}">
                                            <div class="badge">Ngừng kinh doanh</div>
                                        </c:if>
                                        <c:if test="${product.status == 3}">
                                            <div class="badge">Hết hàng</div>
                                        </c:if>
                                        <img src="asset/product/${product.imgName}" style="width: 250px;" class="card-img-top">
                                        <div class="card-body">
                                            <h5 class="card-title">
                                                <a  href="product-detail?id=${product.id}" style="text-decoration: none; color: #000;">${product.name}</a>
                                            </h5>
                                            <h5><fmt:formatNumber type="number" maxFractionDigits="3" value="${product.price}"/><sup>đ</sup></h5>
                                            <c:if test="${product.status == 1 || product.status == 2}">
                                                <a href="" class="btn btn-primary mt-2">Mua ngay</a>
                                                <a style="float: right;" href="cart?id=${product.id}" class="btn btn-danger mt-2"><i class="fas fa-cart-plus"></i></a>
                                            </c:if>
                                            <c:if test="${product.status == 3 || product.status == 4}">
                                                <!--<a dis class="btn btn-primary mt-2">Mua ngay</a>-->
                                                <button type="button" class="btn btn-primary mt-2" disabled>Mua ngay</button>
                                                <!--<a style="float: right;"  class="btn btn-danger mt-2"><i class="fas fa-cart-plus"></i></a>-->
                                                <button style="float: right;" type="button" class="btn btn-danger mt-2" disabled><i class="fas fa-cart-plus"></i></button>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
            <nav aria-label="Page navigation example" class="mb-5">
                <ul class="pagination justify-content-end">
                    <c:forEach items="${requestScope.lsPage}" var="page">
                        <li class="page-item ${requestScope.page == page ? "active" : ""}">
                            <a class="page-link" href="products?page=${page}">${page}</a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
        <%@include file="component/news.jsp" %>
        <%@include file="component/footer.jsp" %>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
                crossorigin="anonymous">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
                crossorigin="anonymous">
        </script>
        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

    </body>
</html>
