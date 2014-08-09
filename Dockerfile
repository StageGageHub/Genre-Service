reated to run stagegage java services
FROM ubuntu
MAINTAINER scott_hendrickson

# We'll need maven to run spring boot
RUN apt-get update
RUN apt-get install maven

# expose spring-boot default port
EXPOSE 8080

# the service home folder
RUN mkdir /usr/local/service
# pull in the service
ADD https://github.com/StageGageHub/Genre-Service /usr/local/service


#Spin up spring boot on startup
WORKDIR /usr/local/service/
CMD "mvn spring-boot:run"

