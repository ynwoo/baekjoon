from collections import deque


def solution(skill, skill_trees):
    answer = 0
    
    for skill_tree in skill_trees:
        stack = deque(skill)
        flag = True
        
        for ch in skill_tree:
            top = stack[0]
                
            if ch in stack and ch != top:  # ch를 꺼낼 수 없으면
                flag = False
                break
                
            elif ch == top:
                stack.popleft()
                if not stack:
                    break
        if flag:
            answer+=1
        
            
        
    return answer