from sys import stdin
input = stdin.readline

n, c = map(int, input().split())
house = []
answer = 0

for _ in range(n):
  house.append(int(input()))
house.sort()


def binary_search(house):
  start = 1
  end = house[-1] - house[0]

  while start <= end:
    mid = (start + end) // 2
    count = 1
    current_house = house[0]

    for i in range(1, len(house)):
      if house[i] >= current_house + mid:
        count += 1
        current_house = house[i]

    if count >= c:
      global answer
      answer = mid
      start = mid + 1
    else:
      end = mid - 1

binary_search(house)
print(answer)