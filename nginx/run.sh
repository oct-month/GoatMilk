docker run \
    --name goat-nginx \
    --network goat-milk \
    -d \
    -p 80:80 \
    -v /root/GoatMilk/nginx/conf/nginx.conf:/etc/nginx/nginx.conf:ro \
    -v /root/GoatMilk/nginx/html:/usr/share/nginx/html:ro \
    nginx:stable-alpine
