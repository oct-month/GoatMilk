docker run \
    --name GoatMilkPowder \
    --network goat-milk \
    --rm \
    -d \
    --link mysql:mysql \
    --link redis:redis \
    sun/goat-milk-powder
