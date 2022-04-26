FROM node:lts-alpine as builer

# RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories
# RUN apk update

RUN yarn config set registry https://repo.nju.edu.cn/repository/npm/
ENV NODE_ENV=product

WORKDIR /GoatmilkWeb
COPY ./ /GoatmilkWeb

RUN yarn && yarn build
RUN yarn cache clean


FROM nginx:stable-alpine
LABEL maintainer="sun oct-month@qq.com"

COPY --from=builer /GoatmilkWeb/dist/ /usr/share/nginx/html/
