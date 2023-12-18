<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Product Admin - Dashboard HTML Template</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="./assets/css/fontawesome.min.css">
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="./assets/css/bootstrap.min.css">
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="./assets/css/templatemo-style.css">
        <link rel="stylesheet" href="assets/css/custom.css">
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        -->
        <link rel="icon" href="assets/img/Admin/admin.jfif">
    </head>

    <body id="reportsPage">
        <div class="" id="home">
            <%@include file="admin_header.jsp" %>

            <div class="container">
                <div class="row">
                    <div class="col">
                        <p class="text-white mt-5 mb-5">Welcome back, <b>${sessionScope.admin.name}</b></p>
                    </div>
                </div>
                <!-- row -->
                <div class="row tm-content-row">
                    <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                        <div class="tm-bg-primary-dark tm-block">
                            <h2 class="tm-block-title">Rate sell</h2>
                            <div id="chartContainer" style="height: 300px; width: 100%;"></div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                        <div class="tm-bg-primary-dark tm-block">
                            <h2 class="tm-block-title">Top seller</h2>
                            <div id="chartContainer2" style="height: 300px; width: 100%;"></div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
                        <div class="tm-bg-primary-dark tm-block tm-block-taller">
                            <h2 class="tm-block-title">Status</h2>
                            <div class="row">
                                <div class="col-md-4 market-update-gd">
                                    <div class="market-update-block clr-block-1">
                                        <div class="col-md-8 market-update-left">
                                            <h3>${requestScope.numUser}</h3>
                                            <h4>Registered User</h4>
                                        </div>
                                        <div class="col-md-4 market-update-right">
                                            <i class="fa fa-file-text-o"> </i>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                                <div class="col-md-4 market-update-gd">
                                    <div class="market-update-block clr-block-2">
                                        <div class="col-md-8 market-update-left">
                                            <h3>${requestScope.numOrder}</h3>
                                            <h4>Number of orders</h4>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                                <div class="col-md-4 market-update-gd">
                                    <div class="market-update-block clr-block-3">
                                        <div class="col-md-8 market-update-left">
                                            <h3>${requestScope.numComment}</h3>
                                            <h4>Number comments</h4>
                                        </div>
                                        <div class="col-md-4 market-update-right">
                                            <i class="fa fa-envelope-o"> </i>
                                        </div>
                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 tm-block-col">
                        <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
                            <h2 class="tm-block-title">Orders List</h2>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">ORDER NO.</th>
                                        <th scope="col">USER NAME</th>
                                        <th scope="col">ADDRESS</th>
                                        <th scope="col">ORDER DATE</th>
                                        <th scope="col">TOTAL MONEY</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.orderList}" var="o">
                                        <tr>
                                            <th scope="row"><b>#${o.oid}</b></th>
                                            <td><b>${o.user.name}</b></td>
                                            <td><b>${o.user.avatar}</b></td>
                                            <td>${o.orderDate}</td>
                                            <td><fmt:setLocale value="vi_VN"/><fmt:formatNumber value="${o.totalMoney}" type="currency"></fmt:formatNumber></td>
                                            </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="admin_footer.jsp" %>
        </div>

        <script src="./assets/js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="./assets/js/moment.min.js"></script>
        <!-- https://momentjs.com/ -->
        <script src="./assets/js/Chart.min.js"></script>
        <!-- http://www.chartjs.org/docs/latest/ -->
        <script src="./assets/js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script src="./assets/js/tooplate-scripts.js"></script>
        <script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>

        <script>
            Chart.defaults.global.defaultFontColor = 'white';
            let ctxLine,
                    ctxBar,
                    ctxPie,
                    optionsLine,
                    optionsBar,
                    optionsPie,
                    configLine,
                    configBar,
                    configPie,
                    lineChart;
            barChart, pieChart;
            // DOM is ready
            $(function () {
                drawLineChart(); // Line Chart
                drawBarChart(); // Bar Chart
                drawPieChart(); // Pie Chart

                $(window).resize(function () {
                    updateLineChart();
                    updateBarChart();
                });
            })
        </script>
        <script>
            window.onload = function () {
                chart1('${requestScope.numSell}', '${requestScope.topSeller}');
            }
        </script>

        <script>
            function chart1(numSell, topSeller) {
// Step 1: Parse the string into a JavaScript object
                var numSellObject = JSON.parse(
                        numSell
                        .replace(/{/g, '{ "')
                        .replace(/=/g, '": ')
                        .replace(/, /g, ', "')
                        .replace(/,}/g, ' }')
                        );

// Step 2: Create a Map
                var dataPoints = [];

                // Iterate through the object properties and add them to the dataPoints array
                for (var key in numSellObject) {
                    if (numSellObject.hasOwnProperty(key)) {
                        dataPoints.push({label: key, y: numSellObject[key]});
                    }
                }

// Now, numSellMap is a Map with the data from numSellObject
                console.log(dataPoints);
                var chart = new CanvasJS.Chart("chartContainer", {
                    animationEnabled: true,
                    title: {
                        text: "Rate sell of each category"
                    },
                    data: [{
                            type: "pie",
                            startAngle: 240,
                            yValueFormatString: "##0.00\"%\"",
                            indexLabel: "{label} {y}",
                            dataPoints: dataPoints
                        }]
                });
                chart.render();

                var numSellObject2 = JSON.parse(
                        topSeller
                        .replace(/{/g, '{ "')
                        .replace(/=/g, '": ')
                        .replace(/, /g, ', "')
                        .replace(/,}/g, ' }')
                        );

// Step 2: Create a Map
                var dataPoints2 = [];

                // Iterate through the object properties and add them to the dataPoints array
                for (var key in numSellObject2) {
                    if (numSellObject2.hasOwnProperty(key)) {
                        dataPoints2.push({label: key, y: numSellObject2[key]});
                    }
                }
                console.log(dataPoints2);
                var chart2 = new CanvasJS.Chart("chartContainer2", {
                    animationEnabled: true,
                    theme: "light2", // "light1", "light2", "dark1", "dark2"
                    title: {
                        text: "Top 5 seller products"
                    },
                    axisY: {
                        title: "Number sold"
                    },
                    data: [{
                            type: "column",
                            showInLegend: true,
                            legendMarkerColor: "grey",
                            dataPoints: dataPoints2
                        }]
                });
                chart2.render();
            }
        </script>
    </body>

</html>