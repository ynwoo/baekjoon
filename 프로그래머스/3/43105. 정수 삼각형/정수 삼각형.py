def solution(triangle):
    h = len(triangle)
    dp = [ [0] * h for _ in range(h)]
    dp[0][0] = triangle[0][0]
    for i in range(h):
        if i != 0:
            dp[i][0] += dp[i-1][0] +triangle[i][0]
    for i in range(h):
        for j in range(i+1):
            if i != 0 and j != 0:
                dp[i][j] = triangle[i][j] + max(dp[i-1][j-1], dp[i-1][j])
    answer = max(dp[-1])
    return answer