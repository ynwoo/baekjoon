import heapq


def solution(operations):
    answer = []
    heap = []
    for operation in operations:
        c, n = operation.split()
        if c == "I":
            heapq.heappush(heap, int(n))
        else:
            if len(heap) == 0:
                continue
            
            if n == "-1":
                heapq.heappop(heap)
            else:
                heap = heapq.nlargest(len(heap), heap)[1:]
                heapq.heapify(heap)
    
    if heap:
        answer = [heapq.nlargest(1, heap)[0], heap[0]]
    else:
        answer = [0,0]
        
    return answer