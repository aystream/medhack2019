FROM openjdk:12-alpine

ADD /build/libs/topm-0.0.1-SNAPSHOT.jar /usr/local/topm/

CMD ["java","-jar","/usr/local/topm/topm-0.0.1-SNAPSHOT.jar"]
