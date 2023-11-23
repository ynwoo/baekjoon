from collections import deque


n, m = map(int, input().split())
indegree = [0] * (n + 1)
graph = [[] for i in range(n+1)]

for _ in range(m):
  cnt, *singers = map(int, input().split())
  for i in range(cnt - 1):
    graph[singers[i]].append(singers[i+1])
    indegree[singers[i+1]] += 1

def topology_sort():
  result = []
  q = deque()
  for i in range(1, n+1):
    if indegree[i] == 0:
      q.append(i)
  while q:
    v = q.popleft()
    result.append(v)
    for w in graph[v]:
      indegree[w] -= 1
      if indegree[w] == 0:
        q.append(w)
  if len(result) == n:
    for i in result:
      print(i, end=' ')
  else:
    print(0)

topology_sort()