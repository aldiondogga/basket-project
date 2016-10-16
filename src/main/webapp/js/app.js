
angular.module('basketApp', [
    'ngMaterial', 'ngMdIcons', 'ngRoute', 'basketApp.basket-ctrl',
    'basketApp.product-ctrl','basketApp.Services'])

    .config(function ($routeProvider) {



        $routeProvider
            .when('/basket',{
                templateUrl: 'basket.html',
                controller: 'BasketCtrl'
            })
            .when('/product',{
                templateUrl: 'product.html',
                controller: 'ProductCtrl',
            })
            .otherwise({
                templateUrl: 'basket.html',
                controller: 'BasketCtrl'
            });


    })
