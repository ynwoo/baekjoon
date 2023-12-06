from sys import stdin

input = stdin.readline

h, w = map(int,input().split())

board = [[0] * w for _ in range(h)]

block = list(map(int,input().split()))

for j in range(w):
  for i in range(-block[j], 0):
    board[i][j] = 1
# print(board)

answer = 0
for i in range(h-1, -1, -1):
  cnt = 0
  ready = False
  for j in range(w):
    if board[i][j] == 1 and not ready:
      ready = True
    elif board[i][j] == 1 and ready:
      answer += cnt
      cnt = 0
    elif board[i][j] == 0 and ready:
      cnt += 1
  # print(answer)
print(answer)