from sys import stdin
input = stdin.readline

n, x = map(int, input().split())
visitors = list(map(int,input().split()))
visitors_cnt = []
prefix_sum = sum(visitors[0:x])
visitors_cnt.append(prefix_sum)
for i in range(x, n):
  prefix_sum += visitors[i]
  prefix_sum -= visitors[i-x]
  visitors_cnt.append(prefix_sum)

max_visitor = max(visitors_cnt)
if max_visitor == 0:
  print("SAD")
else:
  print(max_visitor)
  print(visitors_cnt.count(max_visitor))