from sys import stdin
from collections import deque

class node:
    def __init__(self):
        self.n = 0
        self.next = []
        self.visited = False

    def __lt__(self, other):
        return self.n < other.n


def dfs(no, v: int):
    print(no[v-1].n, end=' ')  # 방문
    no[v-1].visited = True
    for a in no[v-1].next:
        if not a.visited:
            dfs(no, a.n)


def bfs(no, v: int):
    Queue = deque([no[v-1]])
    while Queue:
        tmp = Queue.popleft()
        if not tmp.visited:
            print(tmp.n, end=' ')  # 방문
            tmp.visited = True
            for a in tmp.next:
                Queue.append(a)



n, m, v = map(int, stdin.readline().strip().split())
no = []
for i in range(n):
    tmp = node()
    tmp.n = i + 1
    no.append(tmp)

for i in range(m):
    n1, n2 = map(int, stdin.readline().strip().split())
    no[n1-1].next.append(no[n2-1])
    no[n2-1].next.append(no[n1-1])

for a in no:
    a.next = sorted(a.next)

dfs(no, v)
print('')
for a in no:
    a.visited = False
bfs(no, v)
