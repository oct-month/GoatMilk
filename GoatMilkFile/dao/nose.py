from flask import Blueprint
from flask.json import jsonify

from model import ImgFileNose
from exts import db


bp = Blueprint('nose', __name__)

def get_urls():
    urls = ImgFileNose.query.all()
    return urls

def add_url(url: str):
    img_nose = ImgFileNose(url=url)
    db.session.add(img_nose)
    db.session.commit()

def delete_url(url: str):
    img_nose = ImgFileNose.query.filter(ImgFileNose.url == url).first()
    db.session.delete(img_nose)
    db.session.commit()


@bp.route('/', methods=['GET'])
def list_urls():
    urls = get_urls()
    return jsonify(urls)

