FROM frolvlad/alpine-oraclejdk8:slim

VOLUME /tmp

ADD api-weather-service-0.0.1-SNAPSHOT.jar api-weather-service.jar

RUN sh -c 'touch /api-weather-service.jar'

ENV JAVA_OPTS="-Xmx512m -Xms256m"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /api-weather-service.jar" ]

