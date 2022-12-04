angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/market/api/v1';

    $scope.loadProduct = function (pageIndex = 1) {
        console.log("Filter");
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                title_part: $scope.filter ? $scope.filter.title_part : null,
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null,
            }
        }).then(function (response) {
            $scope.ProductsPage = response.data;
        });
    }

    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
            .then(function (response) {
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