from sys import stdin


def cut(fi, fj, N):
    global w, w_c, b_c
    tmp = w[fi][fj]
    for i in range(fi, fi + N):
        for j in range(fj, fj + N):
            if tmp != w[i][j]:
                cut(fi, fj, N//2)
                cut(fi, fj + N//2, N // 2)
                cut(fi + N//2, fj, N // 2)
                cut(fi + N//2, fj + N//2, N // 2)
                return

    if w[fi][fj] == 1:
        b_c +=1
    else:
        w_c +=1
    return


n = int(stdin.readline().strip())
w = []
w_c = 0
b_c = 0
for _ in range(n):
    tmp = list(map(int, stdin.readline().strip().split()))
    w.append(tmp)

cut(0, 0, n)
print(w_c)
print(b_c)
