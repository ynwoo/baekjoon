from sys import stdin

n = int(stdin.readline())
a = ["0", "CY", "SK", "CY"]
b = ["0", "SK", "CY", "SK"]

for i in range(4, n+1):
  winner = b[i-1]
  if winner == "SK":
    loser = "CY"
  else:
    loser = "SK"
  a.append(winner)
  b.append(loser)
# print(a)
# print(b)
print(a[n])