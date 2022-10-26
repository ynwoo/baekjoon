import heapq
from sys import stdin
input = stdin.readline


heap_min = []

for i in range(int(input())):
  x = int(input())
  if x == 0:
    if len(heap_min) == 0:
      print(0)
    else:
      print(heapq.heappop(heap_min)[1])
  else:
    if x < 0:
      heapq.heappush(heap_min, (-x,x))
    else:
      heapq.heappush(heap_min, (x,x))