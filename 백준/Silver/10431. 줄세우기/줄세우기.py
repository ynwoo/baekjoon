from sys import stdin
input = stdin.readline

n = int(input())
for i in range(n):
  line = []
  answer = 0
  a, *order = map(int,input().split())
  for o in order:
    for l in line:
      if o < l:
        answer += 1
    line.append(o)
  print(f"{a} {answer}")
      