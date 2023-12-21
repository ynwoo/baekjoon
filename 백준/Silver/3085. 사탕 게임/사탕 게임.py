from sys import stdin
input = stdin.readline

def get_max(n, board):
  max_val = 0
  for i in range(n):
    pivot = board[i][0]
    cnt = 0
    for j in range(n):
      if board[i][j] == pivot:
        cnt += 1
      else:
        max_val = max(max_val, cnt)
        cnt = 1
        pivot = board[i][j]
    max_val = max(max_val, cnt)
    cnt = 0

  for j in range(n):
    pivot = board[0][j]
    cnt = 0
    for i in range(n):
      if board[i][j] == pivot:
        cnt += 1
      else:
        max_val = max(max_val, cnt)
        cnt = 1
        pivot = board[i][j]
    max_val = max(max_val, cnt)
    cnt = 0
    
  return max_val
board = []
n = int(input())
for _ in range(n):
  board.append(list(input().rstrip()))

answer = 0
for i in range(n):
  for j in range(n-1):
    if board[i][j] != board[i][j+1]:
      board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
      # 최대값 구하기
      answer = max(answer, get_max(n, board))
      board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
      
for i in range(n-1):
  for j in range(n):
    if board[i][j] != board[i+1][j]:
      board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
      # 최대값 구하기
      answer = max(answer, get_max(n, board))
      board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
print(answer)