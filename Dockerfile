FROM mariadb/server:10.4

ENV MYSQL_ROOT_PASSWORD mypass
ENV MYSQL_DATABASE jbelly
ENV MYSQL_USER jbelly
ENV MYSQL_PASSWORD jbelly

CMD ["mysqld", "--character-set-server=utf8mb4", "--collation-server=utf8mb4_unicode_ci", "--skip-character-set-client-handshake"]

WORKDIR ~/jbelly

RUN apt-get update -q && apt-get upgrade -q -y
RUN apt-get install -q -y openjdk-11-jdk
RUN apt-get install -q -y maven
RUN apt-get install -q -y git
RUN apt-get clean
RUN git clone https://github.com/evgeniyosipov/jbelly.git .

#CMD mvn spring-boot:run

VOLUME /var/lib/mysql

EXPOSE 8080 3306
