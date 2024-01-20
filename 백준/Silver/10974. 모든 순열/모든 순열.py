from sys import stdin

input = stdin.readline

n = int(input())
visited = [False] * (n + 1)
stack = []
def dfs(i):
  if i == n:
    print(*stack)
    return

  for j in range(1, n + 1):
    if visited[j]:
      continue

    visited[j] = True
    stack.append(j)
    dfs(i+1)
    stack.pop()
    visited[j] = False
  
dfs(0)