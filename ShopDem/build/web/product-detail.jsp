<%-- 
    Document   : Index
    Created on : Jan 11, 2021, 9:16:26 PM
    Author     : Admin
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="Entity.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html> 
<html lang="en">
    <head>
        <!-- Required meta tags -->

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/product-details.css">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

        <title>Hello, world!</title>
        <!--        khi di chuyen con trỏ chuột đén thì tạo hiệu ứng chuyển màu-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            * {box-sizing: border-box;}

            .img-magnifier-container {
                position:relative;
            }

            .img-magnifier-glass {
                position: absolute;
                border: 3px solid #000;
                border-radius: 50%;
                cursor: none;
                /*Set the size of the magnifier glass:*/
                width: 100px;
                height: 100px;
            }
        </style>
        <script>
            function magnify(imgID, zoom) {
                var img, glass, w, h, bw;
                img = document.getElementById(imgID);
                /*create magnifier glass:*/
                glass = document.createElement("DIV");
                glass.setAttribute("class", "img-magnifier-glass");
                /*insert magnifier glass:*/
                img.parentElement.insertBefore(glass, img);
                /*set background properties for the magnifier glass:*/
                glass.style.backgroundImage = "url('" + img.src + "')";
                glass.style.backgroundRepeat = "no-repeat";
                glass.style.backgroundSize = (img.width * zoom) + "px " + (img.height * zoom) + "px";
                bw = 3;
                w = glass.offsetWidth / 2;
                h = glass.offsetHeight / 2;
                /*execute a function when someone moves the magnifier glass over the image:*/
                glass.addEventListener("mousemove", moveMagnifier);
                img.addEventListener("mousemove", moveMagnifier);
                /*and also for touch screens:*/
                glass.addEventListener("touchmove", moveMagnifier);
                img.addEventListener("touchmove", moveMagnifier);
                function moveMagnifier(e) {
                    var pos, x, y;
                    /*prevent any other actions that may occur when moving over the image*/
                    e.preventDefault();
                    /*get the cursor's x and y positions:*/
                    pos = getCursorPos(e);
                    x = pos.x;
                    y = pos.y;
                    /*prevent the magnifier glass from being positioned outside the image:*/
                    if (x > img.width - (w / zoom)) {
                        x = img.width - (w / zoom);
                    }
                    if (x < w / zoom) {
                        x = w / zoom;
                    }
                    if (y > img.height - (h / zoom)) {
                        y = img.height - (h / zoom);
                    }
                    if (y < h / zoom) {
                        y = h / zoom;
                    }
                    /*set the position of the magnifier glass:*/
                    glass.style.left = (x - w) + "px";
                    glass.style.top = (y - h) + "px";
                    /*display what the magnifier glass "sees":*/
                    glass.style.backgroundPosition = "-" + ((x * zoom) - w + bw) + "px -" + ((y * zoom) - h + bw) + "px";
                }
                function getCursorPos(e) {
                    var a, x = 0, y = 0;
                    e = e || window.event;
                    /*get the x and y positions of the image:*/
                    a = img.getBoundingClientRect();
                    /*calculate the cursor's x and y coordinates, relative to the image:*/
                    x = e.pageX - a.left;
                    y = e.pageY - a.top;
                    /*consider any page scrolling:*/
                    x = x - window.pageXOffset;
                    y = y - window.pageYOffset;
                    return {x: x, y: y};
                }
            }
        </script>
    </head>
    <body>
        <%@include file="component/navbar.jsp" %>

        <!--container co chuc nang la thu nhỏ hoac phong to hai bên le cua trang web-->
        <div id="main-contain" class="container">
            <c:if test="${lsProduct eq null}">
                <div class="row">
                    <div class="col-md-12">
                        <h4 class="text-center">Không tìm thấy sản phẩm nào.</h4>
                        <h6 class="text-center"><a href="products">Quay lại ></a></h6>
                    </div>
                </div>
            </c:if>
            <c:if test="${lsProduct ne null}">
                <div class="row">
                    <div class="col-md-6" style="margin-top: 60px;">
                        <div class="img mg-top-15">
                            <div class="container-img">
                                <div class="img-magnifier-container">
                                    <img id="myimage" src="asset/product/${requestScope.lsProduct.imgName}" width="600" height="400">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="product-details">
                            <h3>${lsProduct.name}</h3>
                            <p class="price">Giá: <fmt:formatNumber type="number" maxFractionDigits="3" value="${lsProduct.price}"/><sup>đ</sup>
                                <c:if test="${lsProduct.status == 2}">
                                    <span class="badge badge-success mg-left-10">SALE</span>
                                </c:if>
                            </p>
                            <div > Số lượng: 
                                <button type="button" class="minus">-</button>
                                <input type="number" id="quantity_6060b852c5672" style="width: 50px;" class="input-text qty text" step="1" min="1" max="10" name="quantity" value="1" title="SL" size="4" placeholder="" inputmode="numeric">
                                <button type="button" class="plus">+</button>
                            </div>
                            <a href="cart?id=${lsProduct.id}" class="btn-add-to-cart">
                                <i class="fas fa-cart-plus fa-fw fa-lg mg-right-5"></i> Thêm vào giỏ hàng
                            </a>
                            <div class="row">
                                <div class="col-md-12 info">
                                    <p class="description bd-t pt-3">
                                        <label>Chi tiết sản phẩm</label>
                                        <span>${lsProduct.description}</span>
                                    </p>
                                    <p class="local bd-t pt-3">
                                        <label>Mua hàng trực tiếp tại cửa hàng</label>
                                    <ul>
                                        <li>133 Thái Hà, Phường Trung Liệt, Q.Đống Đa, Hà Nội</li>
                                    </ul>
                                    </p>
                                    <p class="refund bd-t pt-3">
                                        <label>Giao hàng và trả lại hàng</label>
                                    <ul>
                                        <li>Đổi hàng trong vòng 72h</li>
                                        <li>Phí vận chuyển nội thành Hà Nội: 20.000 </li>
                                        <li>Phí vận chuyển ngoại thành/ngoại tỉnh: tùy thuộc vào địa điểm</li>
                                        <li>Thanh toán khi nhận hàng</li>
                                    </ul>
                                    </p>
                                    <p class="bd-t"></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
        <script>
            /* Initiate Magnify Function
             with the id of the image, and the strength of the magnifier glass:*/
            magnify("myimage", 3);
        </script>
    </body>
</html>
