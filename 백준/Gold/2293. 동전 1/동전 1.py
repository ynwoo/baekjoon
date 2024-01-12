from sys import stdin
input = stdin.readline

n, k = map(int, input().split())
coin_values = [int(input()) for _ in range(n)]

dp = [0] * (k+1)
dp[0] = 1
for value in coin_values:
  for i in range(value, k+1):
    if value <= i:
      dp[i] += dp[i-value]
print(dp[k])