'use strict';

/* http://docs.angularjs.org/guide/dev_guide.e2e-testing */

describe('Todo List App', function () {

    it('should echo task type selection', function () {
//    browser().navigateTo('http://localhost:8000/index.html#/tasks');
        browser().navigateTo('/index.html#/tasks');
        window.top.console.log("logging works");
        expect(browser().location().url()).toBe('/tasks');
    });
});
