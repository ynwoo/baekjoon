def solution(n, left, right):
    answer = []
    
    # arr = [[0] * n for _ in range(n)]
    # for i in range(n):
    #     for j in range(n):
    #         answer.append(max(i,j)+1)
    
    i = left//n
    j = left%n
    
    while i != right//n or j != right%n:
        answer.append(max(i,j)+1)
        j+=1
        if j == n:
            i+=1
            j=0
    answer.append(max(i,j)+1)
    # for i in range(n):
    
        
    return answer