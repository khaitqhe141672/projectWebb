<%-- 
    Document   : navbar
    Created on : Jan 29, 2021, 1:56:58 PM
    Author     : Admin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://kit.fontawesome.com/c386bc4f78.js" crossorigin="anonymous"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a style="font-size: 20px; font-weight: bold;" class="navbar-brand" href="products">Shop Dem</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <div class="ml-auto">
                <ul class="navbar-nav">
                    <form class="form-inline mr-3" action="search" method="get">
                        <div class="input-group">
                            <input style="margin-left: 300px;" type="text" class="form-control" name="input-text" placeholder="Tìm kiếm">
                            <div class="input-group-append">
                                <button type="submit" name="btn-search" class="input-group-text">Search</button>
                            </div>
                        </div>
                    </form>
                    <li class="nav-item dropdown">
                        <a style="margin-left: 50px;" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Sắp xếp
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="mt-3" style="text-transform: uppercase; font-weight: 500; margin-left: 15px;" href="sort?type=3" >Tăng dần</a></li>
                            <li><a class="mt-3" style="text-transform: uppercase; font-weight: 500; margin-left: 15px;" href="sort?type=4" >Giảm dầns</a></li>
                        </ul>
                    </li>
                    <li style="margin-left: 150px;" class="nav-item mr-2">
                        <a class="nav-link" href="cart.jsp">
                            <i class="fas fa-shopping-cart" style="font-size: 22px;"><span class="badge rounded-pill bg-danger">${sessionScope.totalProduct}</span></i>
                        </a>
                    </li>
                    <c:if test="${account ne null}">    
                        <li class="nav-item dropdown">
                            <a style="margin-left: 10px;" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                ${account.email}
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="user-index.jsp">Thông tin tài khoản</a></li>
                                <li><a class="dropdown-item" href="logout">Đăng xuất</a></li>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${account eq null}">
                        <li style="margin-left: 50px;" class="nav-item">
                            <a  class="nav-link" href="Register.jsp">Đăng ký</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Đăng nhập</a>
                        </li>
                    </c:if>  
                </ul>
            </div>
        </div>
    </div>
</nav>
