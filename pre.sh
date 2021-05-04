export WORKDIR=$(pwd)

cp $WORKDIR/GoatMilkPowder/src/main/resources/*.sql $WORKDIR/mysql/sql/

cd $WORKDIR/GoatMilkPowder
sh pre.sh

cd $WORKDIR/GoatMilkWeb
sh pre.sh

cd $WORKDIR
