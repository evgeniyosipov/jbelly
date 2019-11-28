FROM mariadb/server:10.4

WORKDIR ~/jbelly

RUN apt update -q && apt upgrade -q -y
RUN apt install -q -y openjdk-11-jdk
RUN apt install -q -y maven
RUN apt install -q -y git
RUN apt clean
RUN mysql -e "CREATE DATABASE jbelly CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;" && \
    mysql -e "GRANT ALL PRIVILEGES ON jbelly.* TO jbelly@'%' IDENTIFIED BY 'jbelly';FLUSH PRIVILEGES;"
RUN git clone https://github.com/evgeniyosipov/jbelly.git .

CMD mvn spring-boot:run

EXPOSE 8080 3306
