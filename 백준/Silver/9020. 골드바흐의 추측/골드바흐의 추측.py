import math


def is_prime_number(n):
    # 2 to n
    array = [True for i in range(n+1)]
    
    for i in range(2, int(math.sqrt(n)) + 1):
      if array[i] == True:
        j = 2
        while i * j <= n:
          array[i * j] = False
          j += 1

    return [ i for i in range(2, n+1) if array[i] ]


arr = is_prime_number(10000)

T = int(input())
for _ in range(T):
  n = int(input())
  a = n//2
  b = n//2
  while a not in arr or b not in arr:
    a-=1
    b+=1
  print(a, b)
