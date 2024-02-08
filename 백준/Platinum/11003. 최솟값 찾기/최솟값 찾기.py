from sys import stdin
from collections import deque
input = stdin.readline

n, l = map(int, input().split())
arr = list(map(int, input().split()))

deq = deque()
for i in range(n):
  while deq and deq[-1][1] > arr[i]:
    deq.pop()
  while deq and deq[0][0] < i - l + 1:
    deq.popleft()

  deq.append([i, arr[i]])
  print(deq[0][1], end=' ')