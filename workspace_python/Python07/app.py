# -*- coding:utf-8 -*-

from flask import Flask, render_template
from bs4 import BeautifulSoup
import requests
import json
import flask_cors

app = Flask(__name__)
flask_cors.CORS(app)

@app.route('/')
def root():
    return render_template('index.html')


@app.route('/crawling')
def mcstCulture():
    resp = requests.get('https://www.mcst.go.kr/kor/s_culture/festival/festivalList.jsp?pMenuCD=&pCurrentPage=1&pSearchType=&pSearchWord=&pSeq=&pSido=&pOrder=&pPeriod=&fromDt=&toDt=')
    soup = BeautifulSoup(resp.text, 'html.parser')
    
    cultures = soup.find_all('ul', class_='mediaWrap color01')
    
    result_list = list()
    for culture in cultures:
        res = dict()
        res['img'] = culture.find('img').text
        res['title'] = culture.find('p').text
        res['detail_info'] = culture.fine('detail_info > li:nth-child(0)').text
        result_list.append(res)
        
    res_dict = {'cultures' : result_list}
    
    result_json = json.dumps(res_dict, ensure_ascii=False)
    print(result_json)
    
    return result_json


if __name__ == '__main__':
    app.run(host='localhost', port='8787')