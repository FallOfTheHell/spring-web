angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/market';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.changeScore = function (productId, delta) {
        console.log("Click");
        $http({
            url: contextPath + '/products/change_cost',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.createProduct = function () {
        console.log($scope.newProduct);
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function (response) {
                $scope.loadProducts();
            });
    }


    $scope.filterProduct = function () {
        console.log("Filter");
        $http({
            url: contextPath + '/products/filter_cost',
            method: 'GET',
            params: {
                min: $scope.minCostProduct.cost,
                max: $scope.maxCostProduct.cost
            }
        }).then(function (response) {
            $scope.ProductsList = response.data;
        });
    }


    $scope.currentPage = function (){
        if ($scope.minCostProduct.cost == null && $scope.maxCostProduct.cost == null){
            $scope.loadProducts();
        } else {
            $scope.filterProduct();
        }
    }

    //$scope.currentPage();
    $scope.loadProducts();
});