FROM java:8
LABEL maintainer=“mohamedzayyan23@gmail.com”
VOLUME /tmp
EXPOSE 8080
ADD target/spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar"]