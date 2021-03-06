docker run \
    --name goat-mysql \
    --network goat-milk \
    -p 3306:3306 \
    -v /root/GoatMilk/mysql/data:/var/lib/mysql \
    -e MYSQL_ROOT_PASSWORD=10101010 \
    -e MYSQL_DATABASE=GoatMilk \
    -d \
    mysql:8 \
    --character-set-server=utf8mb4 \
    --collation-server=utf8mb4_unicode_ci \
