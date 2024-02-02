from sys import stdin
from collections import deque
input = stdin.readline

F, S, G, U, D = map(int ,input().split())

min_button = [float('INF') for _ in range(F+1)]

queue = deque()

queue.append(S)
min_button[S] = 0

while queue:
  size = len(queue)
  while size > 0:
    cur = queue.popleft()
    size -= 1
    if G == cur:
      # print(min_button)
      print(min_button[cur])
      exit()

    if cur - D >= 1 and min_button[cur-D] > min_button[cur] + 1:
      queue.append(cur-D)
      min_button[cur-D] = min_button[cur] + 1
      
    if cur + U <= F and min_button[cur+U] > min_button[cur] + 1:
      queue.append(cur+U)
      min_button[cur+U] = min_button[cur] + 1
    
print("use the stairs")