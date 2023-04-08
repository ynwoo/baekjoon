import sys


n = int(sys.stdin.readline())
arr = list(map(int,sys.stdin.readline().split()))
arr.sort()

t = []
s = 0
for e in arr:
    s += e
    t.append(s)

print(sum(t))
