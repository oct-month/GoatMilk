FROM mysql:8
LABEL maintainer="sun oct-month@qq.com"

COPY ./sql /tmp/sql
COPY ./conf /etc/mysql/conf.d
RUN mv /tmp/sql/* /docker-entrypoint-initdb.d/
RUN rm -rf /tmp/sql
