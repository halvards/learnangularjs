'use strict';

// ng is a built-in Angular module containing the services $q and $log
// console.log(), console.error(), etc also work but the console object is not available in IE

angular.module('httpInterceptors', ['ng']).
    factory('loginInterceptor', function ($q, $log) {
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
                    $log.info(response);
                    return response;
                }, function error(response) {
                    $log.error(getResponseSummary(response));
                    return $q.reject(response);
                });
        }
    });
