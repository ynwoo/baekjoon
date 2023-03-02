from sys import stdin
from collections import deque


class node:
    def __init__(self):
        self.n = 0
        self.next = []
        self.visited = False

    def __lt__(self, other):
        return self.n < other.n


def bfs(apple, n, m):
    cnt = 0
    Queue = deque()
    for i in range(n):
        for j in range(m):
            if apple[i][j].n == 1:
                Queue.append(apple[i][j])

    l = len(Queue)
    k = 0
    while Queue:
        tmp = Queue.popleft()
        tmp.visited = True
        for node in tmp.next:
            if (not node.visited) and node.n == 0:
                node.visited = True
                node.n = 1
                Queue.append(node)
        k += 1
        if l == k:
            cnt += 1
            l = len(Queue)
            k = 0

    return cnt - 1


m, n = map(int, stdin.readline().strip().split())
arr = []
apple = []
for i in range(n):
    arr.append(list(map(int, stdin.readline().strip().split())))

for i in range(n):
    tmp_l = []
    for j in range(m):
        tmp = node()
        tmp.n = arr[i][j]
        if tmp.n == -1:
            tmp.visited = True
        tmp_l.append(tmp)
    apple.append(tmp_l)

for i in range(n):
    for j in range(m):
        if i != 0:
            apple[i][j].next.append(apple[i-1][j])
        if j != m-1:
            apple[i][j].next.append(apple[i][j+1])
        if i != n-1:
            apple[i][j].next.append(apple[i+1][j])
        if j != 0:
            apple[i][j].next.append(apple[i][j-1])

cnt = bfs(apple, n, m)
for i in range(n):  # 만약 모든 노드들이 방문이라면 그대로 cnt출력, 그렇지 않으면 -1 출력
    for j in range(m):
        # print(apple[i][j].n, apple[i][j].visited)
        if apple[i][j].n == 0:
            cnt = -1
            break
print(cnt)
