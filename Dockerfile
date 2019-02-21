### Multi Stage Build ###
##Estágio 1 - Compilar projeto java com maven
FROM maven:3.3-jdk-8 as builder

ARG USER_HOME_DIR="/root"

ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

RUN mkdir -p /usr/src/api
WORKDIR /usr/src/api

COPY . /usr/src/api
#COPY settings.xml /$USER_HOME_DIR/.m2
RUN mvn clean install -DskipTests=true

##Estágio 2 - Deploy api
FROM openjdk:8u151-jre-alpine
MAINTAINER Equipe Desenvolviment MILTEC

RUN mkdir -p /api
WORKDIR /api
ENTRYPOINT ["/bin/bash"]

COPY --from=builder /usr/src/api/target/*.jar /api/
EXPOSE 9000

#CMD ["java", "-jar", "-Dspring.profiles.active=show", "/api/target/dizimo-0.0.1-SNAPSHOT.jar"]
CMD ["java", "-jar", "target/dizimo-0.0.1-SNAPSHOT.jar"]