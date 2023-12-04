from sys import stdin
input = stdin.readline

candidate = []
for i in range(123, 987 + 1):
  if (i // 100) != (i % 100) // 10 and (i % 100) // 10 != i % 10 and (i // 100) != i % 10 and (i % 100) // 10 != 0 and i % 10 != 0:
    candidate.append(i)
# print(candidate)
n = int(input())

def check(q, s, b, candidate):
  for c in candidate[:]:
    s_cnt = 0
    b_cnt = 0
    if c // 100 == q // 100:
      s_cnt += 1
    elif c // 100 == (q % 100) // 10:
      b_cnt += 1
    elif c // 100 == q % 10:
      b_cnt += 1

    if (c % 100) // 10 == (q % 100) // 10:
      s_cnt += 1
    elif (c % 100) // 10 == q // 100:
      b_cnt += 1
    elif (c % 100) // 10 == q % 10:
      b_cnt += 1

    if c % 10 == q % 10:
      s_cnt += 1
    elif c % 10 == q // 100:
      b_cnt += 1
    elif c % 10 == (q % 100) // 10:
      b_cnt += 1
      
    if s_cnt != s or b_cnt != b:
      candidate.remove(c)

  return candidate
  
for i in range(n):
  q, s, b = map(int,input().split())
  candidate = check(q, s, b, candidate)

print(len(candidate))