from collections import defaultdict, deque

def solution(tickets):
    answer = []
    graph = defaultdict(list)
    
    for start, end in tickets:
        graph[start].append(end)

    for start in graph.keys():
        graph[start].sort(reverse=True)
    
    stack = deque(['ICN'])
    while stack:
        top = stack.pop()
        
        if top in graph and graph[top]:
            stack.append(top)
            stack.append(graph[top].pop())
        else:
            answer.append(top)
            
    return answer[::-1]
