FROM ubuntu:24.04

WORKDIR /root/jbelly

RUN apt-get update && apt-get install -y \
    openjdk-21-jdk-headless \
    git \
    && rm -rf /var/lib/apt/lists/* \
    && git clone https://github.com/evgeniyosipov/jbelly.git . \
    && chmod +x ./mvnw

EXPOSE 8080
