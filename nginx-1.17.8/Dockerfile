FROM ubuntu:20.04
LABEL maintainer="sun oct-month@qq.com"

WORKDIR /nginx-build
COPY ./ /nginx-build/

RUN mv ./sources.list /etc/apt/
RUN apt-get update
RUN apt-get install -y tzdata
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone
RUN apt-get remove -y tzdata
RUN apt-get build-dep -y nginx
RUN ./configure --prefix=/opt/nginx --with-http_ssl_module --add-module=./modules/headers-more-nginx-module
RUN make -j$nproc
RUN make install
RUN ln -s /dev/stdout /opt/nginx/logs/access.log
RUN ln -s /dev/stderr /opt/nginx/logs/error.log
RUN apt-get clean

RUN rm -r /nginx-build

ENTRYPOINT [ "/opt/nginx/sbin/nginx", "-c", "/opt/nginx/conf/nginx.conf", "-g", "daemon off;"]
