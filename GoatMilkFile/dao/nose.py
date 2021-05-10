from typing import Dict, List
from flask import Blueprint, request, url_for
import os

from model import ImgFileNose
from exts import db

base_url = os.getenv('BASE_URL', '')
bp = Blueprint('nose', __name__)

def get_urls() -> List[Dict[str, str]]:
    imgs = ImgFileNose.query.all()
    return [img.to_json() for img in imgs]

def add_url(url: str, desc: str) -> ImgFileNose:
    img_nose = ImgFileNose(url=url, desc=desc)
    db.session.add(img_nose)
    db.session.commit()
    return img_nose

def delete_url(url: str) -> None:
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
    desc = request.form.get('desc')
    filename = str(hash(f)) + os.path.splitext(f.filename)[-1]
    f.save(f'static/{filename}')
    file_url= base_url + url_for("static", filename=filename)
    t = add_url(file_url, desc)
    return {
        'status': 'success',
        'data': t.to_json(),
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
