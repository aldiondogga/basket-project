/**
 * Created by Dogga on 15/10/2016.
 */
angular.module('basketApp.basket-ctrl',  [
    'ngMaterial', 'ngMdIcons', 'ngRoute',
    'basketApp.Services'])

    .controller('BasketCtrl', function($scope, $routeParams, $rootScope, ProductService, BasketService) {

        $rootScope.productList = [];
        $scope.basket = [];
        $scope.itemList =[];


        $scope.addItem = function(product,quantity){
            var isPresent=false;
            for(var i =0;i<$scope.itemList.length;i++){
                if($scope.itemList[i].product.id == product.id){
                    isPresent=true;
                }
            }
            if(!isPresent){
                var item ={"product":product,"quantity":quantity,"amount":0,"taxes":0};
                $scope.itemList.push(item);
                $scope.checkout();
            }
        }
        $scope.checkout =function(){
            BasketService.checkout($scope.itemList).then(function(data){
                $scope.basket = data;
            },function(error){
                $scope.showAlert(error,'Error, please try again');
            })
        }

        $scope.deleteItem =function(item){
            $scope.itemList = $scope.itemList.filter(function(element) {
                return element.product.id !== item.product.id;
            });
            $scope.checkout();
        }

        $rootScope.getAllProduct = function(){
            ProductService.loadProducts().then(function(data){
                $rootScope.productList = data;
            },function(error){
                $scope.showAlert(error,'Error, please try again');
            })
        }


    });

