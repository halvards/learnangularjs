'use strict';

angular.module('cartModule', ['ngResource']).
  factory('Cart', function ($resource) {

    // $resource provides some default actions:
    // { 'get':    {method:'GET'},
    //   'save':   {method:'POST'},
    //   'query':  {method:'GET', isArray:true},
    //   'remove': {method:'DELETE'},
    //   'delete': {method:'DELETE'} };
    var Cart = $resource('/service/public/cart/:cartId', {'cartId': '@id'});

    var items = {}; // map itemId -> quantity

    Cart.prototype.add = function(itemId) {
      items[itemId] = items[itemId] ? items[itemId] + 1 : 1;
    };

    return Cart;
  });
