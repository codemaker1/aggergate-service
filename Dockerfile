# we will use openjdk 8 with alpine as it is a very small linux distro
FROM openjdk:8-jre-alpine3.9
 
# copy the packaged jar file into our docker image
COPY target/aggregator-service-0.0.1-SNAPSHOT.jar /aggregator-service.jar
 
# set the startup command to execute the jar
CMD ["java", "-jar", "/aggregator-service.jar"]