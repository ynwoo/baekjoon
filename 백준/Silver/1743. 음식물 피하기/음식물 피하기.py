from collections import deque

n, m, k = map(int, input().split())
arr = [['.'] * m for _ in range(n)]
visited = [[False] * m for _ in range(n)]
answer = 0

for _ in range(k):
  i, j = map(int, input().split())
  arr[i - 1][j - 1] = '#'


for i in range(n):
  for j in range(m):
    if arr[i][j] == '#' and not visited[i][j]:
      visited[i][j] = True

      cnt = 1
      
      q = deque()
      q.append((i, j))
      while q:
        x, y = q.popleft()
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
          nx, ny = x + dx, y + dy
          if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == '#' and not visited[nx][ny]:
            visited[nx][ny] = True
            q.append((nx, ny))
            cnt += 1

      answer = max(answer, cnt)

print(answer)