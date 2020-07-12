FROM openjdk:8
VOLUME /tmp
ADD servicio-arduino-voltaje-0.0.1-SNAPSHOT.jar servicio-arduino-voltaje.jar
ENTRYPOINT ["java","-jar","/servicio-arduino-voltaje.jar"]