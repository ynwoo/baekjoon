from sys import stdin
input = stdin.readline

T = int(input())
for _ in range(T):
  n = int(input())
  arr = []
  for _ in range(n):
    name, l = input().split()
    arr.append([name, int(l)])

  arr.sort(key = lambda x : -x[1])
  print(arr[0][0])