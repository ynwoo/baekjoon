from sys import stdin
import math
input = stdin.readline

is_prime = [True] * (1000000+1)
is_prime[0] = is_prime[1] = False

for i in range(2, int(math.sqrt(1000000)) + 1):
  if is_prime[i]:
    j = 2

    while i * j <= 1000000:
      is_prime[i*j] = False
      j += 1


while True:
  n = int(input())
  if n == 0:
    break

  start = 3
  end = n
  while start < end:
    while not is_prime[start] or start % 2 == 0:
      start += 1

    while not is_prime[end] or end % 2 == 0:
      end -= 1

    if n == start + end:
      print(f"{n} = {start} + {end}")
      break
    elif n < start + end:
      end -= 1
    else:
      start += 1