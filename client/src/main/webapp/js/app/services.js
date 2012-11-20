'use strict';

// ngResource is a built-in Angular module containing the service $resource

angular.module('booksModule', ['ngResource']).
    factory('BooksService', function($resource) {
        return $resource('/service/public/item/booksforsale.json', {}, {
            query: {method: 'GET', params: {}, isArray: true}
        });
    });
