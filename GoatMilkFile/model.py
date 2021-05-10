from typing import Dict
from exts import db

class ImgFileNose(db.Model):
    __tablename__ = '电子鼻图片'
    url = db.Column(db.String(100), primary_key=True)
    desc = db.Column(db.Text, default='')

    def to_json(self) -> Dict[str, str]:
        return {
            "url": self.url,
            "desc": self.desc
        }

    def __str__(self) -> str:
        return self.url
    

class ImgFileTongue(db.Model):
    __tablename__ = '电子舌图片'
    url = db.Column(db.String(100), primary_key=True)
    desc = db.Column(db.Text, default='')

    def to_json(self) -> Dict[str, str]:
        return {
            "url": self.url,
            "desc": self.desc
        }

    def __str__(self) -> str:
        return self.url
