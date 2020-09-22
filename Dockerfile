FROM openjdk:8-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/ms-fiap-spring-boot-ali-moussa-1.0.0.jar
WORKDIR /app
ENTRYPOINT java -jar ms-fiap-spring-boot-ali-moussa-1.0.0.jar
