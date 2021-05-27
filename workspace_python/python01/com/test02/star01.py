'''
*
**
***
****
*****
'''

'''
x = int(input("줄 수를 입력하세요 : "))
for i in range(1, x+1):
   for j in range(i):
       print("*", end="")
   print()

for i in range(5):
   for j in range(i + 1):
       print('*', end='')
   print()
print('-----')

for i in range(5):
    print('*' * (i + 1))
print('-----')
'''

'''
*****
****
***
**
*
'''
for i in range(5):
    print('*' * (5 - i))
print('-----')

for i in range(6, 1, -1):
    print('{:<5}'.format('*' * (i - 1)))
print('-----')

'''
    *
   **
  ***
 ****
*****
'''

for i in range(5):
    print(' ' * (4 - i) + '*' * (1 + i))
print('-----')

for i in range(5):
    print('{:>5}'.format('*' * (i + 1)))
print('-----')

'''
*****
 ****
  ***
   **
    *
'''
for i in range(5):
    print(' ' * (i) + '*' * (5 - i))
print('-----')

for i in range(6, 1, -1):
    print('{:>5}'.format('*' * (i-1)))
print('-----')

'''
    *
   ***
  *****
 *******
*********
'''

for i in range(5):
    print(' ' * (4 - i ) + '*' * (2 * i + 1))
print('-----')
for i in range(1, 11, 2):
    print('{:^10}'.format('*' * i))
print('-----')

for i in range(1, 11, 2):
    print('{:^10}'.format('*' * i))

for i in range(9, 0, -2):
    print('{:^10}'.format('*' * i))
print('-----')    
    
for i in range(9, 0, -2):
    print('{:^10}'.format('*' * i))
    
for i in range(3, 11, 2):
    print('{:^10}'.format('*' * i))