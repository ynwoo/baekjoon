def solution(park, routes):
    n = len(park)
    m = len(park[0])
    
    answer = []
    ci, cj = get_start_point(park)
    
    for route in routes:
        flag = True
        op, d = route.split(" ")
        d = int(d)
        if op == 'E' and cj + d < m:
            for j in range(cj, cj + d + 1):
                if park[ci][j] == 'X':
                    flag = False
                    break
            if flag:
                cj += d
        elif op == 'W' and cj - d >= 0:
            for j in range(cj-d, cj):
                if park[ci][j] == 'X':
                    flag = False
                    break
            if flag:
                cj -= d
        elif op == 'S' and ci + d < n:
            for i in range(ci, ci +d +1):
                if park[i][cj] == 'X':
                    flag = False
                    break
            if flag:
                ci += d
        elif op == 'N' and ci - d >= 0:
            for i in range(ci-d, ci):
                if park[i][cj] == 'X':
                    flag = False
                    break
            if flag:
                ci -= d
        else:
            continue

    answer.append(ci)
    answer.append(cj)
    
    return answer

def get_start_point(park):
    n = len(park)
    m = len(park[0])
    for i in range(n):
        for j in range(m):
            if park[i][j] == 'S':
                c_i = i
                c_j = j
                return c_i, c_j