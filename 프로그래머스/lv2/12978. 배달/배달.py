def get_smallest_node(N):
    min_value = INF
    idx = 0
    for i in range(1,N+1):
        if not visited[i] and distance[i] < min_value:
            min_value = distance[i]
            idx = i
            
    return idx

def dijkstra(start, N):
    distance[start] = 0  # 시작노드 거리 계산 및 방문처리
    visited[start]  = True
    
    for idx, d in enumerate(matrix[start]):
        distance[idx] = d
        
    for _ in range(N-1):
        closest_idx = get_smallest_node(N)
        visited[closest_idx] = True
        for idx, next in enumerate(matrix[closest_idx]):
            cost = distance[closest_idx] + next
            if cost < distance[idx]:
                distance[idx] = cost
    
def solution(N, road, K):
    global INF, matrix, visited, distance
    INF = float('inf')
    answer = 0
    matrix = [[INF] * (N+1) for _ in range(N+1)]
    visited = [False] * (N+1)
    distance = [INF] * (N+1)
    
    for r in road:
        if matrix[r[0]][r[1]] > r[2]:
            matrix[r[0]][r[1]] = matrix[r[1]][r[0]] = r[2]
    for i in range(1, N+1):
        matrix[i][i] = 0
        
    dijkstra(1, N)
    
    for i in range(1, N+1):
        if distance[i] <= K:
            answer += 1
    
    return answer
