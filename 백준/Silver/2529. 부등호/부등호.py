from sys import stdin
from itertools import combinations, permutations
input = stdin.readline
  
numbers = [i for i in range(10)]

k = int(input())
sign = input().split()

maximum = str(0)
minimum = str(10**12)
for comb in combinations(numbers, k+1):
  for perm in permutations(comb, k+1):
    # perm and sign 조건 만족하면 숫자로 만들어서 최댓값, 최솟값 비교
    flag = True
    for i in range(k):
      if (sign[i] == '<' and perm[i] > perm[i+1]) or \
      (sign[i] == '>' and perm[i] < perm[i+1]):
        flag = False
        break

    if flag:
      str_n = ''.join(map(str, perm))
      if int(maximum) < int(str_n):
        maximum = str_n
      if int(minimum) > int(str_n):
        minimum = str_n

print(maximum)
print(minimum)