FROM openjdk:21-jdk
VOLUME /tmp
COPY target/irenew-0.0.1-SNAPSHOT.jar irenew.jar
ENTRYPOINT ["java", "-jar", "/irenew.jar"]