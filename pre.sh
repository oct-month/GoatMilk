export WORKDIR=$(pwd)

#rm -rf $WORKDIR/postgresql/data
cp $WORKDIR/GoatMilkPowder/src/main/resources/schema.sql $WORKDIR/postgresql/sql/b.sql
cp $WORKDIR/GoatMilkPowder/src/main/resources/data.sql $WORKDIR/postgresql/sql/c.sql

cd $WORKDIR/nginx-1.17.8
sh pre.sh

cd $WORKDIR
