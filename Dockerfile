FROM maven:3-sapmachine-21 AS builder

# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/

# package jar
RUN mvn clean package -Dmaven.test.skip=true

# Second stage: minimal runtime environment
FROM openjdk:21-slim

# copy jar from the first stage
COPY --from=builder target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]