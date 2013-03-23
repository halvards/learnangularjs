// Configuration file for end to end tests
// http://karma-runner.github.com/0.8/config/configuration-file.html

// Used to resolve files, relative to this file
basePath = '../';

// Files to load in the browser
files = [
  ANGULAR_SCENARIO,
  ANGULAR_SCENARIO_ADAPTER,
  'src/test/webapp/js/e2e/*-scenario.js'
];

// Files to be excluded
exclude = [];

// How progress will be reported. Possible values: dots, progress, junit, growl, coverage
reporters = ['progress', 'junit'];

// Test runner server port
port = 9880;

// Command line interface port
runnerPort = 9104;

// Set to true to execute tests whenever files change
autoWatch = false;

// Possible values: LOG_DISABLE, LOG_ERROR, LOG_WARN, LOG_INFO, LOG_DEBUG
logLevel = LOG_INFO;

// List of browsers to run tests. Possible values: Chrome, ChromeCanary, Firefox, Opera, Safari, PhantomJS
browsers = ['PhantomJS'];

// If true, it captures browsers, runs tests and exits with exit code 0 if all tests passed, otherwise exit code 1.
// If false, the test server and browser keeps running after tests are complete. This is usefulfor fast test feedback.
singleRun = true;

// A map of path-proxy pairs
proxies = {
  '/': 'http://localhost:8000/'
};

junitReporter = {
  outputFile: 'build/e2e-test-report.xml',
  suite: 'e2e'
};
