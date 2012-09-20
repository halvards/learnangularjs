'use strict';

/* http://docs.angularjs.org/guide/dev_guide.e2e-testing */

describe('Todo List App', function () {

    it('should echo task type selection', function () {
        browser().navigateTo('tasks');
        window.top.console.log("logging works");
        expect(browser().location().url()).toBe('/tasks');
        pause();
    });
});
