FROM postgres:13-alpine
LABEL maintainer="sun oct-month@qq.com"

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=10101010
ENV POSTGRES_DB=GoatMilk

COPY ./sql /tmp/sql
RUN mv /tmp/sql/* /docker-entrypoint-initdb.d/
RUN rm -rf /tmp/sql
