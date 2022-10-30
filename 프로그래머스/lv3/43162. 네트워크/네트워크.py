def dfs(v, dfs_visited, n, computers):
    dfs_visited[v] = True
    for i in range(n):
      if not dfs_visited[i] and computers[v][i] == 1:
        dfs(i, dfs_visited, n, computers)
        

def solution(n, computers):
    answer = 0    
    dfs_visited = [False] * n
    
    for i in range(n):
        if not dfs_visited[i]:
            dfs(i, dfs_visited, n, computers)
            answer+=1

    return answer

