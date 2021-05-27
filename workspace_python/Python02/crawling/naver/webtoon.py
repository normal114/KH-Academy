# -*- coding:utf-8 -*-

from bs4 import BeautifulSoup
import requests
import json
from pickle import FALSE


resp = requests.get('http://comic.naver.com/webtoon/weekdayList.nhn?week=')
# print(resp.text)
soup = BeautifulSoup(resp.text, 'html.parser')

webtoons = soup.find('ul', {'class': 'img_list'})
# print(webtoons)

dl = webtoons.select('dl')
# print(dl[0])

lst = list()

for chd in dl:
    title = chd.find('a')['title']
    star = chd.find('strong').text
    # print('{} [{}]'.format(title, star))
    
    tmp = {}
    tmp['title'] = title
    tmp['star'] = star
    lst.append(tmp)
    
'''    
print(lst)
for i in lst:
    print(i)
'''
    
res = {}
res['webtoons'] = lst
# print(res) # key : 제이슨 형태로 출력된다

res_json = json.dumps(res, ensure_ascii=False) # json형태로 바뀌었다
print(res_json)

with open('webtoons.json', 'w', encoding='utf-8') as f:
    f.write(res_json) # webtoons.json 파일이 만들어진다.



