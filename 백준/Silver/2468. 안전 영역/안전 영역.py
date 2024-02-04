from sys import stdin
from collections import deque
input = stdin.readline

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

min_h = min(map(min, board))
max_h = max(map(max, board))

dx = [0,0,1,-1]
dy = [1,-1,0,0]
answer = 0
for h in range(max_h):
  cnt = 0
  visited = [[False] * n for _ in range(n)]
  for i in range(n):
    for j in range(n):
      if board[i][j] > h and not visited[i][j]:
        cnt += 1
        queue = deque()

        queue.append([i,j])
        visited[i][j] = True

        while queue:
          x, y = queue.popleft()
          for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if nx < 0 or n <= nx or ny < 0 or n <= ny:
              continue
            if board[nx][ny] <= h:
              continue
            if visited[nx][ny]:
              continue
            queue.append([nx,ny])
            visited[nx][ny] = True
  answer = max(cnt, answer)

print(answer)