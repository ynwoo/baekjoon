from sys import stdin
from math import gcd
input = stdin.readline

n = int(input())
arr = []
distances = []
for _ in range(n):
  arr.append(int(input()))

for i in range(1,n):
  distances.append(arr[i] - arr[i-1])

g = distances[0]
for i in range(1,n-1):
  g = gcd(g, distances[i])

answer = 0
for i in range(n-1):
  answer += ((distances[i] // g) - 1)
print(answer)