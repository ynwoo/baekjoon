from sys import stdin
input = stdin.readline

T = int(input())
for _ in range(T):
  left = []
  right = []
  L = input().rstrip()
  for c in L:
    if c == '-':
      if left:
        left.pop()
    elif c == '<':
      if left:
        right.append(left.pop())
    elif c == '>':
      if right:
        left.append(right.pop())
    else:
      left.append(c)

  right = right[::-1]
  print(''.join(left) + ''.join(right))