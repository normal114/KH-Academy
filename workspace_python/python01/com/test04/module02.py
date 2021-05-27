# pip install numpy        -> 수치해석
# pip install matplotlib   -> 그래프(시각화)

# import <module_name> as <alias>
import numpy as np # numpy로 쓰기 힘들어서 np로 쓸 것이다
import matplotlib.pyplot as plt
import random


def plt01():
    x = np.arange(0, 11)
    y = x
    # print(x)
    plt.plot(x, y)
    
    plt.xlabel('x') # x축
    plt.ylabel('y') # y축
    
    plt.legend(['y=x']) # 작은 창(범례) 위치
    # plt.legend(['y=x'], loc=(1.0, 1.0))
    
    plt.show()
    
plt01()
    
        
def plt02():
    y = [random.randint(0, 10) for _ in range(10)]
    x = range(10)
    
    plt.bar(x, y)
    
    # 축 간격 설정
    plt.xticks(range(11))
    plt.yticks(range(11))
    
    plt.show()

plt02()

def plt03():
    data = [random.randint(100, 1000) for _ in range(4)]
    
    plt.pie(data)
    
    category = ['first', 'second', 'third', 'fourth']
    plt.legend(category)
    
    plt.show()
    

plt03()