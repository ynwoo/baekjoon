from collections import deque

n = int(input())
answer = 0
arr = []
dp = [[0] * n for _ in range(n)]
dp[0][0] = 0
for i in range(n):
  arr.append(list(map(int, input().split())))

jump_size = arr[0][0]

if jump_size < n:
  dp[jump_size][0] += 1
if jump_size < n:
  dp[0][jump_size] += 1

# print(dp)
for i in range(n):
  for j in range(n):
    if dp[i][j] != 0 and arr[i][j] != 0:
      jump_size = arr[i][j]
      # jump
      if i + jump_size < n:
        dp[i + jump_size][j] += dp[i][j]
  
      if j + jump_size < n:
        dp[i][j + jump_size] += dp[i][j]

      # print(i, j, dp)

print(dp[-1][-1])