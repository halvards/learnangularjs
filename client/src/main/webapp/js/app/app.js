'use strict';


angular.module('taskListApp', ['tasksService', 'httpInterceptors']).
    config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
        when('/tasks', {templateUrl:'partials/tasks.html'});
}]).config(['$httpProvider', function ($httpProvider) {
    $httpProvider.responseInterceptors.push('loginInterceptor');
}]);
