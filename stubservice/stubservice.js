var express = require('express');  // http://expressjs.com/
var app = express();

// Serve up the client JS application
app.use('/app', express.static('../client/src/main/webapp'));

// Serve static files for simple stubbing
app.use('/service/public', express.static('public'));

// Hello World
app.get('/hello', function (request, response) {
    response.set('Content-Type', 'text/plain');
    response.send('Hello World');
});
app.get('/hellojson', function (request, response) {
    response.send({message:'Hello World'});
});
app.get('/hello/:name', function (request, response) {
    response.send({message:'Hello ' + request.params.name});
});

// This section must appear last
var port = 8000;
app.listen(port);
console.log('STUB service listening on port ' + port);
