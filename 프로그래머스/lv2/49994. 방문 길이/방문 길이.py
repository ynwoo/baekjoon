def solution(dirs):
    s = set()
    dic = {'U':(0,1), 'D':(0,-1), 'L':(-1,0), 'R':(1,0)}
    x, y = 0, 0
    
    for dir in dirs:
        nx, ny = x + dic[dir][0], y + dic[dir][1]  # 새 위치
        if -5 <= nx <= 5 and -5 <= ny <= 5:  # 유효한 움직임만
            s.add((x, y, nx, ny))
            s.add((nx, ny, x, y))
            x, y = nx, ny
    
    return len(s)//2