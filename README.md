[![Build Status](https://travis-ci.org/halvards/learnangularjs.png)](https://travis-ci.org/halvards/learnangularjs)

learnangularjs
==============

An example [AngularJS](http://angularjs.org/) application with a Java backend.

# Requirements

This project requires that [Gradle](http://gradle.org/), [PhantomJS](http://phantomjs.org/),
and [NodeJS](http://nodejs.org/) are installed.
Mac users can install all of them using [Homebrew](http://mxcl.github.com/homebrew/):

    brew update ; brew install gradle phantomjs nodejs

Gradle is the build system used by the project, PhantomJS is used to run JavaScript unit tests and end-to-end scenarios in headless
mode from the build, while NodeJS is used to run a simple Web server used by the client sub-project to stub the server-side.

# IntelliJ IDEA Setup

I strongly recommend [IntelliJ IDEA Ultimate](http://www.jetbrains.com/idea/) version 12.0 or later.

To create IntelliJ IDEA project files, run:

    gradle cleanIdea idea

Ensure you have the following IDEA plugins:

* AngularJS
* Gradle (bundled)
* NodeJS
* All the bundled JavaScript plugins

If needed, set the Gradle home directory IDEA setting to /usr/local/Cellar/gradle/<version>/libexec

# Gradle Tasks

To see all available tasks, run:

    gradle tasks

To also see all task dependencies, run:

    gradle tasks --all

# Suggested Reading (and Watching)

* [AngularJS presentation at GTAC 2011](http://www.youtube.com/watch?v=gQclnI_8Vmg) (video)
* [Tutorial](http://docs.angularjs.org/tutorial)
* [Developer Guide](http://docs.angularjs.org/guide/), and in particular
  * [Dependency Injection](http://docs.angularjs.org/guide/di)
  * [Unit Testing](http://docs.angularjs.org/guide/dev_guide.unit-testing)
  * [End-to-end Testing](http://docs.angularjs.org/guide/dev_guide.e2e-testing)
* [Internet Explorer Compatibility](http://docs.angularjs.org/guide/ie)
* [Data Binding](http://stackoverflow.com/questions/9682092/databinding-in-angularjs/9693933#9693933)
* [Egghead.io videos](http://egghead.io/)
* [Tips and Tricks](http://deansofer.com/posts/view/14/AngularJs-Tips-and-Tricks-UPDATED)
* [YouTube channel](https://www.youtube.com/user/angularjs)
* [Google+ Community](https://plus.google.com/communities/115368820700870330756)
