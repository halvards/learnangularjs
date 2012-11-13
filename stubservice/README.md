learnangularjs:stubservice
==========================

Stub implementation of the Tasks service (from the 'service' sub-project), to enable fast feedback for development of the AngularJS-based
browser client (as well as other future clients like native mobile applications).

It uses [NodeJS](http://nodejs.org/) and [Express](http://expressjs.com/) (a [Sinatra](http://www.sinatrarb.com/)-like JavaScript framework),
with [Passport](http://passportjs.org/) for authentication.

The stub service can either return responses based on routes set up in stubservice.js, or from static files in the 'public' and
'secure' directories.

After installing NodeJS, run this command to fetch dependencies:

    npm install

Run the stub service with this command:

    node stubservice
