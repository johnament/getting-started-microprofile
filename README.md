# Getting Started with Eclipse MicroProfile

This is a sample application showcasing MicroProfile features

# How to build

To compile, execute

```
mvn install
```

This will also build a JAR file. To run the JAR file, you need to run it with a MicroProfile implementation that can run JAR files.

To build a WAR file that can be deployed to a server, execute

```
mvn install war:war
```

# How to run

Because MicroProfile provides only an interface, it's necessary to run the built application with one of the runtimes or libraries that provide the implementation. Have a look at the [list of MicroProfile implementations](https://wiki.eclipse.org/MicroProfile/Implementation) and consult with their documentation.

## Required configuration

The book service requires the following configuration values to be known to the MicroProfile container:

- `ws.ament.microprofile.gettingstarted.AuthorService/mp-rest/url` - the base URL of author service

The following properties can be optionally defined:

- `max.books.per.page` - maximum number of books in the response if no book id is specified, default is 20


## Run a mock author service

Run a mock author REST service that listens on port 8081 (requires maven version at least 3.3.1):

```
mvn -Dport=8081 org.codehaus.gmaven:groovy-maven-plugin:execute@author-service
```

## An example how to run with Payara Micro

Payara Micro is one of the MicroProfile implementations. It can run standard WAR files. It doesn't require any special set up to get started - it's just a JAR file that you can execute with the `java` command.

First, build a WAR file as described earlier.

Then download Payara Micro v182 or later from [https://www.payara.fish/downloads](https://www.payara.fish/downloads) and save it into the directory `target` in the project as `payara-micro.jar`.

Switch to the `target` directory and execute the following command line:

```
java -D'ws.ament.microprofile.gettingstarted.AuthorService/mp-rest/url=http://localhost:8081' -jar payara-micro.jar microprofile-get-started.war
```

Then access the URL [http://localhost:8080/microprofile-get-started/api/books](http://localhost:8080/microprofile-get-started/api/books) to access the `BooksController` REST endpoint. You should see "HTTP Status 401 - Unauthorized" because the resource is secured with the JWT mechanism.

In order to authenticate and access the service, you also need to generate a JWT token and use it when with the REST call. Consult [Payara documentation about JWT](https://docs.payara.fish/documentation/microprofile/jwt.html) how to do that.
