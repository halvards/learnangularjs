'use strict';

/* http://docs.angularjs.org/guide/dev_guide.e2e-testing */

describe('Todo List App', function () {

    it('should list task types', function () {
        browser().navigateTo('tasks');
        window.top.console.log("logging works");
        expect(browser().location().url()).toBe('/tasks');
        expect(element('#task option', 'List of task types').count()).toBe(4);
    });
});
