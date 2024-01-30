from sys import stdin
input = stdin.readline

subjects = []
for _ in range(20):
  subjects.append(input().split())

g = 0
s = 0

for i in range(20):
  name, num, grade = subjects[i]
  if grade == 'A+':
    g +=  (float(num) * 4.5)
  elif grade == 'A0':
    g +=  (float(num) * 4.0)
  elif grade == 'B+':
    g +=  (float(num) * 3.5)
  elif grade == 'B0':
    g +=  (float(num) * 3.0)
  elif grade == 'C+':
    g +=  (float(num) * 2.5)
  elif grade == 'C0':
    g +=  (float(num) * 2.0)
  elif grade == 'D+':
    g +=  (float(num) * 1.5)
  elif grade == 'D0':
    g +=  (float(num) * 1.0)
  elif grade == 'F':
    g +=  (float(num) * 0.0)
  else:
    continue
  s += float(num)
  
print(g/s)