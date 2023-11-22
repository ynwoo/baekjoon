import heapq


def solution(jobs):
    answer = 0
    last_time = -1
    current_time = 0
    cnt = 0
    heap = []
    
    while cnt < len(jobs):
        for job in jobs:
            if last_time < job[0] and job[0] <= current_time:
                heapq.heappush(heap, [job[1], job[0]])
        
        if len(heap) > 0:
            r = heapq.heappop(heap)
            print(r)
            print(last_time, current_time)
            cnt += 1
            last_time = current_time
            current_time += r[0]
            answer += current_time - r[1]
        else:
            current_time += 1
        
    
    return answer // len(jobs)