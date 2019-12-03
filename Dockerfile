FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR /home/users/pradnyan

# Add .jar files
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

# Add suite files
ADD src/test/resources/testng-BookFlight.xml testng-BookFlight.xml
ADD src/test/resources/testng-SearchText.xml testng-SearchText.xml

#Add healthcheck script
ADD healthcheck.sh healthcheck.sh

# Entry Point - expecting Browser, Hub_Host, Module with healthcheck
ENTRYPOINT sh healthcheck.sh
