'use strict';

angular.module('tasksService', ['ngResource']).
    factory('Tasks', function($resource) {
        return $resource('/service/task/tasktypes.json', {}, {
            query: {method: 'GET', params: {}, isArray: true}
        });
    });
