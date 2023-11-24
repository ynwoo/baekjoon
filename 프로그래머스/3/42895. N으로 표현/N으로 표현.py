def solution(N, number):
    answer = -1
    depth = 8
    dp = [set() for _ in range(depth)]
    for i in range(depth):
        dp[i].add(int(str(N) * (i + 1)))
        
        for j in range(i):
            for first in dp[j]:
                for second in dp[i-1-j]:
                    dp[i].add(first + second)
                    dp[i].add(first - second)
                    dp[i].add(first * second)
                    if second != 0:
                        dp[i].add(first // second)
        if number in dp[i]:
            answer = i + 1
            break

    return answer