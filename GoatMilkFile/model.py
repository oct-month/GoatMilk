from exts import db

class ImgFileNose(db.Model):
    __tablename__ = '电子鼻图片'
    url = db.Column(db.String(100), primary_key=True)

    def __str__(self) -> str:
        return self.url
    

class ImgFileTongue(db.Model):
    __tablename__ = '电子舌图片'
    url = db.Column(db.String(100), primary_key=True)

    def __str__(self) -> str:
        return self.url
