// Configuration file for unit tests
// http://karma-runner.github.com/0.8/config/configuration-file.html

// Used to resolve files, relative to this file
basePath = '../';

// Files to load in the browser
files = [
  JASMINE,
  JASMINE_ADAPTER,
  'src/main/webapp/js/lib/jquery/jquery.js',
  'src/main/webapp/js/lib/angular/angular.js',
  'src/main/webapp/js/lib/angular/angular-*.js',
  'src/test/webapp/js/lib/unit/angular/angular-*.js',
  'src/main/webapp/js/app/*.js',
  'src/test/webapp/js/unit/*-spec.js'
];

// Files to be excluded
exclude = [];

// How progress will be reported. Possible values: dots, progress, junit, growl, coverage
reporters = ['progress', 'junit'];

// Test runner server port
port = 9879;

// Command line interface port
runnerPort = 9103;

// Set to true to execute tests whenever files change
autoWatch = true;

// Possible values: LOG_DISABLE, LOG_ERROR, LOG_WARN, LOG_INFO, LOG_DEBUG
logLevel = LOG_INFO;

// List of browsers to run tests. Possible values: Chrome, ChromeCanary, Firefox, Opera, Safari, PhantomJS
browsers = ['PhantomJS'];

// If true, it captures browsers, runs tests and exits with exit code 0 if all tests passed, otherwise exit code 1
singleRun = false;

junitReporter = {
  outputFile: 'build/unit-test-report.xml',
  suite: 'unit'
};
