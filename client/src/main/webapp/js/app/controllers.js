/* exported BooksController, ErrorController */

'use strict';

function BooksController($scope, BooksService, Cart) {
  var cart = new Cart();

  $scope.init = function () {
    $scope.books = BooksService.query();
  };

  $scope.addToCart = cart.add;
}

function ErrorController() {
}
