from flask import Flask, request
from flask.helpers import url_for
import os

app = Flask(__name__)
# app.secret_key = b'{k(\x1dDgr\xcb\x02\x04\x07d\x1a\x0c\xd2\x0b'
base_url = os.getenv('BASE_URL', '')

@app.route("/upload", methods=['POST'])
def upload_file():
    """文件上传"""
    f = request.files.get('file')
    filename = str(hash(f)) + '.' + os.path.splitext(f.filename)[-1]
    f.save(f'static/{filename}')
    file_url= base_url + url_for("static", filename=filename)
    return {
        'status': 'success',
        'data': file_url,
        'data_list': None
    }

@app.errorhandler(Exception)
def handle_exception(error):
    print(error)
    return {
        'status': 'fail',
        'data': None,
        'data_list': None
    }

@app.errorhandler(404)
def page_not_found(error):
    return {
        'status': 'fail'
    }
