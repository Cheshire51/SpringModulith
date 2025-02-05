#
## Start with a base image containing Java runtime
#FROM amazoncorretto:21
#
#EXPOSE 8080
#
## Add Maintainer Info
#LABEL maintainer = "Phan Duc Minh <23520950@gm.uit.edu.vn>"
#
## The application's jar file - defines the JAR_FILE variable set by dockerfile-maven-plugin
#ARG JAR_FILE=target/*.jar
#
## Add the application's jar to the container
#COPY ${JAR_FILE} app.jar
#
## Excute the application
#ENTRYPOINT exec java \
#   -Dspring.profiles.active=$SPRING_PROFILE \
#   -Duser.timezone=Vietname/Hanoi \
#   -jar app.jar

FROM amazoncorretto:23 as build
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM amazoncorretto:23
WORKDIR application
COPY --from=build application/dependencies/ ./
COPY --from=build application/spring-boot-loader/ ./
COPY --from=build application/snapshot-dependencies/ ./
COPY --from=build application/application/ ./
ENTRYPOINT ["java", "-Duser.timezone = Vietname/Hanoi", "-Dspring.profiles.active=${SPRING_PROFILE}", "org.springframework.boot.loader.launch.JarLauncher"]