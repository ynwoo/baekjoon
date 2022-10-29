testCasenum = int(input())
answer = []
for i in range(testCasenum):
    n, m = map(int, input().split())
    l = list(map(int, input().split()))
    cnt = 0
    idx = m
    while idx != -1:
        M = max(l)
        if l[0] >= M:
            l.pop(0)
            cnt += 1
            idx -= 1
        else:
            l.append(l.pop(0))  # 큐 맨 앞에 있는거 뒤로 보내기
            idx = idx - 1
            if idx == -1:
                idx = len(l) - 1
    answer.append(cnt)
    # print(l)
for a in answer:
    print(a)
