def solution(s):
    answer = []
    
    s = s[2:-2].split('},{')
    arr = []
    for item in s:
        tmp = list(map(int,item.split(',')))
        arr.append(tmp)
    
    arr.sort(key = lambda x : len(x))
    # print(arr)
    
    for item in arr:
        # print(item)
        for num in item:
            if num not in answer:
                answer.append(num)
    
    return answer