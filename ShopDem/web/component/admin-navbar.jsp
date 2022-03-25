<%-- 
    Document   : admin-navbar
    Created on : Mar 17, 2021, 1:47:59 AM
    Author     : Tran Quang Khai
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://kit.fontawesome.com/c386bc4f78.js" crossorigin="anonymous"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a style="font-size: 20px; font-weight: bold;" class="navbar-brand" href="">Shop Dem</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <div class="ml-auto">
                <ul class="navbar-nav">
                    <c:if test="${account ne null}">    
                        <li style="margin-left: 950px;" class="nav-item dropdown">
                            <a style="margin-left: 10px;" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                ${account.email}
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">       
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
