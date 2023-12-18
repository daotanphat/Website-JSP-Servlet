<%-- 
    Document   : Product
    Created on : Oct 17, 2023, 12:18:25 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Zay Shop - Product Detail Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="icon" href="assets/img/header/logo1.png">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/templatemo.css">
        <link rel="stylesheet" href="assets/css/custom.css">

        <!-- Load fonts style after rendering the layout styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">

        <!-- Slick -->
        <link rel="stylesheet" type="text/css" href="assets/css/slick.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/slick-theme.css">
        <!--
            
        TemplateMo 559 Zay Shop
        
        https://templatemo.com/tm-559-zay-shop
        
        -->
    </head>

    <body>
        <%@include file="header.jsp" %>

        <c:set var="p" value="${requestScope.product}" />
        <!-- Open Content -->
        <section class="bg-light">
            <div class="container pb-5">
                <div class="row">
                    <div class="col-lg-5 mt-5">
                        <div class="card mb-3">
                            <img class="card-img img-fluid" src="${p.img}main.jpg" alt="Card image cap" id="product-detail">
                        </div>
                        <div class="row">
                            <!--Start Controls-->
                            <div class="col-1 align-self-center">
                                <a href="#multi-item-example" role="button" data-bs-slide="prev">
                                    <i class="text-dark fas fa-chevron-left"></i>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </div>
                            <!--End Controls-->
                            <!--Start Carousel Wrapper-->
                            <div id="multi-item-example" class="col-10 carousel slide carousel-multi-item" data-bs-ride="carousel">
                                <!--Start Slides-->
                                <div class="carousel-inner product-links-wap" role="listbox">

                                    <!--First slide-->
                                    <div class="carousel-item active">
                                        <div class="row">
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${p.img}2.jpg" alt="Product Image 1">
                                                </a>
                                            </div>
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${p.img}3.jpg" alt="Product Image 2">
                                                </a>
                                            </div>
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${p.img}main.jpg" alt="Product Image 3">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/.First slide-->

                                    <!--Second slide-->
                                    <div class="carousel-item">
                                        <div class="row">
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${p.img}2.jpg" alt="Product Image 4">
                                                </a>
                                            </div>
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${p.img}3.jpg" alt="Product Image 5">
                                                </a>
                                            </div>
                                            <div class="col-4">
                                                <a href="#">
                                                    <img class="card-img img-fluid" src="${p.img}main.jpg" alt="Product Image 6">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/.Second slide-->
                                </div>
                                <!--End Slides-->
                            </div>
                            <!--End Carousel Wrapper-->
                            <!--Start Controls-->
                            <div class="col-1 align-self-center">
                                <a href="#multi-item-example" role="button" data-bs-slide="next">
                                    <i class="text-dark fas fa-chevron-right"></i>
                                    <span class="sr-only">Next</span>
                                </a>
                            </div>
                            <!--End Controls-->
                        </div>
                    </div>
                    <!-- col end -->
                    <div class="col-lg-7 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h1 class="h2">${p.name}</h1>
                                <p class="h3 py-2"><fmt:setLocale value="vi_VN"/><fmt:formatNumber value="${p.price - p.price*(p.discount/100)}" type="currency" /></p>
                                <p class="py-2">
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-secondary"></i>
                                    <span class="list-inline-item text-dark">Rating 4.8 | ${requestScope.numComment} Comments</span>
                                </p>
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <h6>Brand:</h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <p class="text-muted"><strong>${p.firm}</strong></p>
                                    </li>
                                </ul>
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <h6>Utilities:</h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <p class="text-muted"><strong>${p.utilities}</strong></p>
                                    </li>
                                </ul>
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <h6>Warranty:</h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <p class="text-muted"><strong>${p.warranty}</strong></p>
                                    </li>
                                </ul>
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <h6>Date release: </h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <p class="text-muted"><strong>${p.dateRelease}</strong></p>
                                    </li>
                                </ul>

                                <form name="f" action="cart" method="post">
                                    <div class="row">
                                        <div class="col-auto">
                                            <ul class="list-inline pb-3">
                                                <li class="list-inline-item text-right">
                                                    Quantity
                                                    <input type="hidden" name="product-quanity" id="product-quanity" value="1">
                                                </li>
                                                <li class="list-inline-item"><span class="btn btn-success" id="btn-minus">-</span></li>
                                                <li class="list-inline-item"><span class="badge bg-secondary" id="var-value" data-value="" name="numBuy">1</span></li>
                                                <li class="list-inline-item"><span class="btn btn-success" id="btn-plus">+</span></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="row pb-3">
                                        <div class="col d-grid">
                                            <button type="submit" class="btn btn-success btn-lg" name="submit" value="buy" onclick="my_cart('${p.id}')">Buy</button>
                                        </div>
                                        <c:set value="${sessionScope.user}" var="u"/>
                                        <c:if test="${u == null}">
                                            <div class="col d-grid">
                                                <button type="submit" class="btn btn-success btn-lg" id="addToCartButton" name="submit" value="addtocard" onclick="cart(0, 0)">Add To Cart</button>
                                            </div>
                                        </c:if>
                                        <c:if test="${u != null}">
                                            <div class="col d-grid">
                                                <button type="submit" class="btn btn-success btn-lg" id="addToCartButton" name="submit" value="addtocard" onclick="cart('${p.id}', '${p.categoryId}')">Add To Cart</button>
                                            </div>
                                        </c:if>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Close Content -->

        <div class="row ">
            <div class="be-comment-block col-lg-7">
                <h1 class="comments-title">Comment (${requestScope.numComment})</h1>
                <c:forEach items="${requestScope.listComment}" var="l">
                    <div class="be-comment">
                        <div class="be-img-comment">	
                            <a>
                                <img src="${l.user.avatar}" alt="" class="be-ava-comment">
                            </a>
                        </div>
                        <div class="be-comment-content">

                            <span class="be-comment-name">
                                <a>${l.user.name}</a>
                            </span>
                            <span class="be-comment-time">
                                <i class="fa fa-clock-o"></i>
                                ${l.date}
                            </span>

                            <p class="be-comment-text">
                                ${l.comment}
                            </p>

                        </div>
                    </div>
                </c:forEach>

                <c:if test="${sessionScope.user != null}">
                    <form class="form-block" action="comment" method="post">
                        <input type="text" name="pid" value="${p.id}" style="display: none"/>
                        <input type="text" name="cateId" value="${p.categoryId}" style="display: none"/>
                        <div class="row">
                            <div class="col-xs-12">									
                                <div class="form-group">
                                    <textarea class="form-input" name="comment" placeholder="Your comment"></textarea>
                                </div>
                            </div>
                            <button class="btn btn-primary pull-right" type="submit">SEND</button>
                        </div>
                    </form>
                </c:if>
                <c:if test="${sessionScope.user == null}">
                    <div style="display: hidden"></div>
                </c:if>
            </div>

            <div class="mt-4 col-lg-5">
                <h4>Specifications ${p.name}</h4>
                <table class="table table-striped">
                    <tbody>
                        <tr>
                            <th scope="row">Type</th>
                            <td>${p.t.type}</td>
                        </tr>
                        <tr>
                            <th scope="row">Power</th>
                            <td>${p.power}</td>
                        </tr>

                        <c:if test="${p.categoryId == 1}">
                            <tr>
                                <th scope="row">Surface material</th>
                                <td>${p.t.surfaceMaterial}</td>
                            </tr>
                            <tr>
                                <th scope="row">Control panel</th>
                                <td>${p.t.controlPanel}</td>
                            </tr>
                            <tr>
                                <th scope="row">Cooker type</th>
                                <td>${p.t.cookerType}</td>
                            </tr>
                            <tr>
                                <th scope="row">Safety features</th>
                                <td>${p.t.safetyFeatures}</td>
                            </tr>
                        </c:if>
                        <c:if test="${p.categoryId == 2}">
                            <tr>
                                <th scope="row">Control</th>
                                <td>${p.t.control}</td>
                            </tr>
                            <tr>
                                <th scope="row">Maximum noise level</th>
                                <td>${p.t.maxNoise}</td>
                            </tr>
                            <tr>
                                <th scope="row">Mesh filter material</th>
                                <td>${p.t.meshMaterial}</td>
                            </tr>
                            <tr>
                                <th scope="row">Air outlet pipe diameter</th>
                                <td>${p.t.airOutletPipeDiameter}</td>
                            </tr>
                        </c:if>
                        <c:if test="${p.categoryId == 3}">
                            <tr>
                                <th scope="row">Main function</th>
                                <td>${p.t.mainFunction}</td>
                            </tr>
                            <tr>
                                <th scope="row">Mill</th>
                                <td>${p.t.mill}</td>
                            </tr>
                            <tr>
                                <th scope="row">Main mortal material</th>
                                <td>${p.t.mortalMaterial}</td>
                            </tr>
                            <tr>
                                <th scope="row">Blades</th>
                                <td>${p.t.blades}</td>
                            </tr>
                            <tr>
                                <th scope="row">Speed</th>
                                <td>${p.t.speed}</td>
                            </tr>
                            <tr>
                                <th scope="row">Safety features</th>
                                <td>${p.t.safetyFeatures}</td>
                            </tr>
                        </c:if>
                        <c:if test="${p.categoryId == 4}">
                            <tr>
                                <th scope="row">Volume</th>
                                <td>${p.t.volume}</td>
                            </tr>
                            <tr>
                                <th scope="row">Furnace cavity material</th>
                                <td>${p.t.furnaceCavityMaterial}</td>
                            </tr>
                            <tr>
                                <th scope="row">Main functions</th>
                                <td>${p.t.mainFunction}</td>
                            </tr>
                            <tr>
                                <th scope="row">Control Panel</th>
                                <td>${p.t.control}</td>
                            </tr>
                        </c:if>
                        <c:if test="${p.categoryId == 5}">
                            <tr>
                                <th scope="row">Energy-saving technology</th>
                                <td>${p.t.energySaving}</td>
                            </tr>
                            <tr>
                                <th scope="row">Refrigeration technology</th>
                                <td>${p.t.refrigeration}</td>
                            </tr>
                            <tr>
                                <th scope="row">Capacity used</th>
                                <td>${p.t.capacity}</td>
                            </tr>
                            <tr>
                                <th scope="row">Antimicrobial deodorizing technology</th>
                                <td>${p.t.antimicrobialDeodorozing}</td>
                            </tr>
                            <tr>
                                <th scope="row">Food preservation technology</th>
                                <td>${p.t.foodPreservation}</td>
                            </tr>
                        </c:if>
                        <c:if test="${p.categoryId == 6}">
                            <tr>
                                <th scope="row">Number of filter elements</th>
                                <td>${p.t.numFilter}</td>
                            </tr>
                            <tr>
                                <th scope="row">Container capacity</th>
                                <td>${p.t.capacity}</td>
                            </tr>
                            <tr>
                                <th scope="row">Filtration - discharge ratio</th>
                                <td>${p.t.filtrationDischargeRatio}</td>
                            </tr>
                        </c:if>

                        <tr>
                            <th scope="row">Utilities</th>
                            <td>${p.utilities}</td>
                        </tr>
                        <tr>
                            <th scope="row">Size</th>
                            <td>${p.size}</td>
                        </tr>
                        <tr>
                            <th scope="row">Weight</th>
                            <td>${p.weight}</td>
                        </tr>
                        <tr>
                            <th scope="row">Date release</th>
                            <td>${p.dateRelease}</td>
                        </tr>
                        <tr>
                            <th scope="row">Trademark</th>
                            <td>${p.trademark}</td>
                        </tr>
                        <tr>
                            <th scope="row">Firm</th>
                            <td>${p.firm}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Start Section -->
        <section class="container py-5">
            <div class="row text-center pt-5 pb-3">
                <div class="col-lg-6 m-auto">
                    <h1 class="h1">Our Services</h1>
                </div>
            </div>
            <div class="row">

                <div class="col-md-6 col-lg-3 pb-5">
                    <div class="h-100 py-5 services-icon-wap shadow">
                        <div class="h1 text-success text-center"><i class="fa fa-truck fa-lg"></i></div>
                        <h2 class="h5 mt-4 text-center">Delivery Services</h2>
                    </div>
                </div>

                <div class="col-md-6 col-lg-3 pb-5">
                    <div class="h-100 py-5 services-icon-wap shadow">
                        <div class="h1 text-success text-center"><i class="fas fa-exchange-alt"></i></div>
                        <h2 class="h5 mt-4 text-center">Shipping & Return</h2>
                    </div>
                </div>

                <div class="col-md-6 col-lg-3 pb-5">
                    <div class="h-100 py-5 services-icon-wap shadow">
                        <div class="h1 text-success text-center"><i class="fa fa-percent"></i></div>
                        <h2 class="h5 mt-4 text-center">Promotion</h2>
                    </div>
                </div>

                <div class="col-md-6 col-lg-3 pb-5">
                    <div class="h-100 py-5 services-icon-wap shadow">
                        <div class="h1 text-success text-center"><i class="fa fa-user"></i></div>
                        <h2 class="h5 mt-4 text-center">24 Hours Service</h2>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Section -->

        <!-- Start Article -->
        <section class="py-5">
            <div class="container">
                <div class="row text-left p-2 pb-3">
                    <h4>Related Products</h4>
                </div>

                <!--Start Carousel Wrapper-->
                <div id="carousel-related-product">
                    <c:forEach items="${requestScope.relatedProduct}" var="r">
                        <div class="p-2 pb-3">
                            <div class="product-wap card rounded-0">
                                <div class="card rounded-0">
                                    <img class="card-img rounded-0 img-fluid" src="${r.img}main.jpg">
                                    <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                        <ul class="list-unstyled">
                                            <li><a class="btn btn-success text-white" href="detail-product?pid=${r.id}&cateId=${r.categoryId}"><i class="far fa-heart"></i></a></li>
                                            <li><a class="btn btn-success text-white mt-2" href="detail-product?pid=${r.id}&cateId=${r.categoryId}"><i class="far fa-eye"></i></a></li>
                                            <li><a class="btn btn-success text-white mt-2" href="detail-product?pid=${r.id}&cateId=${r.categoryId}"><i class="fas fa-cart-plus"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <a href="shop-single.html" class="h3 text-decoration-none">${r.name}</a>
                                    <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                        <li class="priceProduct"><fmt:setLocale value="vi_VN"/><fmt:formatNumber value="${r.price}" type="currency" /></li>
                                        <li class="pt-2">
                                            <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
                                            <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
                                            <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
                                            <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
                                            <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
                                        </li>
                                    </ul>
                                    <ul class="list-unstyled d-flex justify-content-center mb-1">
                                        <li>
                                            <i class="text-warning fa fa-star"></i>
                                            <i class="text-warning fa fa-star"></i>
                                            <i class="text-warning fa fa-star"></i>
                                            <i class="text-warning fa fa-star"></i>
                                            <i class="text-muted fa fa-star"></i>
                                        </li>
                                    </ul>
                                    <p class="text-center mb-0"><fmt:setLocale value="vi_VN"/><fmt:formatNumber value="${r.price - r.price*(r.discount/100)}" type="currency" /></p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>


            </div>
        </section>
        <!-- End Article -->


        <%@include file="footer.jsp"%>

        <!-- Start Script -->
        <script src="assets/js/jquery-1.11.0.min.js"></script>
        <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/templatemo.js"></script>
        <script src="assets/js/custom.js"></script>
        <!-- End Script -->

        <!-- Start Slider Script -->
        <script src="assets/js/slick.min.js"></script>

        <script type="text/javascript">
                                                    var val = 1;
                                                    $('#btn-minus').click(function () {
                                                        val = $("#var-value").html();
                                                        val = (val == '1') ? val : val - 1;
                                                        $("#var-value").html(val);
                                                        $("#product-quanity").val(val);
                                                        return false;
                                                    });
                                                    $('#btn-plus').click(function () {
                                                        val = $("#var-value").html();
                                                        val++;
                                                        $("#var-value").html(val);
                                                        $("#product-quanity").val(val);
                                                        return false;
                                                    });
                                                    function cart(id, cateId) {
                                                        document.f.action = "cart?pid=" + id + "&cateId=" + cateId + "&numBuy=" + val;
                                                        document.f.submit();
                                                    }
                                                    
                                                    function my_cart(pid){
                                                        document.f.action = "buy-product?pid=" + pid + "&num=1";
                                                        //document.f.submit();
                                                    }
        </script>
        <script>
            $('#carousel-related-product').slick(
                    {
                        infinite: true,
                        arrows: false,
                        slidesToShow: 4,
                        slidesToScroll: 3,
                        dots: true,
                        responsive: [{
                                breakpoint: 1024,
                                settings: {
                                    slidesToShow: 3,
                                    slidesToScroll: 3
                                }
                            },
                            {
                                breakpoint: 600,
                                settings: {
                                    slidesToShow: 2,
                                    slidesToScroll: 3
                                }
                            },
                            {
                                breakpoint: 480,
                                settings: {
                                    slidesToShow: 2,
                                    slidesToScroll: 3
                                }
                            }
                        ]
                    });
        </script>
        <!-- End Slider Script -->

    </body>
</html>
