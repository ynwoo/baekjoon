import heapq
from sys import stdin
input = stdin.readline

k = int(input())
for i in range(k):
  n, *arr = map(int, input().split())
  arr.sort(reverse=True)
  
  diff = 0
  for j in range(n-1):
    if arr[j] - arr[j+1] > diff:
      diff = arr[j] - arr[j+1]

  print('Class ' + str(i+1))
  print('Max ' + str(arr[0]) + ', Min ' +  str(arr[-1]) + ', Largest gap ' + str(diff))
