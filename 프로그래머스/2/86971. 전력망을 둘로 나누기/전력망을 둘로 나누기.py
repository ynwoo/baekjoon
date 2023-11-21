from collections import deque
def bfs(start, visited, tree, n):
    # print("bfs tree {}".format(tree))
    # print(visited)
    result = 0
    queue = deque()
    queue.append(start)
    result += 1
    visited[start] = True
    while(queue):
        next = queue.popleft()
        for i in range(1, n+1):
            if tree[next][i] == 1 and not visited[i]:
                visited[i] = True
                queue.append(i)
                result += 1
    return result
    

def solution(n, wires):
    answer = float('inf')
    tree = [[0] * (n+1) for _ in range(n+1)]
    
    for wire in wires:
        tree[wire[0]][wire[1]] = tree[wire[1]][wire[0]] = 1
    
    # print(tree)
        
    for wire in wires:
        tree[wire[0]][wire[1]] = tree[wire[1]][wire[0]] = 0
        visited = [False for _ in range(n+1)] 
        first = wire[0]
        second = wire[1]
        
        first_cnt = bfs(first, visited, tree, n)
        second_cnt = bfs(second, visited, tree, n)
        
        answer = min(answer, abs(first_cnt - second_cnt))
        # print("first: {} second: {}".format(first, second))
        # print(first_cnt, second_cnt)
        tree[wire[0]][wire[1]] = tree[wire[1]][wire[0]] = 1
    return answer