'use strict';

angular.module('taskListApp', ['tasksService']).
    config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/tasks', {templateUrl: 'partials/tasks.html', controller: TasksController});
}]);
