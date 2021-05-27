import tensorflow as tf

# np.float64 == tf.float64랑 같다.
# tensorflow 내부적으로 numpy 사용중! 내부적으로 모듈 데이터를 가지고 놀고 있다.
node1 = tf.constant(10, dtype=tf.float32)
node2 = tf.constant(20, dtype=tf.float32)
node3 = node1 + node2

sess = tf.Session()

print(sess.run(node3))
