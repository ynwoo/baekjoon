for _ in range(3):
  s = input().split()
  c1 = s.count('0')
  if c1 == 0:
    print('E')
  elif c1 == 1:
    print('A')
  elif c1 == 2:
    print('B')
  elif c1 == 3:
    print('C')
  else:
    print('D')