<%-- 
    Document   : changePass
    Created on : Oct 12, 2023, 9:03:10 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Tool Sign In Form Responsive Widget Template :: w3layouts</title>
        <!-- Meta-Tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8">
        <meta name="keywords" content="Tool Sign In Form a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
        <script>
            addEventListener("load", function () {
                setTimeout(hideURLbar, 0);
            }, false);

            function hideURLbar() {
                window.scrollTo(0, 1);
            }
        </script>
        <!-- //Meta-Tags -->

        <link rel="icon" href="assets/img/header/logo1.png">

        <!-- Stylesheets -->
        <link href="assets/css/changepass.css" rel='stylesheet' type='text/css' />
        <link rel="stylesheet" href="assets/css/jquery-ui.css" type="text/css" media="all">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/templatemo.css">
        <link rel="stylesheet" href="assets/css/custom.css">
        <!--// Stylesheets -->
        <!--fonts-->
        <link href="//fonts.googleapis.com/css?family=Poiret+One&amp;subset=cyrillic,latin-ext" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">
        <!--//fonts-->
    </head>

    <body>
        <%@include file="header.jsp"%>

        <h1>Change password</h1>
        <h4 style="color: greenyellow">${requestScope.success}</h4>
        <div class="w3ls-login box box--big">
            <!-- form starts here -->
            <form action="changepass" method="post">
                <div class="agile-field-txt">
                    <label> Username</label>
                    <input type="text" readonly="" name="name" placeholder="Enter User Name" value="${sessionScope.user.username}"/>
                </div>
                <div class="agile-field-txt">
                    <label> Old password</label> <br/>
                    <h6>${requestScope.msg}</h6>
                    <input type="password" name="oldpass" placeholder="Enter old password" required="" />
                </div>
                <div class="agile-field-txt">
                    <label> New password</label>
                    <input type="password" id="newpass" name="newpass" placeholder="Enter new password" required="" />
                </div>
                <div class="agile-field-txt">
                    <label> Confirm new password</label> <br/>
                    <h6 id="msg"></h6>
                    <input type="password" id="confirmpass" name="confirmpass" onkeyup="confirmPass()" placeholder="Confirm password" required="" />
                </div>
                <input type="submit" value="SAVE">
            </form>
        </div>
        <!-- //form ends here -->
        <!--copyright-->
        <div class="copy-wthree">

        </div>
        <!--//copyright-->

        <%@include file="footer.jsp"%>

        <script>
            function confirmPass() {
                pass = document.getElementById("newpass").value;
                confirmpass = document.getElementById("confirmpass").value;
                if (pass != confirmpass) {
                    document.getElementById("msg").innerHTML = "Confirm password doesn't match! Re-confirm password.";
                    document.getElementById("confirmpass").style.setProperty('background-color', 'red');
                    return false;
                } else {
                    document.getElementById("msg").innerHTML = "";
                    document.getElementById("confirmpass").style.setProperty('background-color', 'white');
                    return true;
                }
            }
        </script>

        <!-- Start Script -->
        <script src="assets/js/jquery-1.11.0.min.js"></script>
        <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/templatemo.js"></script>
        <script src="assets/js/custom.js"></script>
        <!-- End Script -->
    </body>
</html>
