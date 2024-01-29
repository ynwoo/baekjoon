from sys import stdin
input = stdin.readline

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
answer = 0

def dfs(cnt, board):
  global answer
  
  if cnt == 5:
    # 보드 내 최대값 과 answer값 비교
    answer = max(answer, max(map(max, board)))
    return

  # 이동
  for d in range(4):
    copied_board = [arr[:] for arr in board]
    if d == 0:
      for j in range(n):
        cur = 0
        for i in range(n):
          if copied_board[i][j] == 0:
            continue

          tmp = copied_board[i][j]
          copied_board[i][j] = 0

          if copied_board[cur][j] == 0:
            copied_board[cur][j] = tmp
          elif copied_board[cur][j] == tmp:
            copied_board[cur][j] *= 2
            cur += 1
          else:
            cur += 1
            copied_board[cur][j] = tmp
    elif d == 1:
      for j in range(n):
        cur = n - 1
        for i in range(n-1, -1, -1):
          if copied_board[i][j] == 0:
            continue

          tmp = copied_board[i][j]
          copied_board[i][j] = 0

          if copied_board[cur][j] == 0:
            copied_board[cur][j] = tmp
          elif copied_board[cur][j] == tmp:
            copied_board[cur][j] *= 2
            cur -= 1
          else:
            cur -= 1
            copied_board[cur][j] = tmp

    elif d == 2:
      for i in range(n):
        cur = 0
        for j in range(1, n):
          if copied_board[i][j] == 0:
            continue
          tmp = copied_board[i][j]
          copied_board[i][j] = 0

          if copied_board[i][cur] == 0:
            copied_board[i][cur] = tmp
          elif copied_board[i][cur] == tmp:
            copied_board[i][cur] *= 2
            cur += 1
          else:
            cur += 1
            copied_board[i][cur] = tmp
    else:
      for i in range(n):
        cur = n-1
        for j in range(n-1, -1, -1):
          if copied_board[i][j] == 0:
            continue

          tmp = copied_board[i][j]
          copied_board[i][j] = 0

          if copied_board[i][cur] == 0:
            copied_board[i][cur] = tmp
          elif copied_board[i][cur] == tmp:
            copied_board[i][cur] *= 2
            cur -= 1
          else:
            cur -= 1
            copied_board[i][cur] = tmp
            
    dfs(cnt+1, copied_board)

dfs(0, board)
print(answer)