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

Before launch need to start MySQL/MariaDB server and create **jbelly** database with UTF-8 encoding (utf8mb4_unicode_ci). See [application.properties](https://github.com/evgeniyosipov/jbelly/blob/master/src/main/resources/application.properties).

Blog url - http://localhost:8080/

Admin admin@example.com password: 1

User user@example.com password: 1

Big thanks to SoftUni and Svetlin Nakov for great information.

<img src="sample-images/jbelly-index-compact.PNG"/>
<img src="sample-images/jbelly-post.PNG"/>
<img src="sample-images/jbelly-create.PNG"/>
<img src="sample-images/jbelly-edit.PNG"/>
<img src="sample-images/jbelly-profile.PNG"/>
<img src="sample-images/jbelly-index-admin.PNG"/>
<img src="sample-images/jbelly-admin-categories.PNG"/>
<img src="sample-images/jbelly-admin-users.PNG"/>
