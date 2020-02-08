FROM ubuntu:18.04

WORKDIR /root/jbelly

RUN apt-get update -q && apt-get upgrade -q -y && \
    apt-get install -q -y openjdk-11-jdk maven git && \
    apt-get clean && \
    git clone https://github.com/evgeniyosipov/jbelly.git .

EXPOSE 8080
