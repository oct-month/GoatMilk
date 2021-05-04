FROM mysql:8
LABEL maintainer="sun oct-month@qq.com"

COPY ./sql /tmp/sql
RUN mv /tmp/sql/* /docker-entrypoint-initdb.d/ && rm -rf /tmp/sql
