<%-- 
    Document   : shop
    Created on : Sep 29, 2023, 11:47:22 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Family House</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="icon" href="assets/img/header/logo1.png">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/templatemo.css">
        <link rel="stylesheet" href="assets/css/custom.css">

        <!-- Load fonts style after rendering the layout styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <!-- Start Content -->
        <div class="container py-5">
            <div class="row">

                <!-- Left -->
                <div class="col-lg-3">
                    <h4>Filter</h4>
                    <form action="filter">
                        <input type="text" value="${requestScope.cid}" name="cId" style="display: none" />
                        <input type="text" value="${requestScope.cname}" name="cName" style="display: none" />
                        <div class="accordion accordion-flush" id="accordionFlushExample">
                            <div class="accordion-item">
                                <h2 class="accordion-header">
                                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                                        Type
                                    </button>
                                </h2>
                                <div id="flush-collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                                    <ul class="accordion-body">

                                        <c:set value="${requestScope.types}" var="types"/>
                                        <c:set value="${requestScope.type}" var="type"/>
                                        <c:forEach begin="0" end="${type.size()-1}" var="t">
                                            <li><input type="checkbox" name="productType" value="${type.get(t)}" ${types[t]?'checked':''} onclick="this.form.submit()"/>${type.get(t)}</li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </div>
                            <div class="accordion-item">
                                <h2 class="accordion-header">
                                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                                        Firm
                                    </button>
                                </h2>
                                <div id="flush-collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                                    <ul class="accordion-body">
                                        <c:set value="${requestScope.firms}" var="firms"/>
                                        <c:set value="${requestScope.firm}" var="firm"/>
                                        <c:forEach begin="0" end="${firm.size()-1}" var="i">
                                            <li><input type="checkbox" name="productFirm" value="${firm.get(i)}" ${firms[i]?'checked':''} onclick="this.form.submit()"/>${firm.get(i)}</li>
                                            </c:forEach>

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- End Left -->


                <!-- Right -->
                <div class="col-lg-9">

                    <!-- Filter -->
                    <div class="row">
                        <div class="col-md-6">
                            <form class="input-group" action="search">
                                <input type="text" value="${requestScope.cid}" name="cId" style="display: none" />
                                <input type="text" value="${requestScope.cname}" name="cName" style="display: none" />
                                <input type="text" class="form-control" id="inputMobileSearch" name="searchkey" value="${requestScope.search}" placeholder="Search ...">
                                <div class="input-group-text">
                                    <button type="submit" style="border: none"><i class="fa fa-fw fa-search"></i></button>
                                </div>
                            </form>
                        </div>
                        <div class="col-md-6 pb-4">
                            <div class="d-flex">
                                <form action="sortedby">
                                    <input type="text" value="${requestScope.cid}" name="cId" style="display: none" />
                                    <input type="text" value="${requestScope.cname}" name="cName" style="display: none" />
                                    <select name="sorted" class="form-control" onchange="this.form.submit()">
                                        <<option value="0">Sorted by:</option>
                                        <option value="1" >Featured</option>
                                        <option value="2" >Price low to high</option>
                                        <option value="3" >Price high to low</option>
                                    </select>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- End Filter -->

                    <!-- Product-->
                    <div class="row">
                        <h3>${requestScope.msg}</h3>
                        <c:forEach items="${requestScope.listProduct}" var="p">
                            <div class="col-md-4">
                                <div class="card mb-4 product-wap rounded-0">
                                    <div class="card rounded-0">
                                        <img class="card-img rounded-0 img-fluid" src="${p.img}main.jpg" />
                                        <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                            <ul class="list-unstyled">
                                                <li><a class="btn btn-success text-white" href="detail-product?pid=${p.id}&cateId=${p.categoryId}"><i class="far fa-heart"></i></a></li>
                                                <li><a class="btn btn-success text-white mt-2" href="detail-product?pid=${p.id}&cateId=${p.categoryId}"><i class="far fa-eye"></i></a></li>
                                                <li><a class="btn btn-success text-white mt-2" href="buy-product?pid=${p.id}&num=1"><i class="fas fa-cart-plus"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="card-body">
                                        <a href="detail-product?pid=${p.id}&cateId=${p.categoryId}" class="h3 text-decoration-none">${p.name}</a>
                                        <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                            <li class="priceProduct"><fmt:setLocale value="vi_VN"/><fmt:formatNumber value="${p.price}" type="currency"></fmt:formatNumber></li>
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
                                                    <i class="text-muted fa fa-star"></i>
                                                    <i class="text-muted fa fa-star"></i>
                                                </li>
                                            </ul>
                                            <p class="text-center mb-0"><fmt:setLocale value="vi_VN"/><fmt:formatNumber value="${p.price - p.price*(p.discount/100)}" type="currency"></fmt:formatNumber></p>
                                        </div>
                                    </div>
                                </div>
                        </c:forEach>
                        <!-- End Product-->

                        <div div="row">
                            <ul class="pagination pagination-lg justify-content-end">
                                <c:set value="${requestScope.page}" var="page"/>
                                <c:set value="${requestScope.urlpattern}" var="urlpat" />
                                <c:forEach begin="${1}" end="${requestScope.numpage}" var="i">
                                    <c:if test="${urlpat eq 'search'}">
                                        <li class="page-item">
                                            <a class="${i==page?"active":""} page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark" href="search?page=${i}&cId=${requestScope.cid}&cName=${requestScope.cname}&searchkey=${requestScope.search}">${i}</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${urlpat eq 'sortedby'}">
                                        <c:set value="${requestScope.sorted}" var="so" />
                                        <li class="page-item">
                                            <a class="${i==page?"active":""} page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark" href="sortedby?page=${i}&cId=${requestScope.cid}&cName=${requestScope.cname}&sorted=${so}">${i}</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${urlpat eq 'list-product'}">
                                        <c:set value="${requestScope.sorted}" var="so" />
                                        <li class="page-item">
                                            <a class="${i==page?"active":""} page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark" href="list-product?page=${i}&cId=${requestScope.cid}&cName=${requestScope.cname}">${i}</a>
                                        </li>
                                    </c:if>

                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <!-- End Right -->

                </div>
            </div>
        </div>
        <!-- End Content -->

        <!--Carousel Wrapper-->
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

        <!--Controls-->
        <div class="col-1 align-self-center">
            <a class="h1" href="#multi-item-example" role="button" data-bs-slide="next">
                <i class="text-light fas fa-chevron-right"></i>
            </a>
        </div>
        <!--End Controls-->
    </div>
</div>
</div>
</div>
</section>
<!--End Brands-->

<%@include file="footer.jsp"%>

<!-- Start Script -->
<script src="assets/js/jquery-1.11.0.min.js"></script>
<script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/templatemo.js"></script>
<script src="assets/js/custom.js"></script>
<!-- End Script -->
</body>
</html>
