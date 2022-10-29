from sys import stdin
input = stdin.readline


t = int(input())
for _ in range(t):
  words = list(input().strip().split())

  for word in words:
    print(''.join(reversed(str(word))), end=' ')
  print()
