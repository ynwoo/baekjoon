from sys import stdin
input = stdin.readline

titles = []
characters = []

n, m = map(int, input().split())
for _ in range(n):
  title_name, title_maximum = input().split()
  title_maximum = int(title_maximum)

  titles.append((title_name, int(title_maximum)))
  
for _ in range(m):
  characters.append(int(input()))

def binary_search(c):
  start = 0
  end = len(titles)-1
  while start <= end:
    mid = (start + end) // 2
    if titles[mid][1] < c:
      start = mid + 1
    else:
      end = mid - 1
      
  return start
  
for c in characters:
  idx = binary_search(c)
  print(titles[idx][0])