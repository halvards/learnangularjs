'use strict';

describe('BooksController', function () {
  it('init should load books for sale', function () {
    var scope = {};
    var controller = new BooksController(scope, StubBooksService(), function(){});
    scope.init();
    expect(scope.books).toEqual(StubBooksService().query());
  });

  function StubBooksService() {
    return {
      query: function () {
        return [
          { "title": "Book 1" },
          { "title": "Book 2" }
        ];
      }
    };
  }
});
