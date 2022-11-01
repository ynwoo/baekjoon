def solution(dirs):
    answer = 0
    visited = []
    c_x = 0
    c_y = 0
    
    for dir in dirs:
        if dir == 'U':  # 위로 움직이는 경우
            if c_y + 1 <= 5:
                n_x = c_x
                n_y = c_y + 1
                if [c_x, c_y, n_x, n_y] not in visited:
                    visited.append([c_x, c_y, n_x, n_y])
                    visited.append([n_x, n_y, c_x, c_y])
                    answer += 1
                c_x = n_x
                c_y = n_y
            else:
                continue
        elif dir == 'D':  # 아래로 움직이는 경우
            if c_y - 1 >= -5:
                n_x = c_x
                n_y = c_y - 1
                if [c_x, c_y, n_x, n_y] not in visited:
                    visited.append([c_x, c_y, n_x, n_y])
                    visited.append([n_x, n_y, c_x, c_y])
                    answer += 1
                c_x = n_x
                c_y = n_y
            else:
                continue
        elif dir == 'L':  # 왼쪽으로 움직이는 경우
            if c_x - 1 >= -5:
                n_x = c_x - 1
                n_y = c_y
                if [c_x, c_y, n_x, n_y] not in visited:
                    visited.append([c_x, c_y, n_x, n_y])
                    visited.append([n_x, n_y, c_x, c_y])
                    answer += 1
                c_x = n_x
                c_y = n_y
            else:
                continue
        else:  # 오른쪽으로 움직이는 경우
            if c_x + 1 <= 5:
                n_x = c_x + 1
                n_y = c_y
                if [c_x, c_y, n_x, n_y] not in visited:
                    visited.append([c_x, c_y, n_x, n_y])
                    visited.append([n_x, n_y, c_x, c_y])
                    answer += 1
                c_x = n_x
                c_y = n_y
            else:
                continue
                    
    return answer