<%-- 
    Document   : signIn
    Created on : Sep 24, 2023, 11:36:12 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <title>Sign In</title>

        <!-- Meta-Tags -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <!-- Logo -->
        <link rel="icon" href="assets/img/header/logo1.png">
        <!-- End logo -->

        <!-- style CSS -->
        <link rel="stylesheet" href="assets/css/signIn.css" type="text/css" media="all">
        <!-- google fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;500;700&display=swap" rel="stylesheet">
    </head>
    <!-- //Head -->

    <!-- Body -->

    <body>
        <c:set var="cookie" value="${pageContext.request.cookies}"/>
        <section class="main">
            <div class="content-w3ls text-center">
                <img src="assets/img/header/logo1.png" alt="Family House" class="img-responsive align-content-center"/>
                <div class="logo text-center">
                    <h1> <a href="">LOGIN</a></h1>
                    <h3 style="color: red">${requestScope.msg}</h3>
                </div>
                <form action="login" method="post">
                    <div class="wthree-field">
                        <input name="username" id="username" type="text" value="${cookie.cuser.value}" placeholder="Username" required>
                    </div>
                    <div class="wthree-field">
                        <input name="password" id="password" type="password" value="${cookie.cpass.value}" placeholder="Password">
                    </div>
                    <div class="wthree-field">
                        <button type="submit" class="btn">Sign In</button>
                    </div>
                    <div class="login-bottom">
                        <a href="signUp.jsp" class="">Don't have an account? Create An Account</a>
                    </div>
                </form>
            </div>
        </section>
    </body>
    <!-- //Body -->
</html>
