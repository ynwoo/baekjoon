from sys import stdin
input = stdin.readline

s = list(input().rstrip())
zero_cnt = s.count('0') // 2
one_cnt = s.count('1') // 2

cnt = 0
for i in range(len(s)):
  if s[i] == '1':
    s[i] = '-'
    cnt += 1
  if cnt == one_cnt:
    break

cnt = 0
for i in range(len(s)-1,-1,-1):
  if s[i] == '0':
    s[i] = '-'
    cnt += 1
  if cnt == zero_cnt:
    break

s = [i for i in s if i != '-']
print(''.join(s))