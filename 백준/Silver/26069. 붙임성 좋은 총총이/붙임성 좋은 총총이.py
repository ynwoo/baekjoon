n = int(input())
answer = 1
dance_list = ['ChongChong']
for _ in range(n):
    name1, name2 = input().split()
    if name1 in dance_list and name2 not in dance_list:
        dance_list.append(name2)
        answer+=1
    elif name2 in dance_list and name1 not in dance_list:
        dance_list.append(name1)
        answer+=1
    else:
        continue

print(answer)