FROM maven:3.9-eclipse-temurin-23 as base
WORKDIR /app
COPY pom.xml ./
RUN mvn install
CMD ["/bin/bash"]
