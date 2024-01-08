from sys import stdin
from collections import deque
input = stdin.readline

di = [0, 0, 1, -1]
dj = [1, -1, 0, 0]
n, l, r = map(int, input().split())
a = []
for _ in range(n):
  a.append(list(map(int, input().split())))

answer = 0
union = -1
while union != 0:
  union = 0
  visited = [[False] * n for _ in range(n)]
  for i in range(n):
    for j in range(n):
      if visited[i][j]:
        continue
        
      queue = deque()
      candidates = []
      s = 0
      
      visited[i][j] = True
      queue.append((i, j))
      
      while queue:
        x, y = queue.popleft()

        candidates.append((x, y))
        s += a[x][y]
        
        for d in range(4):
          nx = x + di[d]
          ny = y + dj[d]
          if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue
          if visited[nx][ny]:
            continue
          if abs(a[x][y] - a[nx][ny]) < l or r < abs(a[x][y] - a[nx][ny]):
            continue
            
          union += 1

          if union == 1:
            answer += 1
          visited[nx][ny] = True
          queue.append((nx, ny))
      
      if len(candidates) > 1:
        for c_i, c_j in candidates:
          a[c_i][c_j] = s // len(candidates)
          
# print(a)
print(answer)