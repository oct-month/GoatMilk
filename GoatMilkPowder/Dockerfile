FROM maven:3-openjdk-8 as builder

WORKDIR /GoatMilkPowder
COPY ./ /GoatMilkPowder

RUN mkdir ~/.m2
RUN mv settings.xml ~/.m2/

RUN mvn package -Dmaven.test.skip=true


FROM openjdk:8-jre-alpine
LABEL maintainer="sun oct-month@qq.com"

ARG workdir=/GoatMilkPowder

WORKDIR ${workdir}
COPY --from=builder /GoatMilkPowder/target/GoatMilkPowder-0.0.1-SNAPSHOT.jar ${workdir}/GoatMilkPowder.jar

ENTRYPOINT [ "java", "-jar", "GoatMilkPowder.jar" ]
