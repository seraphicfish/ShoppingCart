# ![pageres](media/dxpLogo.png)

# Shopping API

## Overview

This Shopping API is used to calculate the total price based on the tours selected by customer.
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

The following libraries and tools should be installed before setup the project:

- Java SE Development Kit: [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- SQL SERVER
- Create a database "ShoppingCart" and create a table "tour" and insert the following data in the database:
id      name    price
OH      opera house tour    300
SK      Sydney Sky Tower    30
BC      Sydney Bridge Climb 110


_Optional_
- Build tool: [Gradle 4.10.1](https://gradle.org/releases/)

### Installing

The content below provide a step-by-step instructions to get the development environment running.

- Download and install an IDE for spingboot project. You can choose any Java IDE for code development, but **IntelliJ** is the recommended IDE.
- Clone the repository and import this project as a **Gradle** project into the IDE.
- Configure the project with proper JDK version.
- Configure `application.properties` file with correct configuration for 
JDBC connection setting
```
# ===============================
# = DATA SOURCE
# ===============================

# Connection url for the database "<<dbname>>"
# SQL Server
spring.datasource.url = jdbc:sqlserver://localhost:1433;databaseName=<<dbname>>

# Database driver name
# SQL Server
spring.datasource.driverClassName = com.microsoft.sqlserver.jdbc.SQLServerDriver


# Username and password
spring.datasource.username = <<username>>
spring.datasource.password = <<password>>
```

- Compile the project
```
gradlew compileJava
```
- Run the application
```
gradlew bootRun
```

## Testing

## Deployment
 - Shopping API can be deployed as a war file to any JDK8 compatible application server, e.g. Tomcat, JBoss, WebSphere and WebLogic.
 Please read the deployment procedure of a specific application server if you want to deploy to.
 - Shopping API can run as a packaged application. This API builds an executable jar, you can run the application using `java -jar`,
 as shown in the following example.
```
java -jar shoppingcart.jar
```

## Build with

- [Springboot](https://spring.io/projects/spring-boot)
- [Gradle](https://gradle.org/)


### Gradle tasks
Task | Description
--- | ---
`gradlew clean` | Clean the project.
`gradlew build` | Builds the project.
`gradlew javadoc` | Generate java docs for the project.
`gradlew wrapper` | Creates/updates the gradle wrapper. To be run only when the gradle wrapper version is changed in `build.gradle`, and the wrapper needs to be updated.

### How to test

You can use the postman to do the testing:
1 create a test with "POST" method and url as: http://ServerUrl:applicationPort/tours, 
eg: http://localhost:8080/tours

2 set the header "Content-Type" as "application/json"

3 in the request body set the content as below:

{"tours":["OH","OH","OH","OH","OH","SK","SK","SK","BC","BC","BC","BC","BC"]
}

4 the response body, you can get the correct price.