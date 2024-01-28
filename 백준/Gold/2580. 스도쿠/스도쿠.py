from sys import stdin
import sys
input = stdin.readline

board = []
zeros = []
for _ in range(9):
  line = list(map(int, input().split()))
  board.append(line)

for i in range(9):
  for j in range(9):
    if board[i][j] == 0:
      zeros.append((i,j))

def check(x, y, n):
  for i in range(9):
    if n == board[x][i]:
      return False
    if n == board[i][y]:
      return False

  for i in range(3 * (x//3), 3 * (x//3) + 3):
    for j in range(3 * (y//3), 3 * (y//3) + 3):
      if n == board[i][j]:
        return False
    
  return True
  
def dfs(i):
  if i == len(zeros):
    for j in range(9):
      print(*board[j])
    sys.exit()

  x, y = zeros[i]
  for number in range(1,10):
    # check 스도쿠
    # 1. 조건 성립하면 dfs(i+1)
    # 2. 그렇지 않으면 continue
    if check(x, y, number):
      board[x][y] = number
      dfs(i+1)
      board[x][y] = 0
      
dfs(0)