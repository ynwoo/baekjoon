import sys

n=int(input())
queue=[]
for i in range(n):
    command = sys.stdin.readline().rstrip()
    l = len(queue)
    if(command == "pop"):
        if(l == 0):
            print(-1)
        else:
            print(queue.pop())
    elif(command == "size"):
        print(l)
    elif(command == "empty"):
        if(l==0):
            print(1)
        else:
            print(0)
    elif(command == "top"):
        if(l==0):
            print(-1)
        else:
            print(queue[l-1])
    elif command == "front":
        if(l==0):
            print(-1)
        else:
            print(queue[l-1])
    elif command == "back":
        if(l==0):
            print(-1)
        else:
            print(queue[0])
    else:
        command,n = command.split()
        n=int(n)
        queue.insert(0,n)
    