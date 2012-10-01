'use strict';


angular.module('bookstoreApp', ['itemsService', 'httpInterceptors']).
    config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
        when('/items', {templateUrl:'partials/items.html'}).
        when('/cart', {templateUrl:'partials/cart.html'}).
        when('/error', {templateUrl:'partials/error.html'}).
        otherwise({redirectTo:'/items'});
}]).config(['$httpProvider', function ($httpProvider) {
    $httpProvider.responseInterceptors.push('logResponseInterceptor');
    $httpProvider.responseInterceptors.push('detectErrorInterceptor');
}]);
