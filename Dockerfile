FROM ubuntu:22.04

WORKDIR /root/jbelly

RUN apt-get update && apt-get install -y \
    openjdk-17-jdk-headless \
    git \
    && rm -rf /var/lib/apt/lists/* \
    && git clone https://github.com/evgeniyosipov/jbelly.git . \
    && chmod +x ./mvnw

EXPOSE 8080
