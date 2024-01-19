from sys import stdin
input = stdin.readline

n, m = map(int, input().split())
arr = [0] * m

def dfs(i):
  if i == m:
    print(*arr)
    return
    
  for number in range(1, n+1):
    arr[i] = number
    dfs(i+1)
    
dfs(0)