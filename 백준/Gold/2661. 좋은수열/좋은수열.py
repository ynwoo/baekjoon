from sys import stdin

n = int(input())
stack = []

l = ['1', '2', '3']

def check(stack):
  for i in range(1, len(stack)//2 + 1):
    if stack[-i:] == stack[-(i*2):-i]:
      return False
      
  return True
def dfs(i):
  if i == n:
    print(''.join(stack))
    exit()

  for number in l:
    stack.append(number)
    if check(stack):
      dfs(i+1)
    stack.pop()
      

dfs(0)