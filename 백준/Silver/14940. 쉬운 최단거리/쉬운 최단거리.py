from sys import stdin
from collections import deque
input = stdin.readline

n, m = map(int, input().split())
board = []
for _ in range(n):
  board.append(list(map(int, input().split())))

start_point = [0, 0]
for i in range(n):
  for j in range(m):
    if board[i][j] == 2:
      start_point[0], start_point[1] = i, j
      break

di = [0,0,1,-1]
dj = [1,-1,0,0]

queue = deque()
visited = [[False] * m for _ in range(n)]
cnt = 0

queue.append(start_point)
visited[start_point[0]][start_point[1]] = True

while queue:
  size = len(queue)
  while size > 0:
    cur_x, cur_y = queue.popleft()
    size -= 1
    board[cur_x][cur_y] = cnt

    for d in range(4):
      ni, nj = cur_x + di[d], cur_y + dj[d]
      if ni < 0 or n <= ni or nj < 0 or m <= nj:
        continue
      if visited[ni][nj]:
        continue
      if board[ni][nj] == 0:
        continue
        
      queue.append([ni,nj])
      visited[ni][nj] = True
      
  cnt += 1

for i in range(n):
  for j in range(m):
    if visited[i][j] or board[i][j] == 0:
      continue
    board[i][j] = -1
    
for i in range(n):
  print(*board[i])