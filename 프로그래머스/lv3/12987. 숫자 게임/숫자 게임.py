def solution(A, B):
    answer = 0
    A.sort()
    B.sort()
    i, j = 0, 0
    l    = len(A)
    
    while j != l:
        if A[i] < B[j]:
            answer += 1
            i += 1

        j += 1
            
    return answer