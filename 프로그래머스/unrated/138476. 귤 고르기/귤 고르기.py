import collections

def solution(k, tangerine):
    answer = 0
    count = collections.defaultdict(int) 
    for t in tangerine:
        count[t] += 1
        
    sorted_count = dict(sorted(count.items(), key=lambda kkk: kkk[1], reverse=True))
    for key, value in sorted_count.items():
        if k >= value:
            k -= value
            answer += 1
        elif k != 0:
            answer += 1
            break
        else:
            break
    return answer