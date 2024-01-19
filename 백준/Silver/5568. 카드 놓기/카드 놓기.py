from sys import stdin

input = stdin.readline

n = int(input())
k = int(input())

answer = set()

s = ""
l = []
for _ in range(n):
  l.append(int(input()))

visited = [False] * n
def dfs(i):
  global s

  if i == k:
    answer.add(s)
    return

  for j in range(n):
    if visited[j]:
      continue
      
    visited[j] = True     
    s = s + str(l[j])
    dfs(i + 1)
    visited[j] = False
    s = s[:-len(str(l[j]))]


dfs(0)
print(len(answer))