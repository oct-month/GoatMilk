mvn clean
mvn package -Dmaven.test.skip=true
docker build -t sun/goat-milk-powder:latest .
