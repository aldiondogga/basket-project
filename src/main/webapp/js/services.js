/**
 * Created by Dogga on 15/10/2016.
 */
angular.module('basketApp.Services', [])
    .service('BasketService', function($http) {

        this.checkout = function(itemList){
            return $http({
                method : 'POST',
                url :   '/BasketServlet',
                data :  'method=' + 'CHECKOUT'+ '&' +
                'pojo=' + encodeURIComponent(angular.toJson(itemList)),
                headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
            }).then(function(response) {
                if (typeof response === 'object') {
                    if(response.status == '200'){
                        return response.data;
                    }
                    else{
                        //call back with status not correct
                        return $q.reject(response.data);
                    }
                }else {
                    // invalid response
                    return $q.reject(response.data);
                }

            }, function(response) {
                console.log("SOMETHING WENT WRONG IN PROMISE");
                return $q.reject(response.data);
            });
        }

    })
    .service('ProductService', function($http) {
        this.loadProducts = function(){
            return $http({
                method : 'POST',
                url :   '/ProductServlet',
                data :  'method=' + 'LOAD_PRODUCT',
                headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
            }).then(function(response) {
                if (typeof response === 'object') {
                    if(response.status == '200'){
                        return response.data;
                    }
                    else{
                        //call back with status not correct
                        return $q.reject(response.data);
                    }
                }else {
                    // invalid response
                    return $q.reject(response.data);
                }

            }, function(response) {
                console.log("SOMETHING WENT WRONG IN PROMISE");
                return $q.reject(response.data);
            });
        }
        this.addAllProduct = function(){
            return $http({
                method : 'POST',
                url :   '/ProductServlet',
                data :  'method=' + 'ADD_ALL_PRODUCT',
                headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
            }).then(function(response) {
                if (typeof response === 'object') {
                    if(response.status == '200'){
                        return response.data;
                    }
                    else{
                        //call back with status not correct
                        return $q.reject(response.data);
                    }
                }else {
                    // invalid response
                    return $q.reject(response.data);
                }

            }, function(response) {
                console.log("SOMETHING WENT WRONG IN PROMISE");
                return $q.reject(response.data);
            });
        }
        this.addProduct = function(product){
            return $http({
                method : 'POST',
                url :   '/ProductServlet',
                data :  'method=' + 'ADD_PRODUCT'+ '&' +
                'pojo=' + encodeURIComponent(angular.toJson(product)),
                headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
            }).then(function(response) {
                if (typeof response === 'object') {
                    if(response.status == '200'){
                        return response.data;
                    }
                    else{
                        //call back with status not correct
                        return $q.reject(response.data);
                    }
                }else {
                    // invalid response
                    return $q.reject(response.data);
                }

            }, function(response) {
                console.log("SOMETHING WENT WRONG IN PROMISE");
                return $q.reject(response.data);
            });
        }
    });

