from sys import stdin
input = stdin.readline

while True:
  sides = list(map(int,input().split()))
  if sides[0] == sides[1] == sides[2] == 0:
    break
  sides.sort()
  if sides[0] + sides[1] <= sides[2]:
    print("Invalid")
  elif sides[0] == sides[1] == sides[2]:
    print("Equilateral")
  elif sides[0] != sides[1] and sides[1]!= sides[2] and sides[0] != sides[2]:
    print("Scalene")
  else:
    print("Isosceles")