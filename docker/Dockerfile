FROM 3.9.4-eclipse-temurin-23 as base
WORKDIR /app
COPY pom.xml ./
RUN mvn install
CMD ["/bin/bash"]
