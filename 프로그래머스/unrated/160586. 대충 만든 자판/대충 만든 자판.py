def solution(keymap, targets):
    answer = []
    for target in targets:
        result = 0
        for t in target:
            find = t
            min_cnt = float('inf')
            for key in keymap:
                cnt = 0
                for k in key:
                    cnt += 1
                    if find == k and min_cnt > cnt: # 찾는 문자 라면
                        min_cnt = cnt
                        break
            if min_cnt == float('inf'):
                result = -1
                break
            else:
                result += min_cnt
        answer.append(result)
                        
    return answer