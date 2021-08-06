docker run \
    --name goat-postgresql \
    --network goat-milk \
    -p 5432:5432 \
    -v `pwd`/data:/var/lib/postgresql/data \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=10101010 \
    -e POSTGRES_DB=GoatMilk \
    -d \
    postgres:13-alpine
