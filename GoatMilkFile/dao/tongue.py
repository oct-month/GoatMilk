from flask import Blueprint, jsonify

from model import ImgFileTongue

bp = Blueprint('tongue', __name__)

def get_urls():
    urls = ImgFileTongue.query.all()
    return urls

@bp.route('/')
def list_urls():
    urls = get_urls()
    return jsonify(urls)
