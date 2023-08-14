def solution(s):
    answer = 0
    start = True
    c1 = 0
    c2 = 0
    for c in s:
        if start:
            x = c
            c1 += 1
            start = False
        else:
            if c == x:
                c1 += 1
            else:
                c2 += 1
            if c1 == c2:
                answer += 1
                c1 = 0
                c2 = 0
                start = True
    if not start:
        answer += 1
    return answer