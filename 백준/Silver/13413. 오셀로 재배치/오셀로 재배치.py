from sys import stdin
input = stdin.readline

T = int(input())
for _ in range(T):
  N = int(input())
  before = input().rstrip()
  after = input().rstrip()
  cnt1 = 0
  cnt2 = 0
  for i in range(N):
    if before[i] == 'B' and after[i] == 'W':
      cnt1 += 1
    elif before[i] == 'W' and after[i] == 'B':
      cnt2 += 1
    else:
      continue

  print(cnt1 + cnt2 - min(cnt1, cnt2))