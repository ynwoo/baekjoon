import heapq
n,k = map(int,input().split())
j = []
b = []
for i in range(n):
  m,v = map(int,input().split())
  j.append((m,v))
j.sort(key=lambda x:x[0])

for i in range(k):
  ki = int(input())
  b.append(ki)
b.sort()  
# print(j)
# print(b)

h = []
answer=0
idx = 0

for bag in b:
  while idx < n and bag >= j[idx][0]:
    v = j[idx][1]
    heapq.heappush(h,(-v, v))
    idx +=1

  if h:
    tmp = heapq.heappop(h)[1]
    answer+=tmp
  elif idx >= k:
    break

print(answer)