import heapq
def solution(n, works):
    heap = []
    answer = 0
    
    for work in works:
        heapq.heappush(heap, -work)
    
    # print(heap)
    for i in range(n):
        tmp = heapq.heappop(heap) + 1
        if tmp == 1:
            break
        heapq.heappush(heap, tmp)
    
    # print(heap)
    for h in heap:
        answer += h**2
    return answer