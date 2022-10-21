def solution(a, b, n):
    answer = 0
    while a <= n:
        p = (n//a) * b
        n -= (n//a) * a
        n += p
        answer += p

    return answer