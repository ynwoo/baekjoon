n = int(input())
for i in range(n):
    s = input()
    temp = []
    answer = "YES"
    l = len(s)
    for j in range(l):
        if s[j] == "(":
            temp.append(s[j])
        else:
            if len(temp) == 0:
                answer = "NO"
            else:
                temp.pop()
    
    if len(temp) != 0:
        answer = "NO"
    
    print(answer)
            