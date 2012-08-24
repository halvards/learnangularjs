'use strict';

function TasksController($scope, Tasks) {
    $scope.tasks = Tasks.query();
}
