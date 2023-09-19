def solution(numbers):
    answer = []
    stack1 = []
    stack2 = []
    for n in numbers:
        stack1.append(n)
    
    while stack1:
        tmp = stack1.pop()
        while stack2:
            tmp2 = stack2.pop()
            if tmp < tmp2:
                answer.append(tmp2)
                stack2.append(tmp2)
                break
            
        if not stack2:
            answer.append(-1)
        stack2.append(tmp)
    return answer[::-1]