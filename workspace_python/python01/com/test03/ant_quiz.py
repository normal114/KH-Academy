# 개미수열

def ant(i):
    inp = str(i)
    cnt = 0
    target = inp[0]
    res = ''
    
    for a in inp:
        if a == target:
            cnt += 1
        else:
            res += target + str(cnt)
            cnt = 1
            target = a
    res += target + str(cnt)
        
    return res
    
    
if __name__ == '__main__':
    n = input('ant stage : ')
    print('1')
    
    val = ant(1)
    print(val)
    
    for i in range(1, int(n)):
        var = ant(val)
        print(val)


# from itertools import count

#char = "1"
#output = ""

#for i in range(10):
#    j = 0
#    while j < len(char):
#        curr = char[j]
#        count = 1
#        while j + 1 < len(char) and curr == char[j+1]:
#            count += 1
#            j += 1
#        output += curr + str(count)
#        j += 1
#    print(output)
#    char = output
#    output = ""



