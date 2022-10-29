import heapq
from sys import stdin
input = stdin.readline

answer = 0
arr = []
for i in range(1,9):
  arr.append([int(input()),i])

arr.sort(reverse=True)
arr = arr[:5]
for i in range(5):
  answer += arr[i][0]
print(answer)

arr.sort(key = lambda x : x[1])
for i in range(5):
  print(arr[i][1], end=' ')
