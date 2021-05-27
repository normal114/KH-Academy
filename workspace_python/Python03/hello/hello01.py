# -*- coding:utf-8 -*-

from flask import Flask

app = Flask(__name__)


@app.route('/')
def hello():
    return "hello, world"


if __name__ == '__main__':
    app.run() # 포트 하나 실행시켰다. 프로젝트가 올라갔다.
    # app.run(8000)