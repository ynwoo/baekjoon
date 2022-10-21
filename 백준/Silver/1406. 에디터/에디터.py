import sys
input = sys.stdin.readline

editor = input().strip()

stack1 = []
stack2 = []
for i in editor:
  stack1.append(i)

m = int(input())

for i in range(m):
  message = input()
  command_message = message[0]
  if command_message == 'L':
    if stack1:
      stack2.append(stack1.pop())
      
  elif command_message == 'D':
    if stack2:
      stack1.append(stack2.pop())
      
  elif command_message == 'B':
    if stack1:
      stack1.pop()
      
  else:
    ch = message[2]
    stack1.append(ch)

stack2.reverse()
print(''.join(stack1+stack2))
