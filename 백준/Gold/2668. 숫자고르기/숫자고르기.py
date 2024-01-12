from sys import stdin
input = stdin.readline

n = int(input())
graph = [[] for _ in range(n+1)]

for i in range(1, n+1):
  graph[i].append(int(input()))

cnt = 0
answer = []

def dfs(v):
  global cnt, first_v
  visited[v] = True
  next_v = graph[v][0]

  if not visited[next_v]:
    dfs(next_v)
    
  else:
    if next_v == first_v:
      cnt += 1
      answer.append(first_v)
    return  
  
for i in range(1, n+1):
  visited = [False] * (n+1)
  first_v = i
  dfs(i)

print(cnt)
for a in answer:
  print(a)