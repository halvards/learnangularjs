learnangularjs [![Build Status](https://travis-ci.org/halvards/learnangularjs.png)](https://travis-ci.org/halvards/learnangularjs)
==============

An example [AngularJS](http://angularjs.org/) application with a Java back end and a NodeJS stub back end.

This is primarily aimed at Java developers taking the plunge into AngularJS and more JavaScript-heavy applications,
though it should prove useful to developers from any background who want to get started with AngularJS.

The situation may be as follows: You're working in a company where Java is the dominant programming language, and you
already have a heavy investment in server-side Java. That's not going away, and you don't want to discard everything
your team has learned about building Java-based web applications.

This example will show you how to keep using more traditional frameworks like Spring MVC to provide a JSON API and
Spring Security for authentication and authorisation on the server side while taking advantage of the opportunities
that exist with single-page JavaScript applications. It should give you answers to questions such as how to:

* create a clean separation between the AngularJS client application and the Java API back end
* write and execute JavaScript unit tests functional browser-based tests for single page web applications
* set up a build for a project with a single page JavaScript front end and a Java API back end
* manage JavaScript library dependencies
* handle JSON requests and responses effectively in Spring MVC
* create a stub implementation of the Java API back end using NodeJS to further decouple front and back end development
* handle server-side authentication in the AngularJS client application
* protect against [JSON vulnerabilities and cross site request forgery (XSRF)](http://docs.angularjs.org/api/ng.$http)
* take advantage of CSS pre-processors like LESS and HTML templating engines like Jade
* ensure that search engines can crawl and index my site
* make an AngularJS application work in Internet Explorer 8+ and modern browsers. (I will attempt to make it work in
IE7, but I make no guarantees!)

# Requirements

This project requires that [Gradle](http://gradle.org/), [PhantomJS](http://phantomjs.org/), and
[NodeJS](http://nodejs.org/) are installed. Mac users can install all of them using
[Homebrew](http://mxcl.github.com/homebrew/):

    brew update ; brew install gradle phantomjs nodejs

Gradle is the build system used by the project, PhantomJS is used to run JavaScript unit tests and end-to-end scenarios
in headless mode from the build, while NodeJS is used to run a simple Web server used by the client sub-project to stub
the server-side.

# IntelliJ IDEA Setup

I strongly recommend [IntelliJ IDEA Ultimate](http://www.jetbrains.com/idea/) version 12.0 or later. Its JavaScript
support is far superior to that of [Eclipse](http://www.eclipse.org/).

To create IntelliJ IDEA project files, run:

    gradle cleanIdea idea

Ensure you have the following IDEA plugins:

* AngularJS
* Gradle (bundled)
* Jade
* NodeJS
* All the bundled JavaScript plugins

If needed, set the Gradle home directory IDEA setting to /usr/local/Cellar/gradle/<version>/libexec

# Gradle Tasks

To install all dependencies, run:

    gradle assemble

To run a full build with the Java back end, run:

    gradle check

To run a faster build of the AngularJS client application with the NodeJS stub back end, run:

    gradle checkStub

To see all available tasks, run:

    gradle tasks

To also see all task dependencies, run:

    gradle tasks --all

# Suggested Reading (and Watching)

* [JavaScript: The Good Parts](http://shop.oreilly.com/product/9780596517748.do) by Douglas Crockford
* [AngularJS presentation at GTAC 2011](http://www.youtube.com/watch?v=gQclnI_8Vmg) (video)
* [Tutorial](http://docs.angularjs.org/tutorial)
* [Developer Guide](http://docs.angularjs.org/guide/), and in particular
  * [Dependency Injection](http://docs.angularjs.org/guide/di)
  * [Unit Testing](http://docs.angularjs.org/guide/dev_guide.unit-testing)
  * [End-to-end Testing](http://docs.angularjs.org/guide/dev_guide.e2e-testing)
* [Internet Explorer Compatibility](http://docs.angularjs.org/guide/ie)
* [Data Binding](http://stackoverflow.com/questions/9682092/databinding-in-angularjs/9693933#9693933)
* [Making AJAX Applications Crawlable](https://developers.google.com/webmasters/ajax-crawling/)
* [Egghead.io videos](http://egghead.io/)
* [Tips and Tricks](http://deansofer.com/posts/view/14/AngularJs-Tips-and-Tricks-UPDATED)
* [YouTube channel](https://www.youtube.com/user/angularjs)
* [Google+ Community](https://plus.google.com/communities/115368820700870330756)

# Tried or considered but not used

Some technologies and approaches were tried but not used, either because they weren't deemed ready for serious
development usage or because they were not appropriate for this type of application:

* [Bower](http://bower.io) is a noble attempt at front end dependency management but does not have sufficient take-up
  among library developers. For now I still check in these libraries with the project.
* [Sass](http://sass-lang.com/) is a great CSS pre-processor with more features than [LESS](http://lesscss.org/), and
  its SCSS syntax is a CSS superset (just like LESS). It also opens the door to CSS frameworks like
  [Compass](http://compass-style.org/) and lightweight mixin libraries like [Bourbon](http://bourbon.io/). However, its
  JavaScript (NodeJS) implementations are still rather basic, so [Ruby](http://www.ruby-lang.org/en/) is required to
  make good use of it. Its benefits over LESS didn't warrant this additional complication in this example application.
  If you're already using Ruby then I'd recommend looking into Sass in place of LESS.
* [Jersey](https://jersey.java.net/) is an implementation of
  [JAX-RS, a.k.a. Java API for RESTful Services](https://jax-rs-spec.java.net/) and provides an alternative to using
  Spring MVC for the Java API back end layer. I chose Spring MVC in this example for two reasons:
  * Spring MVC is commonly used for 'traditional' web applications, and so many teams are already familiar with it.
    Since it can also support JSON-based APIs, keeping it is sensible.
  * When I briefly explored Jersey's support for creating JSON-based APIs, I ran into some problems turning instances
    of collection classes from [Guava](https://code.google.com/p/guava-libraries/) into JSON documents, but with
    Spring MVC and [Jackson 2](http://wiki.fasterxml.com/JacksonHome) this worked 'out of the box'.

  In the future I'm likely to explore replacing Spring MVC with [Spark](http://www.sparkjava.com/).
* [Guice](https://code.google.com/p/google-guice/) is a great dependency injection framework. This application uses
  Spring's more than capable dependency injection engine instead only because it also uses Spring MVC in the web layer,
  and so the Spring dependency injection engine comes as a transitive dependency.
* [Jetty](http://www.eclipse.org/jetty/) is my favourite Java servlet container, but given that Tomcat is more common
  in production environments I wanted to explore any challenges of developing and deploying this style of application
  on Tomcat.
