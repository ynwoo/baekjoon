def DFS(numbers, i, v):
    global answer, l, t
    
    if i == l:
        if v == t:
            answer += 1
        return
    
    DFS(numbers,i+1, v + numbers[i])
    DFS(numbers,i+1, v - numbers[i])
    return
    
    
def solution(numbers, target):
    global answer, l, t
    answer = 0
    l = len(numbers)
    t = target
    
    v = 0
    DFS(numbers, 0, v)
    
    return answer