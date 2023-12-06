from sys import stdin

input = stdin.readline
students = {}
k, l = map(int,input().split())

for _ in range(l):
  id = input().rstrip()
  if id not in students:
    students[id] = 0
  else:
    del students[id]
    students[id] = 0
  # print(students)

i = 0
for id in students.keys():
  if i < k:
    print(id)
  else:
    break
  i += 1