docker run \
	--name GoatMilkFile \
	--network goat-milk \
	-d \
	--env FLASK_APP=app.py \
	--env FLASK_ENV=product \
	sun/goat-milk-file
