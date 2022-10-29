from collections import deque
import itertools

def solution(bridge_length, weight, truck_weights):
    answer = 0
    
    bridge = deque([0] * bridge_length, maxlen=bridge_length)
    waiting = deque(truck_weights)
    
    s = 0
    
    while waiting:
        s -= bridge[0]
        s += bridge[-1]
        if s + waiting[0] <= weight:
            bridge.append(waiting.popleft())
            answer+=1
        else:
            bridge.append(0)
            answer+=1
            
    while bridge:
        bridge.popleft()
        answer+=1
        
    return answer
