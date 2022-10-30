from sys import stdin
input = stdin.readline
from collections import deque


def bfs(v):
  global cnt
  queue = deque([v])
  bfs_visited[v] = True

  while queue:
    v = queue.popleft()

    for i in range(1,n+1):
      if matrix[v][i] == 1 and not bfs_visited[i]:
        queue.append(i)
        bfs_visited[i] = True
        cnt+=1

        
n = int(input())
m = int(input())

# 인접행렬
matrix = [[0] * (n+1) for _ in range(n+1)]

bfs_visited = [False] * (n+1)

for _ in range(m):
  a, b = map(int,input().split())
  matrix[a][b] = matrix[b][a] = 1

cnt = 0
bfs(1)
print(cnt)
