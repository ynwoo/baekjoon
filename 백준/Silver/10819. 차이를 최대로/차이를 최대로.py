from sys import stdin
input = stdin.readline

n = int(input())
arr = list(map(int, input().split()))

max_value = float('-INF')
visited = [False] * n
answer = []

def cal(candidate_list):
  tmp = 0
  for i in range(n-1):
    tmp += abs(candidate_list[i] - candidate_list[i+1])
    
  return tmp
def dfs(i):
  global max_value
  
  if i == n:
    max_value = max(max_value, cal(answer))
    return

  for j in range(n):
    if visited[j]:
      continue

    visited[j] = True
    answer.append(arr[j])
    dfs(i+1)
    answer.pop()
    visited[j] = False
    
dfs(0)

print(max_value)