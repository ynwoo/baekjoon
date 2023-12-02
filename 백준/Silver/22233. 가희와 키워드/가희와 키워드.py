from sys import stdin

n, m = map(int,stdin.readline().split())
memo = set()
for _ in range(n):
  memo.add(stdin.readline().rstrip())

# print(memo)
for _ in range(m):
  blog = set(stdin.readline().rstrip().split(','))
  # print(blog)
  memo -= blog
  print(len(memo))