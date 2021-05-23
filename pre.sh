export WORKDIR=$(pwd)

mkdir $WORKDIR/mysql/sql
mkdir $WORKDIR/GoatMilkFile/static
#rm -rf $WORKDIR/mysql/data
cp $WORKDIR/GoatMilkPowder/src/main/resources/schema.sql $WORKDIR/mysql/sql/b.sql
cp $WORKDIR/GoatMilkPowder/src/main/resources/data.sql $WORKDIR/mysql/sql/c.sql

cd $WORKDIR/GoatMilkPowder
sh pre.sh

cd $WORKDIR/GoatMilkWeb
sh pre.sh

cd $WORKDIR
