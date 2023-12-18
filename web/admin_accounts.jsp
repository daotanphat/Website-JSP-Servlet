<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Accounts - Product Admin Template</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="./assets/css/fontawesome.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="./assets/css/bootstrap.min.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="./assets/css/templatemo-style.css">
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        -->
        <link rel="icon" href="assets/img/Admin/admin.jfif">
    </head>

    <body id="reportsPage">
        <div class="" id="home">
            <%@include file="admin_header.jsp" %>
            <c:set value="${sessionScope.admin}" var="a"/>
            <div class="container mt-5">
                <!-- row -->
                <div class="row tm-content-row">
                    <form action="" class="tm-signup-form row" enctype="multipart/form-data">
                        <div class="tm-block-col tm-col-avatar">
                            <div class="tm-bg-primary-dark tm-block tm-block-avatar">
                                <h2 class="tm-block-title">Avatar</h2>
                                <div class="tm-avatar-container">
                                    <img
                                        src="${a.avatar}"
                                        alt="Avatar"
                                        class="tm-avatar img-fluid mb-4"
                                        />
                                </div>
                            </div>
                        </div>
                        <div class="tm-block-col tm-col-account-settings">
                            <div class="tm-bg-primary-dark tm-block tm-block-settings">
                                <h2 class="tm-block-title">Account Settings</h2>
                                <div class="form-group col-lg-6">
                                    <label for="name">Account Name</label>
                                    <input
                                        id="name"
                                        name="name"
                                        type="text"
                                        value="${a.name}"
                                        class="form-control validate"
                                        />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="email">Address</label>
                                    <input
                                        id="address"
                                        name="address"
                                        type="text"
                                        value="${a.address}"
                                        class="form-control validate"
                                        />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="email">Date of birth</label>
                                    <input
                                        id="date"
                                        name="date"
                                        type="date"
                                        value="${a.date}"
                                        class="form-control validate"
                                        />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="email">Account Email</label>
                                    <input
                                        id="email"
                                        name="email"
                                        type="email"
                                        value="${a.email}"
                                        class="form-control validate"
                                        />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="phone">Phone</label>
                                    <input
                                        id="phone"
                                        name="phone"
                                        type="tel"
                                        value="${a.phone}"
                                        class="form-control validate"
                                        />
                                </div>
                                <div class="col-12">
                                    <button
                                        type="submit"
                                        class="btn btn-primary btn-block text-uppercase"
                                        >
                                        Delete Your Account
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <%@include file="admin_footer.jsp" %>
        </div>

        <script src="./assets/js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="./assets/js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
    </body>
</html>
