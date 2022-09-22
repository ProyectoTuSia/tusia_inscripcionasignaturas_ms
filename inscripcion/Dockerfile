FROM openjdk:18.0.2.1-jdk
FROM maven:3.8.6-openjdk-18

WORKDIR /app
COPY . /app/

EXPOSE 8071

CMD ["mvn", "spring-boot:run"]