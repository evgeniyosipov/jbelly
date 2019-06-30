# Jbelly

<img src="sample-images/jbelly-index.PNG"/>

Lightweight Java Blog Engine based on Spring Boot.

Built with:
* Spring Boot 2.1 (web, security, jpa, devtools)
* Thymeleaf (engine + springsecurity5)
* Java 11
* MySQL/MariaDB
* Maven
* JQuery
* Bootstrap 3
* Summernote

Can be build in any IDE that supporting Maven projects or run manually:

**Full:**

$ mvn clean

$ mvn package

$ java -jar -Xmx64m -Xss256k ./target/jbelly-0.0.1-SNAPSHOT.jar

**Short:**

$ mvn spring-boot:run

Before launch need to start MySQL/MariaDB server and create **jbelly** database with UTF-8 encoding (utf8mb4_unicode_ci). 

Please, see [application.properties](src/main/resources/application.properties) for additional settings.

Blog url - http://localhost:8080/

Admin admin@example.com password: 1

User user@example.com password: 1

Please, see <a href="SAMPLE-IMAGES.md">SAMPLE-IMAGES.md</a> for more screenshots.

Big thanks to SoftUni and Svetlin Nakov for great information.

Also special thanks to JetBrains for providing Intellij IDEA Ultimate license for this project.

<a href="https://www.jetbrains.com/?from=Jbelly"><img src="sample-images/jetbrains.png" width="150"/></a>
