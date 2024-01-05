from sys import stdin
import math
input = stdin.readline

n = int(input())
m = int(input())
x = list(map(int,input().split()))
answer = max(x[0], n-x[-1])
for i in range(1,m):
  answer = max(answer, math.ceil((x[i]-x[i-1])/2))
print(answer)