from sys import stdin
from collections import deque
input = stdin.readline

n = int(input())
a, b = map(int, input().split())
m = int(input())

tree = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]
visited[0] = True

for _ in range(m):
  x, y = map(int, input().split())
  tree[x].append(y)
  tree[y].append(x)

# a부터 bfs돌면서 b를 찾아보자
# 찾으면 그 거리를 출력하고, 찾지 못하면 -1을 출력하자
queue = deque()

queue.append(a)
visited[a] = True
d = 0

while queue:
  size = len(queue)
  while size > 0:
    p = queue.popleft()
    if p == b:
      print(d)
      exit()
    size -= 1
    for n_p in tree[p]:
      if visited[n_p]:
        continue
      queue.append(n_p)
      visited[n_p] = True
      
  d += 1

print(-1)