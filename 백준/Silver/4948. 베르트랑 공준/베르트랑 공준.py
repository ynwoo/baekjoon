n = 123456 * 2
a = [False,False] + [True]*(n-1)
primes=[]

for i in range(2,n+1):
  if a[i]:
    primes.append(i)
    for j in range(2*i, n+1, i):
        a[j] = False

while True:
    a = int(input())
    cnt = 0
    if a == 0:
        break

    for p in primes:
        if a < p <=a*2:
            cnt += 1
    print(cnt)