from sys import stdin
input = stdin.readline

n = 0
s = input().strip()

while True:
  n += 1
  num = str(n)
  while len(s) > 0 and len(num) > 0:
    if s[0] == num[0]:
      s = s[1:]
    num = num[1:]

  if s == '':
    print(n)
    break