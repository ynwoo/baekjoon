from sys import stdin
input = stdin.readline
from itertools import combinations
import math

  
t = int(input())
for i in range(t):
  n, *arr = map(int,input().split())
  s = 0
  for pair in combinations(arr,2):
    s += math.gcd(pair[0], pair[1])
  
  print(s)