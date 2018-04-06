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