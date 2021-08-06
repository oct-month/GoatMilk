export WORKDIR=$(pwd)

mkdir $WORKDIR/postgresql/sql
mkdir $WORKDIR/GoatMilkFile/static
#rm -rf $WORKDIR/postgresql/data
cp $WORKDIR/GoatMilkPowder/src/main/resources/schema.sql $WORKDIR/postgresql/sql/b.sql
cp $WORKDIR/GoatMilkPowder/src/main/resources/data.sql $WORKDIR/postgresql/sql/c.sql

cd $WORKDIR/GoatMilkPowder
sh pre.sh

cd $WORKDIR/GoatMilkWeb
sh pre.sh

cd $WORKDIR
