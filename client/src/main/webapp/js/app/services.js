'use strict';

// ngResource is a built-in Angular module containing the service $resource

angular.module('itemsService', ['ngResource']).
    factory('Novels', function($resource) {
        return $resource('/service/public/item/novelsforsale.json', {}, {
            query: {method: 'GET', params: {}, isArray: true}
        });
    });
