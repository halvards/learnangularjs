'use strict';

function ItemsController($scope, Novels) {
    $scope.novels = Novels.query();
}

function ErrorController($scope) {

}
