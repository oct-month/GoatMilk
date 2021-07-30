import os

postgresql_host = os.getenv('POSTGRESQL_HOST', 'goat-postgresql')

SQLALCHEMY_DATABASE_URI = f"postgresql+psycopg2://postgres:10101010@{postgresql_host}:5432/GoatMilk?charset=utf8"
SQLALCHEMY_TRACK_MODIFICATIONS = False
SQLALCHEMY_ECHO = True
