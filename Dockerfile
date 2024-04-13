FROM openjdk:17-oracle
COPY target/*jar greenway.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","greenway.jar"]