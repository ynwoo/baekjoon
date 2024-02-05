from sys import stdin
input = stdin.readline

s = input().rstrip()
counts = [0] * 26

for c in s:
  if 'a' <= c <= 'z':
    counts[ord(c) - ord('a')] += 1

for c in counts:
  print(c, end=' ')