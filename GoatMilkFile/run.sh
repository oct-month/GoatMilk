docker run \
	--name GoatMilkFile \
	--network goat-milk \
	-d \
	-v /root/GoatMilk/GoatMilkFile/static:/GoatMilkFile/static \
	--env FLASK_APP=app.py \
	--env FLASK_ENV=product \
	sun/goat-milk-file
