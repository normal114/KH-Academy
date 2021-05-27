def func01(x, y):
    return x + y


def func02(x, y):
    return x + y, x - y # 두 개로 값을 리턴 받으면 ()tuple로 리턴 받는다.


def print_test(x, y): # 파이썬은 기본적으로 c기반의 파이썬이다. 따라서 일반적으로 함수명을 _를 사용하여 생성하는 경우가 많다.
    print("파라미터로 %d, %d 두 개가 들어왔습니다." % (x, y))
    print("{} + {} = {}".format(x, y, x + y))
    print(x, '+', y, '=', x+y)
    print(str(x) + " + " + str(y) + " = " + str(x+y))
    
if __name__ == '__main__':
    a = func01(1, 3)
    print(a)
    
    b, c = func02(4, 7) # 언패킹
    d = func02(5, 8)
    print(b)
    print(c)
    print(d)
    print_test(6, 3)
    
    
    