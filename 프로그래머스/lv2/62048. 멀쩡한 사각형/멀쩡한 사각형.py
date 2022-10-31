import math


def solution(w,h):
    answer = 1
    n = math.gcd(w,h)
    w_prime = w//n
    h_prime = h//n
    
    answer = w * h - n * (w_prime + h_prime -1)
    return answer