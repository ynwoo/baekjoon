s = input()
stack = []
answer = 0

for i in range(len(s)):
  if s[i] == '(':
    stack.append(s[i])
  else:
    if s[i-1] == '(':
      stack.pop()
      answer+=len(stack)
    else:
      stack.pop()
      answer += 1

print(answer)
