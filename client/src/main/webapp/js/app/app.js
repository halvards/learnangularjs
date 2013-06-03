'use strict';

angular.module('bookstoreApp', ['booksModule', 'httpInterceptors']).
     config(['$routeProvider', function ($routeProvider) {
        $routeProvider.
            when('/books', {templateUrl: 'partials/books.html'}).
            when('/cart', {templateUrl: 'partials/cart.html'}).
            when('/error', {templateUrl: 'partials/error.html'}).
            otherwise({redirectTo: '/books'});
    }]).config(['$httpProvider', function ($httpProvider) {
        $httpProvider.responseInterceptors.push('logResponseInterceptor');
        $httpProvider.responseInterceptors.push('detectErrorInterceptor');
    }]).config(['$locationProvider', function ($locationProvider) {
        $locationProvider.html5Mode(true);
    }]);
