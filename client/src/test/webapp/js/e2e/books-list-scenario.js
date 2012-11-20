'use strict';

/* http://docs.angularjs.org/guide/dev_guide.e2e-testing */

describe('Bookstore App', function () {
    it('should list novels', function () {
        browser().navigateTo('books');
        window.top.console.log("logging works");
        expect(browser().location().url()).toBe('/books');
        expect(element('#booksforsale tbody tr', 'List of books for sale').count()).toBe(10);
    });
});
