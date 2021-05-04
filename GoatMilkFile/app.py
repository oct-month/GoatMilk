from flask import Flask, request
from flask.helpers import url_for
import os

import config
from exts import db
from dao import nose, tongue

app = Flask(__name__)
# app.secret_key = b'{k(\x1dDgr\xcb\x02\x04\x07d\x1a\x0c\xd2\x0b'
app.config.from_object(config)
db.init_app(app)
with app.app_context():
    db.create_all()
app.register_blueprint(nose.bp, url_prefix='/nose')
app.register_blueprint(tongue.bp, url_prefix='/tongue')

base_url = os.getenv('BASE_URL', '')


@app.route("/upload", methods=['POST'])
def upload_file():
    """文件上传"""
    f = request.files.get('file')
    filename = str(hash(f)) + os.path.splitext(f.filename)[-1]
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
