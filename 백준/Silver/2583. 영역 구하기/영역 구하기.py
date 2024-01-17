from sys import stdin
from collections import deque
input = stdin.readline
  
m, n, k = map(int, input().split())
board = [[0] * m for _ in range(n)]
area_list = []
for _ in range(k):
  x1, y1, x2, y2 = map(int, input().split())
  for i in range(x1, x2):
    for j in range(y1, y2):
      board[i][j] = 1

visited = [[False] * m for _ in range(n)]
di = [0, 0, 1, -1]
dj = [1, -1, 0, 0]
def bfs(i, j):
  area = 0
  queue = deque()

  queue.append((i,j))
  visited[i][j] = True
  area += 1
  
  while queue:
    a, b = queue.popleft()
    for d in range(4):
      ni = a + di[d]
      nj = b + dj[d]

      if ni < 0 or n <= ni or nj < 0 or m <= nj:
        continue
      if board[ni][nj] == 1:
        continue
      if visited[ni][nj]:
        continue

      queue.append((ni,nj))
      visited[ni][nj] = True
      area += 1
      
  return area
  
for i in range(n):
  for j in range(m):
    if visited[i][j] or board[i][j] == 1:
      continue

    area_list.append(bfs(i,j))

print(len(area_list))
print(*sorted(area_list))