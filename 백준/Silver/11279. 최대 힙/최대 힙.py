from sys import stdin


class heap:
    def __init__(self):
        self.arr = [-1] * 100001
        self.size = 0

    def insert(self, data):
        self.size += 1
        here = self.size

        while here != 1 and data > self.arr[here//2]:
            self.arr[here] = self.arr[here//2]
            here //= 2
        self.arr[here] = data

    def deleteData(self):
        if self.size == 0:
            return 0
        ret = self.arr[1]
        self.arr[1] = self.arr[self.size]
        self.size -= 1
        parent = 1

        while True:
            child = parent * 2
            if child + 1 <= self.size and self.arr[child] < self.arr[child + 1]:
                child += 1

            if child > self.size or self.arr[child] < self.arr[parent]:
                break

            self.arr[parent], self.arr[child] = self.arr[child], self.arr[parent]
            parent = child
        return ret


n = int(stdin.readline().strip())
h = heap()
answer = []
# print(h.size)
for i in range(n):
    c = int(stdin.readline().strip())
    if c == 0:
        r = h.deleteData()
        answer.append(r)
    else:
        h.insert(c)

for i in answer:
    print(i)
