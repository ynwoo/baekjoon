from sys import stdin
input = stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()
stack = []

def dfs(i):
  if i == m:
    print(*stack)
    return

  for j in range(1, n + 1): 
    stack.append(arr[j-1])
    dfs(i+1)
    stack.pop()
    
dfs(0)