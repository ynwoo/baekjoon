from itertools import combinations


n, s = map(int,input().split())
arr = list(map(int,input().split()))

answer = 0
for i in range(1,n+1):
  tmp = list(combinations(arr, i))
  for t in tmp:
    if sum(t) == s:
      answer+=1

print(answer)
