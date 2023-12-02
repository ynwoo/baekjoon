n = int(input())
city = list(map(int, input().split()))
city.sort()
m = int(input())

start = 1
end = city[-1]
while start <= end:
  mid = (start + end) // 2
  # print(start, mid, end)
  s = 0
  for c in city:
    if c < mid:
      s += c
    else:
      s += mid

  if s > m:
    end = mid - 1
  else:
    start = mid + 1
print(end)