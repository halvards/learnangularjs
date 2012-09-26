// How to use Passport: https://github.com/jaredhanson/passport-local/blob/master/examples/login/app.js

var passport = require('passport')
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

exports.ensureAuthenticated = function (request, response, next) {
    if (request.isAuthenticated()) {
        return next();
    }
    response.redirect('/service/login/login.html')
}

exports.configure = function (app) {
    app.use(passport.initialize());
    app.use(passport.session());

    app.post(/.*\/j_security_check/,
        passport.authenticate('local', { failureRedirect:'/service/login/login-failed.html' }),
        function (request, response) {
            response.redirect('/hello');
        });

    app.get('/service/logout', function (request, response) {
        request.logout();
        response.redirect('/service/login/logout.html');
    });
}
