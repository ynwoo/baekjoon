def solution(board, moves):
    answer = 0
    stack = []
    
    for move in moves:
        for i in range(len(board)):
            a = board[i][move-1]
            if a != 0:
                board[i][move-1] = 0
                if stack:
                    tmp = stack.pop()
                    if a == tmp:
                        answer+=2
                    else:
                        stack.append(tmp)
                        stack.append(a)
                else:
                    stack.append(a)
                break
        
    return answer
