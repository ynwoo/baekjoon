from sys import stdin
input = stdin.readline

n, new_score, p = map(int, input().split())
ranking = [-1] * p
if n != 0:
  current_ranking = list(map(int, input().split()))
  for i in range(n):
    ranking[i] = current_ranking[i]
    
# print(ranking)

idx = -1
for i in range(p):
  if ranking[i] < new_score:
    ranking.insert(i, new_score)
    del ranking[-1]
    idx = i
    break
    
# print(idx)
# print(ranking)

if idx == -1:
  print(-1)
else:
  rank = 1
  if idx == 0:
    print(1)
  else:
    tmp = 1
    for i in range(1, p):
      if ranking[i] != ranking[i-1]:
        rank += tmp
        tmp = 1
      else:
        tmp += 1
      if idx == i:
        print(rank)
        break