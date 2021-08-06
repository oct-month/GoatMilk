docker run \
    --name goat-milk-powder \
    --network goat-milk \
    -d \
    --env POSTGRESQL=goat-postgresql \
    --env REDIS_HOST=goat-redis
    sun/goat-milk-powder
