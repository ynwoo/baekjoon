from sys import stdin

n = int(input())
arr = list(map(int, input().split()))
operators = list(map(int, input().split()))

result = arr[0]
maximum = float('-inf')
minimum = float('inf')
first_sum = sum(operators)
def dfs(i):
  global result, maximum, minimum
  if i == first_sum:
    maximum = max(maximum, result)
    minimum = min(minimum, result)
    return

  for j in range(4):
    if operators[j] == 0:
      continue
    operators[j] -= 1
    tmp = result
    if j == 0:
      result += arr[i+1]
    elif j == 1:
      result -= arr[i+1]
    elif j == 2:
      result *= arr[i+1]
    else:
      # 나누기
      if result < 0:
        result = - (abs(result) // arr[i+1])
      else:
        result //= arr[i+1]
        
    dfs(i+1)
    result = tmp
    operators[j] += 1
    
dfs(0)

print(maximum)
print(minimum)