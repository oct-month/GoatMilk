docker-compose down
rm -rf mysql/data/
rm GoatMilkFile/static/*
sh pre.sh
docker-compose build
docker-compose up -d