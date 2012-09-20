learnangularjs
==============

An example AngularJS application with a Java backend.

# Requirements

This project requires that [Gradle](http://gradle.org/), [PhantomJS](http://phantomjs.org/),
and [NodeJS](http://nodejs.org/) are installed.
Mac users can install all of them using homebrew:

    brew update
    brew install gradle
    brew install phantomjs
    brew install nodejs

Gradle is the build system used by the project, PhantomJS is used to run JavaScript unit tests and end-to-end scenarios in headless
mode from the build, while NodeJS is used to run a simple Web server used by the client sub-project to stub the server-side.

# IntelliJ IDEA Setup

To create IntelliJ IDEA project files, run:

    gradle cleanIdea idea

Ensure you have the following IDEA plugins:

* AngularJS
* Gradle (bundled)
* NodeJS
* JSTestDriver
* All the bundled JavaScript plugins

If needed, set the Gradle home directory IDEA setting to /usr/local/Cellar/gradle/<version>/libexec

# Gradle Tasks

To see all available tasks, including their dependencies, run:

    gradle tasks --all

# Suggested Reading (and Watching)

* [AngularJS presentation at GTAC 2011](http://www.youtube.com/watch?v=gQclnI_8Vmg) (video)
* [Tutorial](http://docs.angularjs.org/tutorial)
* [Developer Guide](http://docs.angularjs.org/guide/), and in particular
** [Dependency Injection](http://docs.angularjs.org/guide/di)
** [Unit Testing](http://docs.angularjs.org/guide/dev_guide.unit-testing)
** [End-to-end Testing](http://docs.angularjs.org/guide/dev_guide.e2e-testing)
* [Internet Explorer Compatibility](http://docs.angularjs.org/guide/ie)
* [Data Binding](http://stackoverflow.com/questions/9682092/databinding-in-angularjs/9693933#9693933)
