FROM openjdk:11

ADD target/courses-manager-1.0-SNAPSHOT.jar spring.jar

ENTRYPOINT ["java", "-jar", "spring.jar"]