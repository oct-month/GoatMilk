FROM openjdk:8-jre-alpine
LABEL maintainer="sun oct-month@qq.com"

ARG workdir=/GoatMilkPowder

WORKDIR ${workdir}
COPY ./target/GoatMilkPowder-0.0.1-SNAPSHOT.jar ${workdir}/GoatMilkPowder.jar

ENTRYPOINT [ "java", "-jar", "GoatMilkPowder.jar" ]
