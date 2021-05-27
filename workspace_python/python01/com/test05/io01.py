# -*- coding:utf-8 -*-

# 아래에 나오는 모든 문자열이 UTF-8 형식이라는 것을 명시하는 코드

file = open('test01.txt', 'w')
file.write('Hello, world!')
file.close()

'''
r : 읽기
w : 쓰기 (기존 내용 덮어쓰기)
a : 쓰기 (기존 내용 이어서 쓰기)
x : 새로운 파일 만들어서 쓰기  (이미 파일이 있으면 에러)
t / b : text / binary (default : t)
'''