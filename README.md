learnangularjs
==============

An example AngularJS application with a Java backend.

This project requires that [Gradle](http://gradle.org/) and [PhantomJS](http://phantomjs.org/) is installed. Mac users can install both
using homebrew:

    brew install gradle
    brew install phantomjs

To create IntelliJ IDEA project files, run:

    gradle idea

Ensure you have the following IDEA plugins:

* AngularJS
* Gradle
* JSTestDriver
* All the bundled JavaScript plugins

If needed, set the Gradle home directory IDEA setting to /usr/local/Cellar/gradle/<version>/libexec

Suggested reading:

* [Dependency Injection](http://docs.angularjs.org/guide/di)
* [Unit Testing](http://docs.angularjs.org/guide/dev_guide.unit-testing)
* [End-to-end Testing](http://docs.angularjs.org/guide/dev_guide.e2e-testing)
* [Internet Explorer Compatibility](http://docs.angularjs.org/guide/ie)
* [Data Binding](http://stackoverflow.com/questions/9682092/databinding-in-angularjs/9693933#9693933)
