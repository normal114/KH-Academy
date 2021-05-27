import tensorflow as tf

# print(tf.__version__)

# 상수노드, 100을 입력
node = tf.constant(100)

# session : 그래프를 실행시켜주는 역할, 100을 학습
sess = tf.Session()

# 실행, 출력
print(sess.run(node))

c1 = tf.constant([1, 1])
c2 = tf.constant([2, 2])
c3 = tf.constant([0, 3])
cond = tf.constant([True, False])

c1
c1.numpy()
print(c1.numpy())

def prt(input):
    print(input.numpy())


