'use strict';

/* http://docs.angularjs.org/guide/dev_guide.e2e-testing */

describe('Bookstore App', function () {

    it('should list novels', function () {
        browser().navigateTo('items');
        window.top.console.log("logging works");
        expect(browser().location().url()).toBe('/items');
        expect(element('#novels tbody tr', 'List of novels for sale').count()).toBe(10);
    });
});
