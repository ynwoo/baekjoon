import sys
sys.setrecursionlimit(10**5)

n, m, r = map(int,input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
  a, b = map(int,input().split())
  graph[a].append(b)
  graph[b].append(a)

for i in range(1,n+1):
  graph[i].sort()

# print(graph)

orders = [0] * (n+1)
visited = [False] * (n+1)
cnt = 1
def dfs(graph, r):
  global cnt
  visited[r] = True
  orders[r] = cnt
  cnt += 1
  for u in graph[r]:
    if not visited[u]:
      dfs(graph, u)

dfs(graph, r)
for i in range(1, n+1):
  print(orders[i])