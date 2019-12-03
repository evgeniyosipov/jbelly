FROM ubuntu:18.04

WORKDIR ~/jbelly_build

RUN apt-get update -q && apt-get upgrade -q -y
RUN apt-get install -q -y openjdk-11-jdk
RUN apt-get install -q -y maven
RUN apt-get install -q -y git
RUN apt-get clean
RUN git clone https://github.com/evgeniyosipov/jbelly.git .

EXPOSE 8080
