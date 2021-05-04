export WORKDIR=$(pwd)

mkdir $WORKDIR/mysql/sql
mkdir $WORKDIR/GoatMilkFile/static
cp $WORKDIR/GoatMilkPowder/src/main/resources/*.sql $WORKDIR/mysql/sql/

cd $WORKDIR/GoatMilkPowder
sh pre.sh

cd $WORKDIR/GoatMilkWeb
sh pre.sh

cd $WORKDIR
