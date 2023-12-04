from sys import stdin
input = stdin.readline

coordinate = [[0] * 100 for i in range(100)]

for _ in range(4):
  x1,y1,x2,y2 = map(int,input().rstrip().split())
  for i in range(x1,x2):
    for j in range(y1,y2):
      coordinate[i][j] = 1

answer = 0
for i in range(100):
  for j in range(100):
    if coordinate[i][j] == 1:
      answer += 1
print(answer)