# base docker mage
FROM openjdk:11
VOLUME /tmp
ADD target/SpringBoot-CrudOperation-0.0.1-SNAPSHOT.jar CrudOperation-SpringBoot.jar
ENTRYPOINT ["java", "-jar", "CrudOperation-SpringBoot.jar"]