from sys import stdin
input = stdin.readline
n = int(input())
arr = list(map(int,input().split()))
arr.sort()
x = int(input())

answer = 0

start = 0
end = n - 1

while start < end:
    if arr[start] + arr[end] == x:
        answer += 1
        start += 1
    elif arr[start] + arr[end] > x:
        end -= 1
    else:
        start += 1

print(answer)
    
