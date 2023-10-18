import itertools

def isPrime(n):
    if n <= 1:
        return False
    for i in range(2, int(n/2) + 1):
        if n % i == 0:
            return False
    return True
        
def solution(numbers):
    answer = 0
    case_list = set()
    for i in range(1, len(numbers) + 1):
        nPi = itertools.permutations(list(numbers), i)
        for case in list(nPi):
            # print(int(''.join(case)))
            case_list.add(int(''.join(case)))
    
    # print(case_list)    
    for case in case_list:
        if isPrime(case):
            answer += 1
        
    return answer