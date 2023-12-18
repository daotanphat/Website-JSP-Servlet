<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="zxx">
    <head>
        <!-- Meta Tag -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name='copyright' content=''>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Title Tag  -->
        <title>Check out</title>
        <!-- Favicon -->
        <link rel="icon" href="assets/img/header/logo1.png">
        <!-- Web Font -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap" rel="stylesheet">

        <!-- StyleSheet -->

        <!-- Bootstrap -->
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <!-- Magnific Popup -->
        <link rel="stylesheet" href="./assets/css/magnific-popup.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="./assets/css/font-awesome.css">
        <!-- Fancybox -->
        <link rel="stylesheet" href="./assets/css/jquery.fancybox.min.css">
        <!-- Themify Icons -->
        <link rel="stylesheet" href="./assets/css/themify-icons.css">
        <!-- Nice Select CSS -->
        <link rel="stylesheet" href="./assets/css/niceselect.css">
        <!-- Animate CSS -->
        <link rel="stylesheet" href="./assets/css/animate.css">
        <!-- Flex Slider CSS -->
        <link rel="stylesheet" href="./assets/css/flex-slider.min.css">
        <!-- Owl Carousel -->
        <link rel="stylesheet" href="./assets/css/owl-carousel.css">
        <!-- Slicknav -->
        <link rel="stylesheet" href="./assets/css/slicknav.min.css">

        <!-- Eshop StyleSheet -->
        <link rel="stylesheet" href="./assets/css/reset.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/responsive.css">



    </head>
    <body class="js">

        <!-- Header -->
        <%@include file="header.jsp" %>

        <c:set value="${sessionScope.user}" var="u"/>

        <!-- Start Checkout -->
        <section class="shop checkout section">
            <div class="container">
                <div class="row"> 
                    <div class="col-lg-8 col-12">
                        <div class="checkout-form">
                            <h2>Make Your Checkout Here</h2>
                            <!-- Form -->
                            <form class="form" method="post" action="#">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="form-group">
                                            <label>Name<span>*</span></label>
                                            <input type="text" name="name" value="${u.name}" readonly="" placeholder="" required="required">
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="form-group">
                                            <label>Address<span>*</span></label>
                                            <input type="text" name="address" value="${u.address}" readonly="" placeholder="" required="required">
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="form-group">
                                            <label>Email<span>*</span></label>
                                            <input type="email" name="email" value="${u.email}" readonly="" placeholder="" required="required">
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="form-group">
                                            <label>Phone Number<span>*</span></label>
                                            <input type="number" name="number" value="${u.phone}" readonly="" placeholder="" required="required">
                                        </div>
                                    </div>
                                </div>
                                <h4 style="color: greenyellow">${requestScope.success}</h4>
                            </form>
                            <!--/ End Form -->
                        </div>
                    </div>
                    <div class="col-lg-4 col-12">
                        <div class="order-details">
                            <!-- Order Widget -->
                            <div class="single-widget">
                                <h2>CART  TOTALS</h2>
                                <div class="content">
                                    <ul>
                                        <li>Sub Total<span><fmt:setLocale value="vi_VN"/><fmt:formatNumber value="${requestScope.total}" type="currency"></fmt:formatNumber></span></li>
                                            <li>(+) Shipping<span>Free</span></li>
                                            <li class="last">Total<span><fmt:setLocale value="vi_VN"/><fmt:formatNumber value="${requestScope.total}" type="currency"></fmt:formatNumber></span></span></li>
                                        </ul>
                                    </div>
                                </div>
                                <!--/ End Order Widget -->
                                <!-- Order Widget -->
                                <div class="single-widget">
                                    <h2>Payments</h2>
                                    <div class="content">
                                        <div class="checkbox">
                                            <label class="checkbox-inline" for="1"><input name="updates" id="1" type="checkbox"> Check Payments</label>
                                            <label class="checkbox-inline" for="2"><input name="news" id="2" type="checkbox"> Cash On Delivery</label>
                                            <label class="checkbox-inline" for="3"><input name="news" id="3" type="checkbox"> PayPal</label>
                                        </div>
                                    </div>
                                </div>
                                <!--/ End Order Widget -->
                                <!-- Payment Method Widget -->
                                <div class="single-widget payement">
                                    <div class="content">
                                        <img src="./assets/img/Payment/payment-method.png" alt="#">
                                    </div>
                                </div>
                                <!--/ End Payment Method Widget -->
                                <!-- Button Widget -->
                                <div class="single-widget get-button">
                                    <div class="content">
                                        <form action="check-out" method="post">
                                            <div class="button">
                                                <button class="btn">proceed to checkout</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <!--/ End Button Widget -->
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!--/ End Checkout -->

            <!-- Start Shop Services Area  -->
            <section class="shop-services section home">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-6 col-12">
                            <!-- Start Single Service -->
                            <div class="single-service">
                                <i class="ti-rocket"></i>
                                <h4>Free shiping</h4>
                                <p>Orders over $100</p>
                            </div>
                            <!-- End Single Service -->
                        </div>
                        <div class="col-lg-3 col-md-6 col-12">
                            <!-- Start Single Service -->
                            <div class="single-service">
                                <i class="ti-reload"></i>
                                <h4>Free Return</h4>
                                <p>Within 30 days returns</p>
                            </div>
                            <!-- End Single Service -->
                        </div>
                        <div class="col-lg-3 col-md-6 col-12">
                            <!-- Start Single Service -->
                            <div class="single-service">
                                <i class="ti-lock"></i>
                                <h4>Sucure Payment</h4>
                                <p>100% secure payment</p>
                            </div>
                            <!-- End Single Service -->
                        </div>
                        <div class="col-lg-3 col-md-6 col-12">
                            <!-- Start Single Service -->
                            <div class="single-service">
                                <i class="ti-tag"></i>
                                <h4>Best Peice</h4>
                                <p>Guaranteed price</p>
                            </div>
                            <!-- End Single Service -->
                        </div>
                    </div>
                </div>
            </section>
            <!-- End Shop Services -->

            <!-- Start Shop Newsletter  -->
            <section class="shop-newsletter section">
                <div class="container">
                    <div class="inner-top">
                        <div class="row">
                            <div class="col-lg-8 offset-lg-2 col-12">
                                <!-- Start Newsletter Inner -->
                                <div class="inner">
                                    <h4>Newsletter</h4>
                                    <p> Subscribe to our newsletter and get <span>10%</span> off your first purchase</p>
                                    <form action="mail/mail.php" method="get" target="_blank" class="newsletter-inner">
                                        <input name="EMAIL" placeholder="Your email address" required="" type="email">
                                        <button class="btn">Subscribe</button>
                                    </form>
                                </div>
                                <!-- End Newsletter Inner -->
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- End Shop Newsletter -->

            <!-- Start Footer Area -->
        <%@include file="footer.jsp" %>
        <!-- /End Footer Area -->

        <!-- Jquery -->
        <script src="./assets/js/jquery.min.js"></script>
        <script src="./assets/js/jquery-migrate-3.0.0.js"></script>
        <script src="./assets/js/jquery-ui.min.js"></script>
        <!-- Popper JS -->
        <script src="./assets/js/popper.min.js"></script>
        <!-- Bootstrap JS -->
        <script src="./assets/js/bootstrap.min.js"></script>
        <!-- Color JS -->
        <script src="./assets/js/colors.js"></script>
        <!-- Slicknav JS -->
        <script src="./assets/js/slicknav.min.js"></script>
        <!-- Owl Carousel JS -->
        <script src="./assets/js/owl-carousel.js"></script>
        <!-- Magnific Popup JS -->
        <script src="./assets/js/magnific-popup.js"></script>
        <!-- Fancybox JS -->
        <script src="./assets/js/facnybox.min.js"></script>
        <!-- Waypoints JS -->
        <script src="./assets/js/waypoints.min.js"></script>
        <!-- Countdown JS -->
        <script src="./assets/js/finalcountdown.min.js"></script>
        <!-- Nice Select JS -->
        <script src="./assets/js/nicesellect.js"></script>
        <!-- Ytplayer JS -->
        <script src="./assets/js/ytplayer.min.js"></script>
        <!-- Flex Slider JS -->
        <script src="js/flex-slider.js"></script>
        <!-- ScrollUp JS -->
        <script src="./assets/js/scrollup.js"></script>
        <!-- Onepage Nav JS -->
        <script src="./assets/js/onepage-nav.min.js"></script>
        <!-- Easing JS -->
        <script src="./assets/js/easing.js"></script>
        <!-- Active JS -->
        <script src="./assets/js/active.js"></script>

        <!-- Start Script -->
        <script src="assets/js/jquery-1.11.0.min.js"></script>
        <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/templatemo.js"></script>
        <script src="assets/js/custom.js"></script>
        <!-- End Script -->
    </body>
</html>