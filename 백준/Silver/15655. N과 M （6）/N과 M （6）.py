from sys import stdin
input = stdin.readline
n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
stack = []
visited = [False] * (n + 1)
def dfs(i):
  if i == m:
    print(*stack)
    return

  for j in range(1, n + 1):
    if visited[j]:
      continue
    if stack and stack[-1] >= arr[j-1]:
      continue
      
    visited[j] = True
    stack.append(arr[j-1])
    dfs(i+1)
    stack.pop()
    visited[j] = False
    
dfs(0)