'use strict';

describe('BooksService', function () {
    beforeEach(module('booksModule'))

    it('should retrieve books for sale', inject(function ($httpBackend, BooksService) {
        $httpBackend.when('GET', '/service/public/item/booksforsale.json').respond(200, [
            { "title": "Don Quixote" },
            { "title": "Pilgrim's Progress" }
        ]);
        var booksPromise = BooksService.query();
        $httpBackend.flush(); // blocking
        expect(booksPromise.length).toEqual(2);
    }));
});
