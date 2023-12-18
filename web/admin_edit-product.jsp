<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Edit Product - Dashboard Admin Template</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="./assets/css/fontawesome.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="./assets/jquery-ui-datepicker/jquery-ui.min.css" type="text/css" />
        <!-- http://api.jqueryui.com/datepicker/ -->
        <link rel="stylesheet" href="./assets/css/bootstrap.min.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="./assets/css/templatemo-style.css">
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        -->
        <link rel="icon" href="assets/img/Admin/admin.jfif">
    </head>

    <body>
        <%@include file="admin_header.jsp" %>
        <c:set value="${requestScope.detailProduct}" var="p"/>
        <div class="container tm-mt-big tm-mb-big">
            <div class="row">
                <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <div class="row">
                            <div class="col-12">
                                <h2 class="tm-block-title d-inline-block">Edit Product</h2>
                            </div>
                        </div>
                        <form action="update_product" class="tm-edit-product-form" enctype="multipart/form-data">
                            <input name="pid" value="${p.id}" style="display: none"/>
                            <input name="cid" value="${p.categoryId}" style="display: none"/>
                            <div class="row tm-edit-product-row">
                                <div class="col-xl-6 col-lg-6 col-md-12">
                                    <div class="form-group mb-3">
                                        <label
                                            for="name"
                                            >Product Name
                                        </label>
                                        <input
                                            id="name"
                                            name="name"
                                            type="text"
                                            value="${p.name}"
                                            class="form-control validate"
                                            />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label
                                            for="price"
                                            >Price
                                        </label>
                                        <input
                                            id="price"
                                            name="price"
                                            type="text"
                                            value="${p.price}"
                                            class="form-control validate"
                                            />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label
                                            for="discount"
                                            >Discount
                                        </label>
                                        <input
                                            id="discount"
                                            name="discount"
                                            type="number"
                                            value="${p.discount}"
                                            class="form-control validate"
                                            />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label
                                            for="date"
                                            >Date release
                                        </label>
                                        <input
                                            id="date"
                                            name="date"
                                            type="text"
                                            value="${p.dateRelease}"
                                            class="form-control validate"
                                            />
                                    </div> 
                                    <div class="form-group mb-3">
                                        <label
                                            for="quantity"
                                            >Quantity
                                        </label>
                                        <input
                                            id="quantity"
                                            name="quantity"
                                            type="number"
                                            value="${p.quantity}"
                                            class="form-control validate"
                                            />
                                    </div> 
                                    <div class="form-group mb-3">
                                        <label
                                            for="cateid"
                                            >Category ID
                                        </label>
                                        <input
                                            readonly=""
                                            id="cateid"
                                            name="cateid"
                                            type="number"
                                            value="${p.categoryId}"
                                            class="form-control validate"
                                            />
                                    </div> 
                                    <div class="form-group mb-3">
                                        <label
                                            for="power"
                                            >Power
                                        </label>
                                        <input
                                            id="power"
                                            name="power"
                                            type="text"
                                            value="${p.power}"
                                            class="form-control validate"
                                            />
                                    </div> 
                                    <div class="form-group mb-3">
                                        <label
                                            for="utilities"
                                            >Utilities
                                        </label>
                                        <input
                                            id="utilities"
                                            name="utilities"
                                            type="text"
                                            value="${p.utilities}"
                                            class="form-control validate"
                                            />
                                    </div> 
                                    <div class="form-group mb-3">
                                        <label
                                            for="size"
                                            >Size
                                        </label>
                                        <input
                                            id="size"
                                            name="size"
                                            type="text"
                                            value="${p.size}"
                                            class="form-control validate"
                                            />
                                    </div>  
                                    <div class="form-group mb-3">
                                        <label
                                            for="weight"
                                            >Weight
                                        </label>
                                        <input
                                            id="weight"
                                            name="weight"
                                            type="text"
                                            value="${p.weight}"
                                            class="form-control validate"
                                            />
                                    </div>  
                                    <div class="form-group mb-3">
                                        <label
                                            for="warranty"
                                            >Warranty
                                        </label>
                                        <input
                                            id="warranty"
                                            name="warranty"
                                            type="text"
                                            value="${p.warranty}"
                                            class="form-control validate"
                                            />
                                    </div>  
                                    <div class="form-group mb-3">
                                        <label
                                            for="trademark"
                                            >Trademark
                                        </label>
                                        <input
                                            id="warranty"
                                            name="trademark"
                                            type="text"
                                            value="${p.trademark}"
                                            class="form-control validate"
                                            />
                                    </div> 
                                    <div class="form-group mb-3">
                                        <label
                                            for="firm"
                                            >Firm
                                        </label>
                                        <input
                                            id="firm"
                                            name="firm"
                                            type="text"
                                            value="${p.firm}"
                                            class="form-control validate"
                                            />
                                    </div> 

                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                                    <c:if test="${p.categoryId == 1}">
                                        <div class="form-group mb-3">
                                            <label
                                                for="type1"
                                                >Type
                                            </label>
                                            <input
                                                id="type1"
                                                name="type1"
                                                type="text"
                                                value="${p.t.type}"
                                                class="form-control validate"
                                                />
                                        </div> 
                                        <div class="form-group mb-3">
                                            <label
                                                for="surface"
                                                >Surface material
                                            </label>
                                            <input
                                                id="surface"
                                                name="surface"
                                                type="text"
                                                value="${p.t.surfaceMaterial}"
                                                class="form-control validate"
                                                />
                                        </div> 
                                        <div class="form-group mb-3">
                                            <label
                                                for="control1"
                                                >Control panel
                                            </label>
                                            <input
                                                id="control1"
                                                name="control1"
                                                type="text"
                                                value="${p.t.controlPanel}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="cooker"
                                                >Cooker type
                                            </label>
                                            <input
                                                id="cooker"
                                                name="cooker"
                                                type="text"
                                                value="${p.t.cookerType}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="safety1"
                                                >Safety Featured
                                            </label>
                                            <input
                                                id="safety1"
                                                name="safety1"
                                                type="text"
                                                value="${p.t.safetyFeatures}"
                                                class="form-control validate"
                                                />
                                        </div>
                                    </c:if>
                                    <c:if test="${p.categoryId == 2}">
                                        <div class="form-group mb-3">
                                            <label
                                                for="type2"
                                                >Type
                                            </label>
                                            <input
                                                id="type2"
                                                name="type2"
                                                type="text"
                                                value="${p.t.type}"
                                                class="form-control validate"
                                                />
                                        </div> 
                                        <div class="form-group mb-3">
                                            <label
                                                for="control2"
                                                >Control
                                            </label>
                                            <input
                                                id="control2"
                                                name="control2"
                                                type="text"
                                                value="${p.t.control}"
                                                class="form-control validate"
                                                />
                                        </div> 
                                        <div class="form-group mb-3">
                                            <label
                                                for="noise"
                                                >Max noise
                                            </label>
                                            <input
                                                id="noise"
                                                name="noise"
                                                type="text"
                                                value="${p.t.maxNoise}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="mesh"
                                                >Mesh material
                                            </label>
                                            <input
                                                id="mesh"
                                                name="mesh"
                                                type="text"
                                                value="${p.t.meshMaterial}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="lighting"
                                                >Lighting
                                            </label>
                                            <input
                                                id="lighting"
                                                name="lighting"
                                                type="text"
                                                value="${p.t.lighting}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="outlet"
                                                >Air outlet pipe diameter
                                            </label>
                                            <input
                                                id="outlet"
                                                name="outlet"
                                                type="text"
                                                value="${p.t.airOutletPipeDiameter}"
                                                class="form-control validate"
                                                />
                                        </div>
                                    </c:if>
                                    <c:if test="${p.categoryId == 3}">
                                        <div class="form-group mb-3">
                                            <label
                                                for="type3"
                                                >Type
                                            </label>
                                            <input
                                                id="type3"
                                                name="type3"
                                                type="text"
                                                value="${p.t.type}"
                                                class="form-control validate"
                                                />
                                        </div> 
                                        <div class="form-group mb-3">
                                            <label
                                                for="function3"
                                                >Main function
                                            </label>
                                            <input
                                                id="function3"
                                                name="function3"
                                                type="text"
                                                value="${p.t.mainFunction}"
                                                class="form-control validate"
                                                />
                                        </div> 
                                        <div class="form-group mb-3">
                                            <label
                                                for="mill"
                                                >Mill
                                            </label>
                                            <input
                                                id="mill"
                                                name="mill"
                                                type="text"
                                                value="${p.t.mill}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="mortal"
                                                >Main Mortal material
                                            </label>
                                            <input
                                                id="mortal"
                                                name="mortal"
                                                type="text"
                                                value="${p.t.mortalMaterial}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="blades"
                                                >Blades
                                            </label>
                                            <input
                                                id="blades"
                                                name="blades"
                                                type="text"
                                                value="${p.t.blades}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="speed"
                                                >speed
                                            </label>
                                            <input
                                                id="speed"
                                                name="speed"
                                                type="text"
                                                value="${p.t.speed}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="safety3"
                                                >Safety Featured
                                            </label>
                                            <input
                                                id="safety3"
                                                name="safety3"
                                                type="text"
                                                value="${p.t.safetyFeatures}"
                                                class="form-control validate"
                                                />
                                        </div>
                                    </c:if>
                                    <c:if test="${p.categoryId == 4}">
                                        <div class="form-group mb-3">
                                            <label
                                                for="type4"
                                                >Type
                                            </label>
                                            <input
                                                id="type4"
                                                name="type4"
                                                type="text"
                                                value="${p.t.type}"
                                                class="form-control validate"
                                                />
                                        </div> 
                                        <div class="form-group mb-3">
                                            <label
                                                for="volume"
                                                >Volume
                                            </label>
                                            <input
                                                id="volume"
                                                name="volume"
                                                type="text"
                                                value="${p.t.volume}"
                                                class="form-control validate"
                                                />
                                        </div> 
                                        <div class="form-group mb-3">
                                            <label
                                                for="furnace"
                                                >Furnace Cavity Material
                                            </label>
                                            <input
                                                id="furnace"
                                                name="furnace"
                                                type="text"
                                                value="${p.t.furnaceCavityMaterial}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="function4"
                                                >Main Function
                                            </label>
                                            <input
                                                id="function4"
                                                name="function4"
                                                type="text"
                                                value="${p.t.mainFunction}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="control4"
                                                >Control
                                            </label>
                                            <input
                                                id="control4"
                                                name="control4"
                                                type="text"
                                                value="${p.t.control}"
                                                class="form-control validate"
                                                />
                                        </div>
                                    </c:if>
                                    <c:if test="${p.categoryId == 5}">
                                        <div class="form-group mb-3">
                                            <label
                                                for="type5"
                                                >Type
                                            </label>
                                            <input
                                                id="type5"
                                                name="type5"
                                                type="text"
                                                value="${p.t.type}"
                                                class="form-control validate"
                                                />
                                        </div> 
                                        <div class="form-group mb-3">
                                            <label
                                                for="capacity5"
                                                >Capacity
                                            </label>
                                            <input
                                                id="capacity5"
                                                name="capacity5"
                                                type="text"
                                                value="${p.t.capacity}"
                                                class="form-control validate"
                                                />
                                        </div> 
                                        <div class="form-group mb-3">
                                            <label
                                                for="energy"
                                                >Energy Saving Technology
                                            </label>
                                            <input
                                                id="energy"
                                                name="energy"
                                                type="text"
                                                value="${p.t.energySaving}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="refrigeration"
                                                >Refrigeration Technology
                                            </label>
                                            <input
                                                id="refrigeration"
                                                name="refrigeration"
                                                type="text"
                                                value="${p.t.refrigeration}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="antimicrobial"
                                                >Antimicrobial Deodorozing technology
                                            </label>
                                            <input
                                                id="antimicrobial"
                                                name="antimicrobial"
                                                type="text"
                                                value="${p.t.antimicrobialDeodorozing}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="food"
                                                >Food Preservation
                                            </label>
                                            <input
                                                id="food"
                                                name="food"
                                                type="text"
                                                value="${p.t.foodPreservation}"
                                                class="form-control validate"
                                                />
                                        </div>
                                    </c:if>
                                    <c:if test="${p.categoryId == 6}">
                                        <div class="form-group mb-3">
                                            <label
                                                for="type6"
                                                >Type
                                            </label>
                                            <input
                                                id="type6"
                                                name="type6"
                                                type="text"
                                                value="${p.t.type}"
                                                class="form-control validate"
                                                />
                                        </div> 
                                        <div class="form-group mb-3">
                                            <label
                                                for="numfilter"
                                                >Number filter
                                            </label>
                                            <input
                                                id="numfilter"
                                                name="numfilter"
                                                type="text"
                                                value="${p.t.numFilter}"
                                                class="form-control validate"
                                                />
                                        </div> 
                                        <div class="form-group mb-3">
                                            <label
                                                for="capacity6"
                                                >Capacity
                                            </label>
                                            <input
                                                id="capacity6"
                                                name="capacity6"
                                                type="text"
                                                value="${p.t.capacity}"
                                                class="form-control validate"
                                                />
                                        </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="filtration"
                                                >Filtration Discharge Ratio
                                            </label>
                                            <input
                                                id="filtration"
                                                name="filtration"
                                                type="text"
                                                value="${p.t.filtrationDischargeRatio}"
                                                class="form-control validate"
                                                />
                                        </div>
                                    </c:if>
                                    <div class="tm-product-img-edit mx-auto">
                                        <img src="${p.img}main.jpg" alt="Product image" class="img-fluid d-block mx-auto">
                                        <i
                                            class="fas fa-cloud-upload-alt tm-upload-icon"
                                            onclick="document.getElementById('fileInput').click();"
                                            ></i>
                                    </div>
                                    <div class="custom-file mt-3 mb-3">
                                        <input id="fileInput" name="fileInput" type="file" style="display:none;" />
                                        <input
                                            type="button"
                                            class="btn btn-primary btn-block mx-auto"
                                            value="CHANGE IMAGE NOW"
                                            onclick="document.getElementById('fileInput').click();"
                                            />
                                    </div>
                                </div>
                                <div class="col-12">
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase">Update Now</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="admin_footer.jsp" %>

        <script src="./assets/js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="./assets/jquery-ui-datepicker/jquery-ui.min.js"></script>
        <!-- https://jqueryui.com/download/ -->
        <script src="./assets/js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script>
                                                $(function () {
                                                    $("#expire_date").datepicker({
                                                        defaultDate: "10/22/2020"
                                                    });
                                                });
        </script>
    </body>
</html>
