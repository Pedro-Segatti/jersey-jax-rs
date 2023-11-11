FROM maven:3.8.2-openjdk-11 as build

WORKDIR /app

COPY pom.xml .
COPY src src

RUN mvn install -DskipTests

RUN mkdir -p target/lib && (cd target/lib; jar -xf ../*.jar)

FROM openjdk:11-oracle

WORKDIR /app
VOLUME /tmp
COPY --from=build /app/target/lib /app/lib
COPY --from=build /app/target/classes .

EXPOSE 8080
ENTRYPOINT ["java","-cp","/app:/app/lib/*","org.example.Main"]