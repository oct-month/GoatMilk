FROM node:lts-alpine as builer

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories
RUN apk update
RUN apk add --no-cache build-base musl-dev python3

RUN yarn config set registry https://repo.nju.edu.cn/repository/npm/
ENV NODE_ENV=product

WORKDIR /GoatmilkWeb
COPY ./ /GoatmilkWeb

RUN yarn && yarn build
RUN yarn cache clean


FROM ablocker/nginx:1.17.8
LABEL maintainer="sun oct-month@qq.com"

COPY ./nginx/conf/nginx.conf /opt/nginx/conf/nginx.conf
COPY --from=builer /GoatmilkWeb/dist/ /opt/nginx/html/
