n, m = map(int,input().split())
square = []
answer = 0
for i in range(n):
  square.append(list(map(int, input())))

l = min(n,m)
for size in range(l):
  for i in range(n - size):
    for j in range(m - size):
      # square[i][j] ~ square[i+size][j+size]
      if square[i][j] == square[i+size][j+size] and square[i][j] == square[i+size][j] \
      and square[i][j] == square[i][j+size]:
        answer = (size + 1) ** 2
  
print(answer)