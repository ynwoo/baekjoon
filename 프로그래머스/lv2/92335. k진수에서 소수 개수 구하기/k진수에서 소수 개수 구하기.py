import math
def is_prime(n):
    if n == 1:
        return False
    
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True

def solution(n, k):
    answer = 0
    s = ''
    
    while n > 0:
        n, mod = divmod(n, k)
        s += str(mod)
        
    a = s[::-1]
    for p in a.split('0'):
        if p.isdigit() and is_prime(int(p)):
            answer+=1
    
    return answer