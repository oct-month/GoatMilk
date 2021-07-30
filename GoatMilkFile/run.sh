docker run \
	--name goat-img-file \
	--network goat-milk \
	-d \
	-v /root/GoatMilk/GoatMilkFile/static:/GoatMilkFile/static \
	--env FLASK_APP=app.py \
	--env FLASK_ENV=product \
	--env POSTGRESQL_HOST=goat-postgresql \
	sun/goat-milk-file
