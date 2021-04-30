docker run \
    --name redis \
    --network goat-milk \
    --rm \
    -d \
    -v /home/sun/service/redis/conf:/usr/local/etc/redis \
    redis:alpine
