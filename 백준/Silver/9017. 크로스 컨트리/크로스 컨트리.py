from sys import stdin
from collections import defaultdict
input = stdin.readline

T = int(input())
for _ in range(T):
  rank = 1
  n = int(input())
  arr = list(map(int,input().split()))
  team_cnt = defaultdict(int)
  team_score = defaultdict(int)
  fifth_idx = defaultdict(int)
  for i in range(n):
    team_cnt[arr[i]] += 1
  
  tmp_cnt = defaultdict(int)
  for i in range(n):
    tmp_cnt[arr[i]] += 1
    if team_cnt[arr[i]] == 6:
      if tmp_cnt[arr[i]] == 5:
        fifth_idx[arr[i]] = i
        
      if tmp_cnt[arr[i]] < 5:
        team_score[arr[i]] += rank
      rank += 1
  
  # print(team_cnt)
  # print(team_score)
  # print(fifth_idx)
  
  min_key = min(team_score, key=lambda k: team_score[k])

  candidates = []
  for number, score in team_score.items():
    if score == team_score[min_key]:
      candidates.append(number)
  # print(candidates)
  if len(candidates) == 1:
    print(candidates[0])
  else:
    answer = 1000000000
    for c in candidates:
      tmp = 0
      for i in range(n):
        if arr[i] == c:
          tmp += 1
        if tmp == 5:
          answer = min(answer, i)
          break
    print(arr[answer])
      
  