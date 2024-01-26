from sys import stdin
input = stdin.readline

n, m  = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

answer = []
def dfs(i):
  if i == m:
    print(*answer)
    return
  tmp = 0
  for j in range(n):
    if tmp != arr[j]:
      tmp = arr[j]
      answer.append(arr[j])
      dfs(i+1)
      answer.pop()
    
dfs(0)