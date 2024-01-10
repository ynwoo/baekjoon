from sys import stdin
input = stdin.readline

n = int(input())
numbers = []
for _ in range(n):
  numbers += list(map(int, input().split()))
  numbers.sort(reverse=True)
  numbers = numbers[:n]
print(numbers[n-1])