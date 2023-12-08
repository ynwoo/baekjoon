from sys import stdin
input = stdin.readline

words = []
x = int(input())
word = input().rstrip()
words.append(word)
for i in range(x):
  first  = ""
  second = ""
  for j in range(len(word)):
    if j % 2 == 0:
      first += word[j]
    else:
      second += word[j]
  second = second[::-1]
  word = first + second
  if word not in words:
    words.append(word)
  else:
    break

if i > x:
  print(words[i-1])
else:
  print(words[x%len(words)])