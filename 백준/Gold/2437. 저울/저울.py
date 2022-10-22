n = int(input())
arr = list(map(int,input().split()))
arr.sort()

answer=1

for i in arr:
    if answer < i:
        break
    answer+=i

print(answer)