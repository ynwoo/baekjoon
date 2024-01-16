from sys import stdin
from collections import defaultdict
input = stdin.readline

n = int(input())
first_word = input().rstrip()
words = [input().rstrip() for _ in range(n-1)]
answer = 0

for word in words:
  dict = defaultdict(int)
  
  for w in first_word:
    dict[w] -= 1
  for w in word:
    dict[w] += 1

  flag = False
  one_cnt = 0
  zero_cnt = 0
  for key, value in dict.items():
    if abs(value) > 1:
      flag = True
      break
    if value == 1:
      one_cnt += 1
    if value == -1:
      zero_cnt += 1

  if one_cnt >= 2 or zero_cnt >= 2:
    flag = True

  if flag:
    continue

  answer += 1
print(answer)