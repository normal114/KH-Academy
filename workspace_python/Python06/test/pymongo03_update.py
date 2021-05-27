# -*- coding:utf-8 -*-

from pymongo import MongoClient


client = MongoClient('mongodb://localhost:27017/')
db = client['test']
score = db['score']

# 김태리의 final의 math를 100점으로 변경하자

res01 = score.update_one(
    {'name': '김태리'},
    {'$set': {'final.math': 100}}
)

print(res01.matched_count)
print(res01.modified_count)
# 안 바뀐 사실을 알 수 있다. 왜냐하면 위에 먼저 있는 도큐먼트만 바뀌었기 때문이다(update_one)

print('-----')

res02 = score.update_many(
    {'midterm.kor': {'$gt': 60}},
    {'$set':{'midterm.kor': 100}}
)

print(res02)
print(res02.matched_count)
print(res02.modified_count)
