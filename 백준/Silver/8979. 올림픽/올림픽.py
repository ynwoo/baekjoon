from sys import stdin
input = stdin.readline

n, k = map(int,input().split())
orders = []
for _ in range(n):
  country = list(map(int,input().split()))
  orders.append(country)

orders.sort(key = lambda x : (-x[1], -x[2], -x[3]))
# print(orders)

answer = 1
g, s, b = orders[0][1:]
cnt = 0
# print(g,s,b)
for order in orders:
  # print(order[1:])
  # print([g,s,b])
  if order[1:] == [g,s,b]:
    cnt += 1
  else:
    answer += cnt
    cnt = 1
    g, s, b = order[1:]

  if order[0] == k:
    break

print(answer)