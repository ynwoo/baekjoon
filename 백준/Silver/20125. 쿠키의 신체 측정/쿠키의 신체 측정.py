from sys import stdin
input = stdin.readline

n = int(input())
board = [["_" for i in range(n+1)]]
answer = []

for i in range(n):
  board.append(["_"] + list(input().strip()))

head_x, head_y = 0, 0
flag = False
for i in range(1,n+1):
  for j in range(1,n+1):
    if board[i][j] == "*":
      head_x, head_y = i, j
      flag = True
      break
  if flag:
    break
heart_x, heart_y = head_x + 1, head_y
print(heart_x, heart_y)

cnt = 0
for j in range(heart_y - 1, 0, -1):
  if board[heart_x][j] == "*":
    cnt += 1
  else:
    break
answer.append(cnt)

cnt = 0
for j in range(heart_y + 1, n+1):
  if board[heart_x][j] == "*":
      cnt += 1
  else:
    break
answer.append(cnt)

cnt = 0
body_x, body_y = 0, heart_y
for i in range(heart_x+1, n+1):
  if board[i][heart_y] == "*":
        cnt += 1
  else:
    body_x = i - 1
    break
answer.append(cnt)

cnt = 0
left_x, left_y = body_x + 1, body_y - 1
for i in range(left_x, n+1):
  if board[i][left_y] == "*":
    cnt += 1
  else:
    break
answer.append(cnt)

cnt = 0
right_x, right_y = body_x + 1, body_y + 1
for i in range(right_x, n+1):
  if board[i][right_y] == "*":
    cnt += 1
  else:
    break
answer.append(cnt)

print(*answer)