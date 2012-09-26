// How to use Passport: https://github.com/jaredhanson/passport-local/blob/master/examples/login/app.js

var express = require('express')
    , flash = require('connect-flash')
    , passport = require('passport')
    , util = require('util')
    , LocalStrategy = require('passport-local').Strategy;

var users = [
    { id:1, username:'public', password:'public', roles:[] },
    { id:2, username:'user',   password:'user',   roles:['ROLE_USER'] },
    { id:3, username:'admin',  password:'admin',  roles:['ROLE_ADMIN'] }
];

function findById(id, done) {
    var index = id - 1;
    if (users[index]) {
        done(null, users[index]);
    } else {
        done(new Error('User ' + id + ' does not exist'));
    }
}

function findByUsername(username, done) {
    for (var i = 0, length = users.length; i < length; i++) {
        var user = users[i];
        if (user.username === username) {
            return done(null, user);
        }
    }
    return done(null, null);
}

function ensureAuthenticated(request, response, next) {
    if (request.isAuthenticated()) {
        return next();
    }
    response.redirect('/service/login/login.html')
}

passport.serializeUser(function (user, done) {
    done(null, user.id);
});

passport.deserializeUser(function (id, done) {
    findById(id, function (error, user) {
        done(error, user);
    });
});

passport.use(new LocalStrategy({
        usernameField:'j_username',
        passwordField:'j_password'
    },
    function (username, password, done) {
        findByUsername(username, function (error, user) {
            if (error) {
                return done(error);
            }
            if (!user) {
                return done(null, false, { message:'Unknown user ' + username });
            }
            if (user.password != password) {
                return done(null, false, { message:'Invalid password' });
            }
            return done(null, user);
        })
    }
));

var app = express();
app.configure(function () {
    app.use(express.logger("dev"));
    app.use(express.cookieParser());
    app.use(express.bodyParser());
    app.use(express.methodOverride());
    app.use(express.session({ secret:'keyboard cat' }));
    app.use(flash());
    app.use(passport.initialize());
    app.use(passport.session());
    app.use(app.router);

    // Serve up the client JS application
    app.use('/app', express.static('../client/src/main/webapp'));

    // Reuse login pages from real service
    app.use('/service/login', express.static('../service/src/main/webapp/login'));

    // Serve static files for simple stubbing
    app.use('/service/public', express.static('public'));
    app.use('/service/secure', express.static('secure'));
});

app.post(/.*\/j_security_check/,
    passport.authenticate('local', { failureRedirect:'/service/login/login-failed.html', failureFlash:true }),
    function (request, response) {
        response.redirect('/hello');
    });

app.get('/service/logout', function (request, response) {
    request.logout();
    response.redirect('/service/login/logout.html');
});

// Hello World
app.get('/hello', function (request, response) {
    response.set('Content-Type', 'text/plain');
    response.send('Hello World');
});

app.get('/hellojson', function (request, response) {
    response.send({message:'Hello World'});
});

app.get('/hello/:message', ensureAuthenticated, function (request, response) {
    response.send({message:'Hello ' + request.user.username + ' ' + request.params.message});
});

// This section must appear last
var port = 8000;
app.listen(port);
console.log('STUB service listening on port ' + port);
