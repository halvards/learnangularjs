// Configuration file for unit tests
// http://karma-runner.github.com/0.10/config/configuration-file.html

module.exports = function(config) {
  config.set({
    // used to resolve files and exclude
    basePath: '../',

    frameworks: ['jasmine', 'commonjs'],

    // list of files / patterns to load in the browser
    files: [
      'app/lib/jquery/jquery.js',
      'app/lib/angular/angular.js',
      'app/lib/angular/angular-*.js',
      'test/lib/unit/angular/angular-*.js',
      'app/js/*.js',
      'test/unit/*-spec.js'
    ],

    // list of files to exclude
    exclude: [],

    preprocessors: {},

    // use dots reporter, as travis terminal does not support escaping sequences
    // possible values: 'dots', 'progress'
    reporters: ['progress', 'junit'],

    junitReporter: {
      // will be resolved to basePath (in the same way as files/exclude patterns)
      outputFile: 'build/unit-test-report.xml',
      suite: 'unit'
    },

    // test server server port
    port: 9879,

    // enable / disable colors in the output (reporters and logs)
    colors: true,

    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,

    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,

    // Start these browsers, currently available:
    // - Chrome
    // - ChromeCanary
    // - Firefox
    // - Opera
    // - Safari (only Mac)
    // - PhantomJS
    // - IE (only Windows)
//    browsers: [process.env.TRAVIS ? 'Firefox' : 'Chrome'],
    browsers: ['PhantomJS'],

    // If browser does not capture in given timeout [ms], kill it
    captureTimeout: 60000,

    // If true, it captures browsers, runs tests and exits with exit code 0 if all tests passed, otherwise exit code 1
    singleRun: false,

    // report which specs are slower than 500ms
    reportSlowerThan: 1000,

    plugins: [
      'karma-jasmine',
      'karma-chrome-launcher',
      'karma-firefox-launcher',
      'karma-phantomjs-launcher',
      'karma-junit-reporter',
      'karma-commonjs'
    ]
  });
};
