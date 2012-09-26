var express = require('express')
    , authenticate = require('./authenticate');

var app = express();
app.configure(function () {
    app.use(express.logger("dev"));
    app.use(express.cookieParser());
    app.use(express.bodyParser());
    app.use(express.methodOverride());
    app.use(express.session({ secret:'keyboard cat' }));
    authenticate.configure(app);  // this must appear _before_ app.use(app.router)
    app.use(app.router);

    // Serve up the client JS application
    app.use('/app', express.static('../client/src/main/webapp'));

    // Reuse login pages from real service
    app.use('/service/login', express.static('../service/src/main/webapp/login'));

    // Serve static files for simple stubbing
    app.use('/service/public', express.static('public'));
    app.use('/service/secure', express.static('secure'));
});

// Hello World
app.get('/hello', function (request, response) {
    response.set('Content-Type', 'text/plain');
    response.send('Hello World');
});

app.get('/hellojson', function (request, response) {
    response.send({message:'Hello World'});
});

app.get('/hello/:message', authenticate.ensureAuthenticated, function (request, response) {
    response.send({message:'Hello ' + request.user.username + ' ' + request.params.message});
});

// This section must appear last
var port = 8000;
app.listen(port);
console.log('STUB service listening on port ' + port);
