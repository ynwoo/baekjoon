from collections import Counter
from sys import stdin
input = stdin.readline

n, m = map(int, input().split())
words = []
for _ in range(n):
  word = input().rstrip()
  if len(word) >= m:
    words.append(word)

words = Counter(words)
sorted_words = sorted(words.items(), key = lambda x : (-x[1], -len(x[0]), x[0]))

for word, count in sorted_words:
  print(word)