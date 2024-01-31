from sys import stdin
input = stdin.readline

n = int(input())
cute = 0
not_cute = 0
for i in range(n):
  x = int(input())
  if x == 1:
    cute += 1
  else:
    not_cute += 1
if cute > not_cute:
  print("Junhee is cute!")
else:
  print("Junhee is not cute!")