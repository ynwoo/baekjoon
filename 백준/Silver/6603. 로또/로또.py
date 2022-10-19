from itertools import combinations
k=1
while k:
  S = list(map(int,input().split()))
  k = S.pop(0)

  for l in combinations(S, 6):
    print(' '.join(map(str,l)))
  ### 출력

  print()
  