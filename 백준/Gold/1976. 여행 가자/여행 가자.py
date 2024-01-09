from sys import stdin
from collections import deque
input = stdin.readline

n = int(input())
m = int(input())
graph = [[0] * (n+1)]
for _ in range(n):
  graph.append([0] + list(map(int, input().split())))
order = list(map(int, input().split()))

for i in range(1, n+1):
  graph[i][i] = 1
  # bfs
  visited = [False] * (n+1)
  queue = deque()
  
  queue.append(i)
  visited[i] = True
  
  while queue:
    v = queue.popleft()
    for j in range(1, n+1):
      if graph[v][j] == 0:
        continue
      if visited[j]:
        continue
        
      queue.append(j)
      visited[j] = True

      if graph[i][j] == 0:
        graph[i][j] = 2
  
# print(graph)

for i in range(m-1):
  if graph[order[i]][order[i+1]] == 0:
    print("NO")
    exit()
print("YES")