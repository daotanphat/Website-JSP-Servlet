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
        <title>Cart</title>
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

        <!--         Preloader 
                <div class="preloader">
                    <div class="preloader-inner">
                        <div class="preloader-icon">
                            <span></span>
                            <span></span>
                        </div>
                    </div>
                </div>
                 End Preloader -->

        <!-- Header -->
        <%@include file="header.jsp" %>
        <!-- End Breadcrumbs -->

        <!-- Shopping Cart -->
        <div class="shopping-cart section">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <!-- Shopping Summery -->
                        <table class="table shopping-summery">
                            <thead>
                                <tr class="main-hading">
                                    <th>PRODUCT</th>
                                    <th>NAME</th>
                                    <th class="text-center">UNIT PRICE</th>
                                    <th class="text-center">QUANTITY</th>
                                    <th class="text-center">TOTAL</th> 
                                    <th class="text-center"><i class="ti-trash remove-icon"></i></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set value="${sessionScope.cart}" var="cart"/>
                                <c:set value="0" var="total"/>
                                <c:forEach items="${cart.items}" var="i">
                                    <tr>
                                        <td class="image" data-title="No"><img src="${i.product.img}main.jpg" alt="#"></td>
                                        <td class="product-des" data-title="Description">
                                            <p class="product-name"><a href="#">${i.product.name}</a></p>
                                        </td>
                                        <td class="price" data-title="Price"><span><fmt:setLocale value="vi_VN"/><fmt:formatNumber value="${i.price}" type="currency"></fmt:formatNumber></span></td>
                                            <td class="qty" data-title="Qty"><!-- Input Order -->
                                                <div class="input-group">
                                                    <div class="button minus" style="margin: 11px">
                                                        <a href="my_cart?num=-1&pid=${i.product.id}" style="text-decoration: none">
                                                        <i class="ti-minus"></i>
                                                    </a>
                                                </div>
                                                <input type="text" readonly="" name="quant[1]" class="input-number"  data-min="1" data-max="100" value="${i.quantity}">
                                                <input type="text" name="id" value="${i.product.id}" style="display: none" />
                                                <div class="button plus" style="margin: 11px">
                                                    <a href="my_cart?num=+1&pid=${i.product.id}" style="text-decoration: none">
                                                        <i class="ti-plus"></i>
                                                    </a>
                                                </div>
                                            </div>
                                            <!--/ End Input Order -->
                                        </td>
                                        <td class="total-amount" data-title="Total"><span><fmt:setLocale value="vi_VN"/><fmt:formatNumber value="${i.price * i.quantity}" type="currency"></fmt:formatNumber></span></td>
                                            <td class="action" data-title="Remove">
                                                <form action="my_cart" method="post">
                                                    <input name="id" value="${i.product.id}" style="display: none"/>
                                                <button type="submit"><i class="ti-trash remove-icon"></i></button>
                                            </form>
                                        </td>
                                        <c:set var="eachTotal" value="${i.price * i.quantity}"/>
                                        <c:set var="total" value="${total + eachTotal}" />
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <!--/ End Shopping Summery -->
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <!-- Total Amount -->
                        <div class="total-amount">
                            <div class="row">
                                <div class="col-lg-8 col-md-5 col-12">
                                    <div class="left">
                                        <div class="coupon">
                                            <form action="#" target="_blank">
                                                <input name="Coupon" placeholder="Enter Your Coupon">
                                                <button class="btn">Apply</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-7 col-12">
                                    <div class="right">
                                        <ul>
                                            <li>Cart Subtotal<span><fmt:setLocale value="vi_VN"/><fmt:formatNumber value="${total}" type="currency"></fmt:formatNumber></span></li>
                                                <li>Shipping<span>Free</span></li>
                                                <li>You Save<span>0d</span></li>
                                                <li class="last">You Pay<span><fmt:setLocale value="vi_VN"/><fmt:formatNumber value="${total}" type="currency"></fmt:formatNumber></span></li>
                                            </ul>
                                            <div class="button5">
                                                <a href="check-out" class="btn">Checkout</a>
                                                <a href="list-category" class="btn">Continue shopping</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--/ End Total Amount -->
                        </div>
                    </div>
                </div>
            </div>
            <!--/ End Shopping Cart -->

            <!-- Start Shop Services Area  -->
            <section class="shop-services section">
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
            <!-- End Shop Newsletter -->

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



            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span class="ti-close" aria-hidden="true"></span></button>
                        </div>
                        <div class="modal-body">
                            <div class="row no-gutters">
                                <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                                    <!-- Product Slider -->
                                    <div class="product-gallery">
                                        <div class="quickview-slider-active">
                                            <div class="single-slider">
                                                <img src="images/modal1.jpg" alt="#">
                                            </div>
                                            <div class="single-slider">
                                                <img src="images/modal2.jpg" alt="#">
                                            </div>
                                            <div class="single-slider">
                                                <img src="images/modal3.jpg" alt="#">
                                            </div>
                                            <div class="single-slider">
                                                <img src="images/modal4.jpg" alt="#">
                                            </div>
                                        </div>
                                    </div>
                                    <!-- End Product slider -->
                                </div>
                                <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                                    <div class="quickview-content">
                                        <h2>Flared Shift Dress</h2>
                                        <div class="quickview-ratting-review">
                                            <div class="quickview-ratting-wrap">
                                                <div class="quickview-ratting">
                                                    <i class="yellow fa fa-star"></i>
                                                    <i class="yellow fa fa-star"></i>
                                                    <i class="yellow fa fa-star"></i>
                                                    <i class="yellow fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </div>
                                                <a href="#"> (1 customer review)</a>
                                            </div>
                                            <div class="quickview-stock">
                                                <span><i class="fa fa-check-circle-o"></i> in stock</span>
                                            </div>
                                        </div>
                                        <h3>$29.00</h3>
                                        <div class="quickview-peragraph">
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia iste laborum ad impedit pariatur esse optio tempora sint ullam autem deleniti nam in quos qui nemo ipsum numquam.</p>
                                        </div>
                                        <div class="size">
                                            <div class="row">
                                                <div class="col-lg-6 col-12">
                                                    <h5 class="title">Size</h5>
                                                    <select>
                                                        <option selected="selected">s</option>
                                                        <option>m</option>
                                                        <option>l</option>
                                                        <option>xl</option>
                                                    </select>
                                                </div>
                                                <div class="col-lg-6 col-12">
                                                    <h5 class="title">Color</h5>
                                                    <select>
                                                        <option selected="selected">orange</option>
                                                        <option>purple</option>
                                                        <option>black</option>
                                                        <option>pink</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="quantity">
                                            <!-- Input Order -->
                                            <div class="input-group">
                                                <div class="button minus">
                                                    <button type="button" class="btn btn-primary btn-number" disabled="disabled" data-type="minus" data-field="quant[1]">
                                                        <i class="ti-minus"></i>
                                                    </button>
                                                </div>
                                                <input type="text" name="quant[1]" class="input-number"  data-min="1" data-max="1000" value="1">
                                                <div class="button plus">
                                                    <button type="button" class="btn btn-primary btn-number" data-type="plus" data-field="quant[1]">
                                                        <i class="ti-plus"></i>
                                                    </button>
                                                </div>
                                            </div>
                                            <!--/ End Input Order -->
                                        </div>
                                        <div class="add-to-cart">
                                            <a href="#" class="btn">Add to cart</a>
                                            <a href="#" class="btn min"><i class="ti-heart"></i></a>
                                            <a href="#" class="btn min"><i class="fa fa-compress"></i></a>
                                        </div>
                                        <div class="default-social">
                                            <h4 class="share-now">Share:</h4>
                                            <ul>
                                                <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                                                <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
                                                <li><a class="youtube" href="#"><i class="fa fa-pinterest-p"></i></a></li>
                                                <li><a class="dribbble" href="#"><i class="fa fa-google-plus"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Modal end -->

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
        <script src="./assets/js/flex-slider.js"></script>
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