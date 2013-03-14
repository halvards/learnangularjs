/* exported BooksController, ErrorController */

'use strict';

function BooksController($scope, BooksService) {
    $scope.init = function () {
        $scope.books = BooksService.query();
    };
}

function ErrorController() {
}
