import numpy as np

a = np.array([[1, 2]])
b = np.array([[3], [4]])

# 벡터의 내적
# 행렬 곱으로도 사용
print(a.dot(b))

# 전치행렬 : 모양을 바꾸는 것이다. [] 형태를 () 형태로 바꾸었다.
# 라벨을 여러 개 만들 때 가로로 만들어 진 얘를 세로로 또는 세로로 만들어진 얘를 가로로 만들 때 필요하다.
print(a)
print(a.shape)
a_t = a.T
print(a_t)
print(a_t.shape)

# 절대값
print(np.linalg.norm(a))

# sigma : 전부 더한다.
# 1 ~ 100까지 다 더하고 싶다.
# [1 1 1 1 ... 1] * [[1],[2],[3],...,[100]]
c = np.ones(100)
print(c)
d = np.arange(1, 101)
print(d)
print(c.dot(d)) # dot 형태로 바뀌어서 다 곱해졌다.





