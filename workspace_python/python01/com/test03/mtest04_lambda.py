# lambda 파라미터 : 리턴될 값
from pickle import NONE

hap01 = lambda a, b: a + b
print(hap01(10, 20))

# python은 아주 간단하다. pytonic이라고도 불린다

gob = lambda a, b: a * b
print(gob(10, 20))

hap02 =lambda a, b, c: a + b + c
print(hap02(10, 20, 30))

a = [(1, 'one', 9), (2, 'two', 8), (3, 'three', 7), (4, 'four', 6)]
a.sort(key=lambda a:a[1])
print(a) 
# a가 가진 1번지 기준으로 정렬 f -> o -> th -> tw
a.sort(key=lambda a:a[2])
print(a)
# a가 가진 2번지 기준으로 정렬 6 -> 7 -> 8 -> 9

# min01 = lambda x, y: x if x < y else y
# print(min01(11, 22))
min01 = (lambda x, y: x if x < y else y)(11, 22)
print(min01)
# x가 더 작으면 11, y가 더 작으면 22를 출력하라

max01 = (lambda x, y: x if x > y else y)(33, 44)
print(max01)

b = lambda x: (lambda newx: x + newx)
print(b(100)(90))

# c = lambda newx : 100 + newx
c = b(100)
print(c)
# d = 100 + 90
d = c(90)
print(d)

# 1 ~ 100 사이에서 5의 배수 출력
e = lambda x: bool(x % 5) # bool : 참인지 거짓인지 판별
# print(e(6)) : True
# print(e(5)) : False
# print(e(9)) : True
five = [i for i in range(1, 100) if not e(i)]
print(five)

# None == Null
f = lambda x: x if (x % 5 != 0) else None
res = [i for i in range(1, 100) if not f(i)]
print(res)

result = [i for i in range(1, 100) if not (lambda x: x if (x % 5 != 0) else None)(i)]
print(result)



