def solution(s, skip, index):
    answer = ''
    skip_list = list(skip)
    print(skip_list)
    for c in s:
        cnt = 0
        new_c = c
        while cnt < index:
            if new_c == 'z':
                new_c = 'a'
            else:
                new_c = chr(ord(new_c) + 1)
            if new_c not in skip_list:
                cnt += 1
        # print(new_c)
        answer += new_c
    return answer