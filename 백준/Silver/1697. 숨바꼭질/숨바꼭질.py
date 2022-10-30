from sys import stdin
input = stdin.readline
from collections import deque


def bfs(v):
  global answer
  queue = deque([v])

  while queue:
    v = queue.popleft()
  
    if v == k:
      answer = bfs_visited[v]
      return

    for new_v in (v - 1, v + 1, v * 2):
      if 0 <= new_v <= 100000 and not bfs_visited[new_v]:
        queue.append(new_v)
        bfs_visited[new_v] = bfs_visited[v] + 1
    
 
n, k = map(int, input().split())

bfs_visited = [0] * 100001

answer = 0
bfs(n)
print(answer)
