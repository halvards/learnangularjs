'use strict';

angular.module('tasksService', ['ngResource']).
    factory('Tasks', function($resource) {
        return $resource('tasks.json', {}, {
            query: {method: 'GET', params: {}, isArray: true}
        });
    });
