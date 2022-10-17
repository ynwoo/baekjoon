def dfs(i, j, Map, visited):
  global w, h
  dij = [-1,0,1]
  for a in dij:
    for b in dij:
      # 이동할 곳이 유효한 경우에만
      if i+a >= 0 and i+a < h and j+b >= 0 and j+b < w:
        if not visited[i+a][j+b] and Map[i+a][j+b] == 1:
          visited[i+a][j+b] = True
          dfs(i+a, j+b, Map, visited)


w, h = map(int,input().split())

while w!=0 or h!=0:
  Map = []
  cnt = 0
  visited = [[False] * w for _ in range(h)]
  for i in range(h):
    Map.append(list(map(int,input().split())))
 
  for i in range(h):
    for j in range(w):
      if not visited[i][j] and Map[i][j] == 1:
        visited[i][j] = True
        cnt+=1
        dfs(i,j, Map, visited)
        
  print(cnt)
  w, h = map(int,input().split())