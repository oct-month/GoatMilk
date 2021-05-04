from flask import Blueprint, request, url_for
import os

from model import ImgFileNose
from exts import db

base_url = os.getenv('BASE_URL', '')
bp = Blueprint('nose', __name__)

def get_urls():
    urls = ImgFileNose.query.all()
    return [str(url) for url in urls]

def add_url(url: str):
    img_nose = ImgFileNose(url=url)
    db.session.add(img_nose)
    db.session.commit()

def delete_url(url: str):
    img_nose = ImgFileNose.query.filter(ImgFileNose.url == url).first()
    db.session.delete(img_nose)
    db.session.commit()


@bp.route('/', methods=['GET'])
def list_u():
    urls = get_urls()
    return {
        'status': 'success',
        'data_list': urls
    }

# @bp.route('/', methods=['POST'])
# def add_u():
#     url = request.json['url']
#     add_url(url)
#     return {
#         'status': 'success'
#     }

@bp.route('/', methods=['DELETE'])
def delete_u():
    url = request.json['url']
    delete_url(url)
    file_path = 'static/' + url.split('/')[-1]
    os.remove(file_path)
    return {
        'status': 'success'
    }


@bp.route("/", methods=['POST'])
def upload_file():
    """文件上传"""
    f = request.files.get('file')
    filename = str(hash(f)) + os.path.splitext(f.filename)[-1]
    f.save(f'static/{filename}')
    file_url= base_url + url_for("static", filename=filename)
    add_url(file_url)
    return {
        'status': 'success',
        'data': file_url,
        'data_list': None
    }

@bp.errorhandler(Exception)
def handle_exception(error):
    print(error)
    return {
        'status': 'fail',
        'data': None,
        'data_list': None
    }

@bp.errorhandler(404)
def page_not_found(error):
    return {
        'status': 'fail'
    }
