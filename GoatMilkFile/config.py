import os

mysql_host = os.getenv('MYSQL_HOST', 'goat-mysql')

SQLALCHEMY_DATABASE_URI = f"mysql+pymysql://root:10101010@{mysql_host}:3306/GoatMilk?charset=utf8"
SQLALCHEMY_TRACK_MODIFICATIONS = False
SQLALCHEMY_ECHO = True
