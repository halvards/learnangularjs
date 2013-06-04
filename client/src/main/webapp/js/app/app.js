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
        // Avoid hash URL fragments in HTML5 browsers: http://docs.angularjs.org/guide/dev_guide.services.$location
        $locationProvider.html5Mode(true);
        // Change # URLs to #! to match Google's AJAX crawling scheme: https://developers.google.com/webmasters/ajax-crawling/
        $locationProvider.hashPrefix('!');
    }]);
