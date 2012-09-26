'use strict';

// ngResource is a built-in Angular module containing the service $resource

angular.module('tasksService', ['ngResource']).
    factory('Tasks', function($resource) {
        return $resource('/service/public/task/tasktypes.json', {}, {
            query: {method: 'GET', params: {}, isArray: true}
        });
    });
