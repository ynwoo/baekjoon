def solution(food):
    answer = ''
    l = len(food)
    for i in range(1,l):
        answer += (str(i) * (food[i]//2))
    
    answer = answer + '0' + answer[::-1]
        
    return answer