from sys import stdin
from collections import Counter
input = stdin.readline

n = int(input())
arr = []
for _ in range(n):
  arr.append(int(input()))
c = Counter(arr)
sorted_count = sorted(c.items(), key=lambda x:(-x[1], x[0]))

print(sorted_count[0][0])