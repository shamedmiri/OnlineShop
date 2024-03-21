<!DOCTYPE html>
<html lang="en" dir="ltr">
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0">
<link href="libs/bootstrap-5.3.3-dist/bootstrap-5.3.3-dist/css/bootstrap.min.css" rel="stylesheet"/>
<script src="libs/jquery-3.7.1.min.js"></script>
<script src="libs/bootstrap-5.3.3-dist/bootstrap-5.3.3-dist/js/bootstrap.min.js"></script>
<script src="libs/angular.min.js"></script>
<link href="libs/fontawesome-free-6.5.1-web/css/all.css" rel="stylesheet"/>
<script src="libs/sweetalert2-11.10.6/package/dist/sweetalert2.all.min.js"></script>
<link href="libs/sweetalert2-11.10.6/package/dist/sweetalert2.min.css" rel="stylesheet"/>
<link href="libs/textAngular-1.5.16/dist/textAngular.css" rel="stylesheet"/>
<script src="libs/textAngular-1.5.16/dist/textAngular-rangy.min.js"></script>
<script src="libs/textAngular-1.5.16/dist/textAngular.min.js"></script>
<script src="libs/textAngular-1.5.16/dist/textAngular-sanitize.js"></script>
<script src="libs/textAngular-1.5.16/dist/textAngular-sanitize.min.js"></script>
<script src="libs/angular-cookies.js"></script>
<script src="scripts/app.js"></script>
<script src="scripts/controllers/directives/fileModel.js"></script>
<script src="scripts/controllers/util/UploadFileController.js"></script>
<script src="scripts/controllers/util/GetFilesCtrl.js"></script>
<script src="scripts/services/ApiHandler.js"></script>
<script src="scripts/controllers/directives/fileModel.js"></script>
<script src="scripts/controllers/util/UploadFileController.js"></script>
<script src="scripts/controllers/panelController.js"></script>
<script src="scripts/controllers/site/nav/navListController.js"></script>
<script src="scripts/controllers/site/nav/navAddController.js"></script>
<script src="scripts/controllers/site/nav/navEditController.js"></script>
<script src="scripts/controllers/site/content/contentListController.js"></script>
<script src="scripts/controllers/site/content/contentAddController.js"></script>
<script src="scripts/controllers/site/content/contentEditController.js"></script>
<script src="scripts/controllers/site/slider/sliderListController.js"></script>
<script src="scripts/controllers/site/slider/sliderAddController.js"></script>
<script src="scripts/controllers/site/slider/sliderEditController.js"></script>
<link href="styles/panel.css" rel="stylesheet"/>

<body ng-app="onlineShop">
<div class="container-fluid"  ng-controller="panelCtrl">
    <div >
        <row class="row">
            <div class="panel-header">
                <a href="/logout" class="btn btn-danger btn-sm float-left ">Log out</a>
            </div>
        </row>
        <row class="row">
            <div class="col-2 shadow-lg p-3 mb-5 bg-body-tertiary rounded">
                <div class="side-nav">
                <div class="text-center p-3" >
                    <img src="images/user.png" width="100">
                    <br>
                    <span>{{user.fullName}}</span>
                </div>
                <ul>
                    <li ng-class="{'side-nav-active': templateGroup=='dashboard'}">
                        <a href="#" ng-click="changeMenu('dashboard')" >
                            <i class="fa fa-link" ></i>
                            <span>Dashboard</span>
                        </a>
                    </li>
                    <li ng-class="{'side-nav-active': templateGroup=='nav'}">
                        <a href="#" ng-click="changeMenu('nav-list')" >
                            <i class="fa fa-link"></i>
                            <span>Navigation</span>
                        </a>
                    </li>
                    <li ng-class="{'side-nav-active': templateGroup=='content'}">
                        <a href="#" ng-click="changeMenu('content-list')" >
                            <i class="fa fa-link"></i>
                            <span>Content</span>
                        </a>
                    </li>
                    <li ng-class="{'side-nav-active': templateGroup=='slider'}">
                        <a href="#" ng-click="changeMenu('slider-list')">
                            <i class="fa fa-photo-film"></i>
                            <span>Slider</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-newspaper"></i>
                            <span>Blog</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-cubes"></i>
                            <span>Products</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-users"></i>
                            <span>Users</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-shopping-bag"></i>
                            <span>Customers</span>
                        </a>
                    </li>
                    <li ng-class="{'side-nav-active': templateGroup=='uploader'}">
                        <a href="#" ng-click="changeMenu('uploader')">
                            <i class="fa fa-photo-film"></i>
                            <span>File manager</span>
                        </a>
                    </li>
                </ul>
            </div>
            </div>
            <div class="col">
                <div class="main-container shadow-lg p-3 mb-5 bg-body-tertiary rounded" ng-include="template">

                </div>
            </div>
        </row>

    </div>
</div>
</body>
</html>