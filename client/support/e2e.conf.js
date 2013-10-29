// Configuration file for end to end tests
// http://karma-runner.github.com/0.8/config/configuration-file.html

// Used to resolve files, relative to this file
basePath = '../';

// Files to load in the browser
files = [
  ANGULAR_SCENARIO,
  ANGULAR_SCENARIO_ADAPTER,
  'test/e2e/*-scenario.js'
];

// Files to be excluded
exclude = [];

// How progress will be reported. Possible values: dots, progress, junit, growl, coverage
reporters = ['progress', 'junit'];

// Test runner server port
port = 9880;

// Command line interface port
runnerPort = 9104;

// Enable / disable colors in the output (reporters and logs)
colors = true;

// Possible values: LOG_DISABLE, LOG_ERROR, LOG_WARN, LOG_INFO, LOG_DEBUG
logLevel = LOG_INFO;

// Set to true to execute tests whenever files change
autoWatch = false;

// List of browsers to run tests. Possible values: Chrome, ChromeCanary, Firefox, Opera, Safari, PhantomJS
browsers = ['PhantomJS'];

// If browser does not capture in given timeout [ms], kill it
captureTimeout = 60000;

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
