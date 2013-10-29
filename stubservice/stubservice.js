#!/usr/bin/env node

var express = require('express')
  , authenticate = require('./authenticate')
  , http = require('http')
  , path = require('path')
  , modRewrite = require('connect-modrewrite');

var app = express();

app.set('port', process.env.PORT || 8000);
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.cookieParser());
app.use(express.bodyParser());
app.use(express.methodOverride());
app.use(express.session({ secret: 'keyboard cat' }));
authenticate.configure(app);  // this must appear _before_ app.use(app.router)
app.use(app.router);
app.use(express.errorHandler()); // development only
app.enable('trust proxy');

// Handle the HTML5 push state URL feature of AngularJS by rewriting all non-resource requests to the base /app/index.html file
app.use(modRewrite(['^\/app((?!.*(\/css|\/js|\/lib|\/partials)).*)$ /app/']));

// Serve up the client JS application
app.use('/app', express.static('../client/app'));

// Reuse login pages from real service
app.use('/service/login', express.static('../service/src/main/webapp/login'));

// Serve static files for simple stubbing
app.use('/service/public', express.static('public'));
app.use('/service/secure', express.static('secure'));

// Hello World
app.get('/hello', function (request, response) {
  response.set('Content-Type', 'text/plain');
  response.send('Hello World');
});

app.get('/hellojson', function (request, response) {
  response.send({message: 'Hello World'});
});

app.get('/hello/:message', authenticate.ensureAuthenticated, function (request, response) {
  response.send({message: 'Hello ' + request.user.username + ' ' + request.params.message});
});

// This section must appear last
http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
