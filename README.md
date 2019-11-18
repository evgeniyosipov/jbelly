# Jbelly

<img src="sample-images/jbelly-index.PNG"/>

Lightweight Java Blog Engine based on Spring Boot.

[![Build Status](https://travis-ci.com/evgeniyosipov/jbelly.svg?branch=master)](https://travis-ci.com/evgeniyosipov/jbelly)
[![Build status](https://ci.appveyor.com/api/projects/status/828dv3mgy94efa9a?svg=true)](https://ci.appveyor.com/project/evgeniyosipov/jbelly)

Built with:
* Spring Boot 2.2 (web, security, jpa, devtools)
* Thymeleaf (engine + springsecurity5)
* Java 11
* MySQL/MariaDB
* Maven
* JQuery
* Bootstrap 3
* Summernote

<br />

Before launch need to start MySQL/MariaDB server and create **jbelly** database with UTF-8 encoding (utf8mb4_unicode_ci).

$ mysql -u root -p

$ mysql> CREATE DATABASE jbelly CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

$ mysql> GRANT ALL PRIVILEGES ON jbelly.* TO jbelly@localhost IDENTIFIED BY 'jbelly';

$ mysql> FLUSH PRIVILEGES;

$ mysql> QUIT;

Please, see [application.properties](src/main/resources/application.properties) for additional settings.

<br />

Can be build/run in any IDE that supporting Maven projects or manually:

**Full:**

$ mvn clean

$ mvn package

$ java -jar -Xmx64m -Xss256k ./target/jbelly-0.0.1-SNAPSHOT.jar

**Short:**

$ mvn spring-boot:run

<br />

Blog url - http://localhost:8080/

Admin admin@example.com password: 1

User user@example.com password: 1

<br />

Please, see <a href="SAMPLE-IMAGES.md">SAMPLE-IMAGES.md</a> for more screenshots.

<br />

Big thanks to SoftUni and Svetlin Nakov for great information.

Also special thanks to JetBrains for providing Intellij IDEA Ultimate license for this project.

<a href="https://www.jetbrains.com/?from=Jbelly"><img src="sample-images/jetbrains.png" width="150"/></a>
