<%-- 
    Document   : signUp
    Created on : Sep 25, 2023, 10:46:00 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign Up</title>

        <link rel="icon" href="assets/img/header/logo1.png">
        <!-- Meta tag Keywords -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Flat Sign Up Form Responsive Widget Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Meta tag Keywords -->
        <!-- css files -->
        <link href="assets/css/signUp.css" rel="stylesheet" type="text/css" media="all">
        <link href="assets/css/fontawesome.min.css" rel="stylesheet" type="text/css" media="all">
        <!-- //css files -->
        <!-- online-fonts -->
        <link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'><link href='//fonts.googleapis.com/css?family=Raleway+Dots' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <!--main-->
        <div class="main-agileits">
            <h2 class="sub-head">Sign Up</h2>
            <h3 id="msg" style="color: red">${requestScope.msg}</h3>
            <div class="sub-main">	
                <form action="signup" method="post">
                    <input placeholder="Your Name" name="name" class="name" type="text" required="">
                    <span class="icon1"><i class="fa fa-user" aria-hidden="true"></i></span><br>

                    <input placeholder="Your account" name="account" class="account" type="text" required="">
                    <span class="icon2"><i class="fa fa-registered" aria-hidden="true"></i></span><br>

                    <input  placeholder="Password" name="password" id="pass" type="password" required="">
                    <span class="icon3"><i class="fa fa-unlock" aria-hidden="true"></i></span><br>

                    <input  placeholder="Confirm Password" name="confirmpassword" id="confirmpass" type="password" onkeyup="confirmPass()" required="">
                    <span class="icon4"><i class="fa fa-unlock" aria-hidden="true"></i></span><br>

                    <select class="gender" name="gender">
                        <option selected>Gender</option>
                        <option value="1">Male</option>
                        <option value="0">Female</option>
                    </select>
                    <span class="icon5"><i class="fa fa-venus-mars" aria-hidden="true"></i></span><br>
                    
                    <input placeholder="Date of birth" name="date" class="date" type="date" required="">
                    <span class="icon6"><i class="fa fa-calendar-day" aria-hidden="true"></i></span><br>

                    <input placeholder="Address" name="address" class="address" type="text" required="">
                    <span class="icon7"><i class="fa fa-address-book" aria-hidden="true"></i></span><br>

                    <input placeholder="Phone Number" name="phonenumber" class="number" type="text" required="">
                    <span class="icon8"><i class="fa fa-phone" aria-hidden="true"></i></span><br>

                    <input placeholder="Email" name="mail" class="mail" type="text" required="">
                    <span class="icon9"><i class="fa fa-envelope" aria-hidden="true"></i></span><br>

                    <input type="submit" value="sign up">
                </form>
            </div>
            <div class="clear"></div>
        </div>
        <!--//main-->
    </body>
    
    <script>
        function confirmPass(){
            pass = document.getElementById("pass").value;
            confirmpass = document.getElementById("confirmpass").value;
            if(pass != confirmpass){
                document.getElementById("msg").innerHTML = "Confirm password doesn't match! Re-confirm password.";
                document.getElementById("confirmpass").style.setProperty('background-color', 'red');
                return false;
            }else{
                document.getElementById("msg").innerHTML = "";
                document.getElementById("confirmpass").style.setProperty('background-color', 'white');
                return true;
            }
        }
    </script>
</html>
