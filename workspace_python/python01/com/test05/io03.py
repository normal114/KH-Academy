# -*- coding:utf-8 -*-

with open('test01.txt', 'r') as file: 
# with open() 함수는 file 변수의 close()를 자동으로 해준다
    a = file.read()
    print(a)