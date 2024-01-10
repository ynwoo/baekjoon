from sys import stdin
input = stdin.readline

n = int(input())
info = list(map(int, input().split()))

answer = []

for i in range(n-1,-1,-1):
  number = i + 1
  answer.insert(info[i], number)
print(*answer)