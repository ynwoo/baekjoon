n = int(input())
arr = list(map(int, input().split()))
dp = [0] * n

for i in range(n):
  s = arr[i]
  m = 0
  for j in range(i,-1,-1):
    if arr[j] < arr[i]:
      if m < dp[j]:
        m = dp[j]
  dp[i] = s + m
  if m < dp[i]:
    m = dp[i]

print(max(dp))