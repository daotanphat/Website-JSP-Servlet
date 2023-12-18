<%-- 
    Document   : Information
    Created on : Oct 12, 2023, 12:34:10 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <!-- Head -->
    <head>

        <title>Custom Signup Form A Flat Responsive Widget Template :: W3layouts</title>

        <!-- Meta-Tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="keywords" content="Custom Signup Form Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //Meta-Tags -->

        <!-- Custom-Style-Sheet -->
        <link rel="stylesheet" href="assets/css/information.css" type="text/css" media="all">
        <link rel="stylesheet" href="assets/css/jquery-ui.css" type="text/css" media="all">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/templatemo.css">
        <link rel="stylesheet" href="assets/css/custom.css">
        <!-- //Custom-Style-Sheet -->

        <!-- Fonts -->
        <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900" type="text/css" media="all">
        <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Montserrat:400,700" type="text/css" media="all">
        <!-- //Fonts -->

    </head>
    <!-- //Head -->



    <!-- Body -->
    <body>
        <%@include file="header.jsp"%>
        <c:set var="u" value="${sessionScope.user}" />
        <div class="information">
            <h1> USER INFORMATION</h1>

            <div class="containerw3layouts-agileits">
                <form action="user-information" method="post" enctype="multipart/form-data">
                    <div class="w3imageaits">
                        <img class="user" src="${u.avatar}" alt="Custom Signup Form"/>
                        <input type="file" name="avatar" />
                        <h2>Let's get you set up</h2>
                        <p>It should only take you a minute to connect</p>
                    </div>

                    <div class="aitsloginwthree w3layouts agileits">

                        <input type="text" name="name" placeholder="Name" value="${u.name}" required=""/>
                        <div class="radio-btns agileits w3layouts">
                            <div class="cc-selector wthreeselector">
                                <p>Gender</p>
                            </div>
                            <div class="cc-selector wthreeselector">
                                <input id="visa" type="radio" name="credit-card" ${u.gender?'checked':''} value="true"/>
                                <label class="drinkcard-cc visa" for="visa"></label>
                            </div>
                            <div class="cc-selector wthreeselector">
                                <input id="mastercard" type="radio" name="credit-card" ${u.gender?'':'checked'} value="false"/>
                                <label class="drinkcard-cc mastercard" for="mastercard"></label>
                            </div>
                        </div>
                        <div class="wthreedob">
                            <input class="date agileits w3layouts" id="datepicker1" name="date" type="text" placeholder="Date" value="${u.date}" required=""/>
                        </div>
                        <input type="text" name="address" placeholder="Address" value="${u.address}" required=""/>
                        <input class="fill email" type="text" name="email" value="${u.email}" placeholder="Email" required=""/>
                        <input class="fill tel" name="phone" placeholder="Phone" value="${u.phone}" required=""/>
                        <div class="send-button wthree agileits">
                            <input type="submit" value="Save">
                        </div>

                    </div>
                </form>

                <div class="clear"></div>

            </div>

            <div class="w3lsfooteragileits">

            </div>
        </div>

        <%@include file="footer.jsp" %>

        <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
        <!-- Start Script -->
        <script src="assets/js/jquery-1.11.0.min.js"></script>
        <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/templatemo.js"></script>
        <script src="assets/js/custom.js"></script>
        <!-- End Script -->

    </body>
    <!-- //Body -->
</html>
