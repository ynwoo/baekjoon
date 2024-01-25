from sys import stdin
input = stdin.readline

n, m  = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

visited = [False] * n
s = []
answer = []
def dfs(i):
  if i == m:
    if answer not in s:
      print(*answer)
      s.append(answer[:])
    return
  for j in range(n):
    if visited[j]:
      continue
    if len(answer) > 0:
      if answer[-1] > arr[j]:
        continue
        
    visited[j] = True
    answer.append(arr[j])
    dfs(i+1)
    answer.pop()
    visited[j] = False
    
dfs(0)