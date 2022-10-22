from sys import stdin
input = stdin.readline


T = int(input())
for _ in range(T):
  a, b = input().split()
  print(str(bin(int(a,2) + int(b,2)))[2:])
