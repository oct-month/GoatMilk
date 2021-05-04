FROM python:3.8-alpine
LABEL maintainer="sun oct-month@qq.com"

ARG workdir=/GoatMilkFile

WORKDIR ${workdir}
COPY ./ ${workdir}/
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories
RUN apk update
RUN apk add build-base
RUN pip install -i https://mirrors.bfsu.edu.cn/pypi/web/simple -r requirements.txt
RUN rm -rf /root/.cache

ENTRYPOINT [ "flask", "run", "--host=0.0.0.0" ]
