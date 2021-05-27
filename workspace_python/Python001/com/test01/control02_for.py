subject = ['java', 'javascript', 'python']

for i in subject:
    print(i)
    
for i in subject:
    print(i, end=' ')
else :
    print('재밌다.')

for i in range(1, 100):
    print(i, end=' ')
print()
for i in range(10, 0, -1):
    print(i, end=' ')

for i in range(2, 10):
    print('<<' + str(i) +'딘>>')
    for j in range(1, 10):
        print(i, '*', j, '=', i*j, sep=' ')
    