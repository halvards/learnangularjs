'use strict';

// ngResource is a built-in Angular module containing the service $resource

var booksModule = angular.module('booksModule', ['ngResource']);

booksModule.factory('BooksService', function ($resource) {
  return $resource('/service/public/item/booksforsale.json', {}, {
    query: {method: 'GET', params: {}, isArray: true}
  });
});
