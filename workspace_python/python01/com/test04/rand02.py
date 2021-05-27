import random

def lotto():
    result = set() # set : 중복이 안 됨
    
    # len() : length -> 객체의 길이를 리턴
    while len(result) <= 6:
        ran = random.randint(1, 45)
        result.add(ran)
    lst = sorted(result)
    print(lst)
        
    
if __name__ == '__main__':
    lotto()