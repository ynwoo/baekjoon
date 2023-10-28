n=int(input())

l=[-1,0,1,1]


for i in range(4,n+1):
    tmp_list = []
    if i % 3 == 0:
        tmp_list.append([l[i//3],i//3])
    if i % 2 == 0:
        tmp_list.append([l[i//2], i//2])

    tmp_list.append([l[i-1],i-1])
    #print(tmp_list)
    tt = min(tmp_list)
    tmp = tt[0] + 1
    l.insert(i, tmp)

answer = [n]
m = n
while m != 1:
    tmp_list = []
    if m % 3 == 0:
        tmp_list.append([l[m//3],m//3])
    if m % 2 == 0:
        tmp_list.append([l[m//2], m//2])

    tmp_list.append([l[m-1],m-1])
    #print(tmp_list)
    tt = min(tmp_list)
    #print(tt)
    answer.append(tt[1])
    m = tt[1]

print(l[n])
for item in answer:
    print(item,end= ' ')