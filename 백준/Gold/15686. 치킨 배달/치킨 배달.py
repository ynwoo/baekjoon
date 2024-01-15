from sys import stdin
from itertools import combinations
input = stdin.readline

n, m = map(int, input().split())
city = [list(map(int, input().split())) for _ in range(n)]

chicken = []
for i in range(n):
  for j in range(n):
    if city[i][j] == 2:
      chicken.append((i,j))

min_distance = float('INF')
    
for points in combinations(chicken, m):
  distance = 0
  for i in range(n):
    for j in range(n):
      if city[i][j] == 1:
        m_d = float('INF')
        for point in points:
          m_d = min(m_d, (abs(i-point[0]) + abs(j-point[1])))
        distance += m_d 

  min_distance = min(min_distance, distance)

print(min_distance)