docker run \
    --name goat-milk-powder \
    --network goat-milk \
    -d \
    --env MYSQL_HOST=goat-mysql \
    --env REDIS_HOST=goat-redis
    sun/goat-milk-powder
