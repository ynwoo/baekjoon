from sys import stdin
from collections import deque
input = stdin.readline

T = int(input())
for _ in range(T):
  p_list = list(input().rstrip())
  
  n = int(input())
  arr = input().rstrip()
  arr = [] if n == 0 else list(map(int, arr[1:-1].split(',')))

  arr = deque(arr)
  flag = False
  reverse_cnt = 0
  
  for action in p_list:
    if action == 'R':
      reverse_cnt += 1
    if action == 'D':
      if len(arr) > 0:
        if reverse_cnt % 2 == 0:
          arr.popleft()
        else:
          arr.pop()
      else:
        flag = True
        break
        
  if flag:
    print("error")
  else:
    if reverse_cnt % 2 != 0:
      arr.reverse()
      
    print('[', end = '')
    for i in range(len(arr)):
      print(arr[i], end = '')
      if i != len(arr) - 1:
        print(',', end = '')   
    print(']')