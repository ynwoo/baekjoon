from sys import stdin
input = stdin.readline

n, m = map(int, input().split())
dp = [[[1000 for d in range(3)] for row in range(m)] for col in range(n)]

input_space = [list(map(int, input().split())) for _ in range(n)]

for i in range(n):
  for j in range(m):
    for k in range(3):
      if j == 0 and k == 0:
        continue
      if j == m-1 and k == 2:
        continue
      if i == 0:
        dp[i][j][k] = input_space[i][j]
      else:
        if k == 0:
          dp[i][j][k] = (min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + input_space[i][j])
        elif k == 1:
          dp[i][j][k] = (min(dp[i-1][j][0], dp[i-1][j][2]) + input_space[i][j])
        else:
          dp[i][j][k] = (min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + input_space[i][j])

print(min(map(min, dp[n-1])))