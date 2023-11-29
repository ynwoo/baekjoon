def solution(m, n, puddles):
    answer = 0
    map = [[0] * (m+1) for _ in range(n+1)]
    divide_num = 1000000007
    for puddle in puddles:
        x = puddle[1]
        y = puddle[0]
        map[x][y] = -1
        if x == 1:
            for j in range(y, m+1):
                map[1][j] = -1
        if y == 1:
            for i in range(x, n+1):
                map[i][1] = -1
    map[1][0] = 1
    # print(map)
    for i in range(1, n+1):
        for j in range(1, m+1):
            if map[i][j] == -1:
                map[i][j] = 0
                continue
            if i >= 1 and j >= 1:
                map[i][j] = ((map[i-1][j] % divide_num) + (map[i][j-1] % divide_num)) % divide_num

    # print(map)
    answer = map[n][m]
    return answer