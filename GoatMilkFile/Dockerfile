FROM python:3.8-alpine
LABEL maintainer="sun oct-month@qq.com"

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories
RUN apk update
RUN apk add --no-cache build-base musl-dev postgresql-libs postgresql-dev

ARG workdir=/GoatMilkFile

WORKDIR ${workdir}
COPY ./ ${workdir}/

RUN pip install -i https://mirrors.bfsu.edu.cn/pypi/web/simple -r requirements.txt --no-cache-dir

ENTRYPOINT [ "flask", "run", "--host=0.0.0.0" ]
