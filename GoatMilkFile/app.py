from flask import Flask

import config
from exts import db
from dao import nose, tongue

app = Flask(__name__)
# app.secret_key = b'{k(\x1dDgr\xcb\x02\x04\x07d\x1a\x0c\xd2\x0b'
app.config.from_object(config)
db.init_app(app)
with app.app_context():
    db.create_all()
app.register_blueprint(nose.bp, url_prefix='/api/nose')
app.register_blueprint(tongue.bp, url_prefix='/api/tongue')


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
