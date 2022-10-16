from itertools import combinations, permutations

n=int(input())
arr=[i for i in range(n)]
comb=list(combinations(arr,n//2))

players=[]
for i in range(n):
    players.append(list(map(int,input().split())))

answer = float('inf')
for k in range(len(comb)//2):
  start = 0
  link  = 0
  for i, j in list(permutations(comb[k], 2)):
    start += players[i][j]
  for i, j in list(permutations(list(set(arr)-set(comb[k])),2)):
    link += players[i][j]

  tmp = abs(start-link)
  if answer > tmp:
    answer = tmp

print(answer)  