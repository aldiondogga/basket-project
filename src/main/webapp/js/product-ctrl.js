/**
 * Created by Dogga on 15/10/2016.
 */
angular.module('basketApp.product-ctrl', [
    'ngMaterial', 'ngMdIcons', 'ngRoute',
    'basketApp.Services'])

    .controller('ProductCtrl', function ($scope, $rootScope, $routeParams, ProductService, $mdDialog) {

        $rootScope.productList = [];
        $scope.product = {};
        $scope.message = "";
        $scope.messageList = "";

        $scope.addAllProduct = function () {
            ProductService.addAllProduct().then(function (data) {
                $rootScope.getAllProduct();
                $scope.messageList = 'The products has been added correctly';
            }, function (error) {
                $scope.messageList = 'Error, please try again';
            })
        }
        $scope.addProduct = function (product) {
            ProductService.addProduct(product).then(function (data) {
                $scope.product = {};
                $scope.message = 'The product has been added correctly';
                $rootScope.getAllProduct();
            }, function (error) {
                $scope.message = 'Error, please try again';
            })
        }

    });
