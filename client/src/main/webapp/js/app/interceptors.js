'use strict';

// ng is a built-in Angular module containing the services $q, $log, and $location
// console.log(), console.error(), etc also work but the console object is not available in IE
angular.module('httpInterceptors', ['ng']).
    factory('logResponseInterceptor', function ($log) {
        return function (promise) {
            function getResponseSummary(response) {
                return response.config.method + ' ' +
                       response.config.url + ' ' +
                       response.status + ' ' +
                       response.headers('Content-Type').split(';')[0] + ' - ' +
                       response.headers('Content-Length') + 'b';
            }

            return promise.then(
                function success(response) {
                    $log.info(getResponseSummary(response));
                    return response;
                }, function error(response) {
                    $log.error(getResponseSummary(response));
                    return response;
                });
        };
    }).
    factory('detectErrorInterceptor', function ($q, $log, $location) {
        return function (promise) {
            return promise.then(
                function success(response) {
                    return response;
                }, function error(response) {
                    // report error to server here
                    $log.info('Navigating to error page due to error response.');
                    $location.path('/error');
                    return $q.reject(response);
                });
        };
    });
