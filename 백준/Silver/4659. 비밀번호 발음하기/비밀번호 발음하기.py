from sys import stdin
input = stdin.readline
password = ""
a = ['a','e','i', 'o', 'u']
while True:
  password = input().rstrip()
  if password == "end":
    break
  flag = False
  for c in password:
    if c in a:
      flag = True
      break
  if flag:
    if len(password) >= 3:
      for i in range(len(password) - 2):
        if password[i] in a and password[i+1] in a and password[i+2] in a:
          flag = False
          break
  
        if password[i] not in a and password[i+1] not in a and password[i+2] not in a:
          flag = False
          break
  
    if len(password) >= 2:
      for i in range(len(password) - 1):
        if password[i] == password[i+1] and password[i] != 'o' and password[i] != 'e':
          flag = False
          break
  
  if flag:
    print(f"<{password}> is acceptable.")
  else:
    print(f"<{password}> is not acceptable.")