docker run \
    --name nginx \
    --network goat-milk \
    --rm \
    -d \
    -p 80:80 \
    -v /home/sun/service/nginx/conf/nginx.conf:/etc/nginx/nginx.conf:ro \
    -v /home/sun/service/nginx/html:/usr/share/nginx/html:ro \
    nginx:stable-alpine
