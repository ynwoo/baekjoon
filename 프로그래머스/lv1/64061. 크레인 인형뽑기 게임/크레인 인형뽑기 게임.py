def solution(board, moves):
    answer = 0
    
    n = len(board)
    stack = []
    stack_lists = [[] for _ in range(n)]

    board.reverse()
    print(board)
    print(moves)
    for i in range(n):
        for idx, val in enumerate(board[i]):
            if val != 0:
                stack_lists[idx].append(val)
                
    print(stack_lists)
    
    
    for move in moves:
        if stack_lists[move-1]:
            b = stack_lists[move-1].pop()
            if not stack:
                stack.append(b)
            else:
                a = stack.pop()
                if a == b:
                    answer+=2
                else:
                    stack.append(a)
                    stack.append(b)
    print(stack)       
    return answer