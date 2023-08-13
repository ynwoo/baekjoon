import math
def solution(number, limit, power):
    answer = 0
    
    for i in range(1, number + 1):
        divisor_cnt = get_divisor_cnt(i)
        if divisor_cnt <= limit:
            answer += divisor_cnt
        else:
            answer += power
    return answer

def get_divisor_cnt(number):
    result = 0
    # print(int(math.sqrt(number + 1)) + 1)
    for i in range(1, int(math.sqrt(number + 1)) + 1):
        if number / i == i:
            result -= 1
        if number % i == 0:
            result += 2
            
    return result