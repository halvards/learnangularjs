'use strict';

/* https://github.com/angular/protractor */

describe('Bookstore App Protractor', function () {
  it('should list novels', function (done) {
    browser.get('/app/');
    console.log("logging works");
    expect(browser.getCurrentUrl()).toBe(browser.baseUrl + '/app/books');
    expect(element.all(by.css('#booksforsale tbody tr')).count()).toBe(10);
    expect(element.all(by.repeater('book in books')).count()).toBe(10);
  });
});
